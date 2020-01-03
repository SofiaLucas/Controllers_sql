package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
//import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.jseproject.model.Entity_;
//import io.altar.jseproject.model.Product;

public abstract class EntityRepository<T extends Entity_> {//implements EntityRepositoryInterface <Entity> {

	@PersistenceContext (unitName = "database")
	protected EntityManager em;
	

	public long create(T entity) {
		return em.merge(entity).getId();
		
	}

	
	protected abstract Class <T> getEntityClass();
	
	protected abstract String getAllEntities();
	
	public List <T> getAll(){
		return em.createNamedQuery(getAllEntities(), getEntityClass()).getResultList();
	}
	
	public T getbyId (long id) {
		return em.find(getEntityClass(), id);
		
	}
	
	public void edit(T entity) {
		em.merge(entity);

	}
	
	
	public void remove(T entity) {
		T emp = em.find(getEntityClass(), entity.getId());
		em.remove(emp);
		
		
	}

	
	

	

//	public long[] getAllIds() {
//		//return myMap.keySet();
//		
//		Object[] objectArray = myMap.keySet().toArray();
//		long[] idArr = new long[objectArray.length];
//		for (int i = 0; i < objectArray.length; i++) {
//			idArr[i] = (long) objectArray[i];
//		}
//		return idArr;
//	}
//	
//	
//	
//	
//	public long size() {
//		return myMap.size();
//	}
//
////	public void printAll() {
////		Iterator<T> TIterator = getAll().iterator();
////
////		while (TIterator.hasNext()) {
////			T t = (T) TIterator.next();
////			System.out.println(t);
////		}
////
////	}

}
