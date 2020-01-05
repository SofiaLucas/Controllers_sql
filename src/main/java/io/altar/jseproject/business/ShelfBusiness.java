package io.altar.jseproject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class ShelfBusiness extends EntityBusiness<ShelfRepository, Shelf> implements BusinessShelfInterface {
	

	
	@Override
	public void edit(Shelf shelf) throws IllegalArgumentException{
		
		Shelf oldShelf = repository.getbyId(shelf.getId());
		if( oldShelf.getId() != shelf.getId()) {
			throw new IllegalArgumentException("id invalido");
		}
		
		repository.edit(shelf);

	}
	
	
	@Override
	public void remove(Shelf shelfToRemove) {
//		long productIdInShelf = shelfToRemove.getProductId();
//		Product productInShelf = PB.getbyId(productIdInShelf);
//		if (productIdInShelf != 0) {		
//			PB.updateshelvesIdsInProduct(productInShelf, productIdInShelf); 											
//		}
//		repository.remove(shelfToRemove);

	}
	
	
	
	
	@Override
	public List<Long> selectEmptyShelves() {
//		Collection<Shelf> allShelves = repository.getAll();
//		Iterator<Shelf> iterator = allShelves.iterator();
//		List<Long> emptyShelvesIds = new ArrayList<Long>();
//
//		while (iterator.hasNext()) {
//			Shelf shelf = (Shelf) iterator.next();
//			if (shelf.getProductId() == 0) {
//				emptyShelvesIds.add(shelf.getId());
//			}
//		}
//		return emptyShelvesIds;
		return null;
	}

	@Override
	public List<Shelf> removeProductFromShelf(long id) {
//		Collection<Shelf> allShelves = repository.getAll();
//		Iterator<Shelf> iterator = allShelves.iterator();
//		List<Shelf> removedShelves = new ArrayList<Shelf>();
//		
//		while (iterator.hasNext()) {
//			Shelf shelf = (Shelf) iterator.next();
//			if (shelf.getProductId() == id) {
//				shelf.setProductId(0);
//				removedShelves.add(shelf);
//			}
//		}
//		return removedShelves;
		return null;
	}
	
	
	
	
	//// joao
	public void updateProductOnShelfs(long productId, List<Long> shelfsOld, List<Long> shelfsNew) {
//		for (Long shelfId : shelfsOld) {
//			Shelf shelf = repository.getbyId(shelfId);
//			if (shelfsNew.indexOf(shelfId) == -1) {
//				shelf.setProductId((long)0);
//				repository.edit(shelf);
//			}
//		}
//		for (Long shelfId : shelfsNew) {
//			Shelf shelf = repository.getbyId(shelfId);
//			if (shelfsOld.indexOf(shelfId) == -1) {
//				shelf.setProductId(productId);
//				repository.edit(shelf);
//			}
//		}
	}


	@Override
	protected String getEntityClassName() {
		return Shelf.getName();
	}

}
