package io.altar.jseproject.business;

import java.util.Collection;

import io.altar.jseproject.model.Entity_;

public interface BusinessServiceInterface<T extends Entity_> {

	void create(T entity);

	void remove(T entity); //

	void edit(T entity); //

	Collection<T> getAll();
	
	 T getbyId(long id);

	 long [] getAllIds();
	
//	boolean isEmpty();
//	
//	void size();
	
}
