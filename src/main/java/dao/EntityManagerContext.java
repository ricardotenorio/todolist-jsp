package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerContext {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	private EntityManagerContext() {
	}
	
	public static EntityManager getInstance() {
		try {
			if(entityManagerFactory == null) {
				entityManagerFactory = Persistence.createEntityManagerFactory("TodoListPU");
			}
			entityManager = entityManagerFactory.createEntityManager();
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return entityManager;
	}
}
