package io.altar.jseprojectMysql.business;


import javax.enterprise.context.RequestScoped;

import io.altar.jseprojectMysql.model.Shelf;
import io.altar.jseprojectMysql.model.DTOs.ShelfDTO;
import io.altar.jseprojectMysql.repositories.ShelfRepository;

@RequestScoped
public class ShelfBusiness extends EntityBusiness<ShelfRepository, Shelf, ShelfDTO> implements BusinessShelfInterface {
	
	
//	@Override
//	public void edit(Shelf shelf) throws IllegalArgumentException{
//		
//		Shelf oldShelf = repository.getbyId(shelf.getId());
//		if( oldShelf.getId() != shelf.getId()) {
//			throw new IllegalArgumentException("id invalido");
//		}
//		
//		repository.edit(shelf);
//
//	}
//	
//	
	@Override
	public void remove(Shelf shelfToRemove) {
		
		//long productIdInShelf = shelfToRemove.getProduct().getId();
		if (shelfToRemove.getProduct() != null) {		
			throw new UnsupportedOperationException(String.format("Please remove product [%d] from shelf", shelfToRemove.getProduct().getId()));										
		}
		else {
			repository.remove(shelfToRemove);
		}
	

	}
//	
//	
//	
//	
//	@Override
//	public List<Long> selectEmptyShelves() {
////		Collection<Shelf> allShelves = repository.getAll();
////		Iterator<Shelf> iterator = allShelves.iterator();
////		List<Long> emptyShelvesIds = new ArrayList<Long>();
////
////		while (iterator.hasNext()) {
////			Shelf shelf = (Shelf) iterator.next();
////			if (shelf.getProductId() == 0) {
////				emptyShelvesIds.add(shelf.getId());
////			}
////		}
////		return emptyShelvesIds;
//		return null;
//	}
//
//	@Override
//	public List<Shelf> removeProductFromShelf(long id) {
////		Collection<Shelf> allShelves = repository.getAll();
////		Iterator<Shelf> iterator = allShelves.iterator();
////		List<Shelf> removedShelves = new ArrayList<Shelf>();
////		
////		while (iterator.hasNext()) {
////			Shelf shelf = (Shelf) iterator.next();
////			if (shelf.getProductId() == id) {
////				shelf.setProductId(0);
////				removedShelves.add(shelf);
////			}
////		}
////		return removedShelves;
//		return null;
//	}
//	
//	
//	
//	
//	//// joao
//	public void updateProductOnShelfs(long productId, List<Long> shelfsOld, List<Long> shelfsNew) {
////		for (Long shelfId : shelfsOld) {
////			Shelf shelf = repository.getbyId(shelfId);
////			if (shelfsNew.indexOf(shelfId) == -1) {
////				shelf.setProductId((long)0);
////				repository.edit(shelf);
////			}
////		}
////		for (Long shelfId : shelfsNew) {
////			Shelf shelf = repository.getbyId(shelfId);
////			if (shelfsOld.indexOf(shelfId) == -1) {
////				shelf.setProductId(productId);
////				repository.edit(shelf);
////			}
////		}
//	}

	
	public void removeProductFromShelf(long id) {
		repository.removeProductFromShelf(id); 
	}

	@Override
	protected String getEntityClassName() {
		return Shelf.getName();
	}

}
