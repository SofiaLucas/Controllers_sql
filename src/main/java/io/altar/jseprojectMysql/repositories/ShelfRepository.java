package io.altar.jseprojectMysql.repositories;

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

	
}
