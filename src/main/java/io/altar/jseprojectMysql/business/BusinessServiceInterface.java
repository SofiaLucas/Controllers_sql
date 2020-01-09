package io.altar.jseprojectMysql.business;

import java.util.Collection;
import java.util.List;

import io.altar.jseprojectMysql.model.Entity_;

public interface BusinessServiceInterface<T extends Entity_> {

	void create(T entity);

	void remove(T entity); //

	void edit(T entity); //

	Collection<T> getAll();
	
	 T getbyId(long id);

	 List<Long> getAllIds();
	

	
}
