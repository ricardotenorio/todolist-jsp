package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import entity.Project;

public class ProjectDao implements Dao<Project>{
	
	@Override
	public void create(Project entity) throws Exception {
		EntityManager entityManager = EntityManagerContext.getInstance();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.err.println(e);
			throw new Exception(e);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void update(Project entity) throws Exception {
		EntityManager entityManager = EntityManagerContext.getInstance();

		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.err.println(e);
			throw new Exception(e);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void delete(Project entity) throws Exception {
		EntityManager entityManager = EntityManagerContext.getInstance();

		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.err.println(e);
			throw new Exception(e);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Project getById(Long id) throws Exception {
		EntityManager entityManager = EntityManagerContext.getInstance();
		Project foundProject;

		try {
			entityManager.getTransaction().begin();
			foundProject = entityManager.find(Project.class, id);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.err.println(e);
			throw new Exception(e);
		} finally {
			entityManager.close();
		}
		
		return foundProject;
	}
	
	public List<Project> getAll() throws Exception {
		List<Project> projects = new ArrayList<>();
		EntityManager entityManager = EntityManagerContext.getInstance();

        try {
			entityManager.getTransaction().begin();
			projects.addAll(entityManager.createQuery("SELECT p FROM Project p").getResultList());
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.err.println(e);
			throw new Exception(e);
		} finally {
			entityManager.close();
		}
        
        return projects;
	}
	
}
