package io.altar.jseprojectMysql.business;

import java.util.List;

import io.altar.jseprojectMysql.model.Shelf;

public interface BusinessShelfInterface extends BusinessServiceInterface <Shelf> {
	
	//static final ShelfRepository SDB = ShelfRepository.getInstance();
	
	List<Long> selectEmptyShelves();
	
	public List<Shelf> removeProductFromShelf(long id);
	
}
