package io.altar.jseprojectMysql.repositories;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import io.altar.jseprojectMysql.model.Shelf;
import io.altar.jseprojectMysql.model.DTOs.ShelfDTO;

@RequestScoped
public class ShelfRepository extends EntityRepository<Shelf, ShelfDTO> {

	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}

	@Override
	protected String getAllEntities() {
		return Shelf.GET_ALL_SHELVES;
	}

	@Override
	protected String getAllEntitiesIds() {
		return Shelf.GET_ALL_SHELVES_IDS;
	}

	public List <Shelf> getEmptyShelves(){
		return em.createNamedQuery(Shelf.GET_EMPTY_SHELVES, getEntityClass()).getResultList();
	}
	
	public void removeProductFromShelf (long id) {
		em.createNamedQuery(Shelf.SHELVES_PRODUCT_TO_NULL).setParameter("productId", id).executeUpdate();
		
	}
	

	
	
	
}
