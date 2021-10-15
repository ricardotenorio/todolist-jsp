package dao;

import java.sql.SQLException;

public interface Dao<T> {
	
	void create(T entity) throws Exception;
	
	void update(T entity) throws Exception;
	
	void delete(T entity) throws Exception;
	
	T getById(Long id) throws Exception;
	
}
