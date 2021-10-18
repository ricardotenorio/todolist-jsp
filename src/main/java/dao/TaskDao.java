package dao;

import javax.persistence.EntityManager;

import entity.Task;

public class TaskDao implements Dao<Task> {

	@Override
	public void create(Task entity) throws Exception {
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
	public void update(Task entity) throws Exception {
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
	public void delete(Task entity) throws Exception {
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
	public Task getById(Long id) throws Exception {
		EntityManager entityManager = EntityManagerContext.getInstance();
		Task foundTask;

		try {
			entityManager.getTransaction().begin();
			foundTask = entityManager.find(Task.class, id);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.err.println(e);
			throw new Exception(e);
		} finally {
			entityManager.close();
		}
		
		return foundTask;
	}

}
