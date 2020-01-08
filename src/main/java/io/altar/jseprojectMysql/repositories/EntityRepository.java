package io.altar.jseprojectMysql.repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import io.altar.jseprojectMysql.model.Entity_;
import io.altar.jseprojectMysql.model.DTOs.EntityDTO;

@Transactional
public abstract class EntityRepository<T extends Entity_<D>,D extends EntityDTO> {

	@PersistenceContext (unitName = "database")
	protected EntityManager em;
	
	protected abstract Class <T> getEntityClass();
	

	protected abstract String getAllEntitiesIds();
	
	public long[] getAllIds() { // ver se não dá para por em lista
		Object[] objectArray =  em.createNamedQuery(getAllEntitiesIds(), Long.class).getResultList().toArray();

	long[] idArr = new long[objectArray.length];
	for (int i = 0; i < objectArray.length; i++) {
		idArr[i] = (long) objectArray[i];
	}
	return idArr;
}

	
	protected abstract String getAllEntities();
	public List <T> getAll(){
		return em.createNamedQuery(getAllEntities(), getEntityClass()).getResultList();
	}
	
	
	public long create(T entity) {
		return em.merge(entity).getId();
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

	//soluçao do joao:
//	public void remove(long id) {
//		T entity = getbyId(id);
//		if(entity != null) {
//			em.remove(entity);
//		}
//	}
	

	


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
