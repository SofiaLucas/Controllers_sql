package io.altar.jseproject.business;

import java.util.List;

import javax.ws.rs.core.Response;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductBusiness extends EntityBusiness<ProductRepository, Product> implements BusinessProductInterface {

	ShelfBusiness SB = new ShelfBusiness();

	public ProductBusiness() {
		repository = ProductRepository.getInstance();
	}

	@Override
	public void create(Product prod) throws IllegalArgumentException {

		int[] iva = { 6, 13, 23 };
		boolean check = false;
		for (int i = 0; i < iva.length; i++) {
			if (prod.getIva() == iva[i]) {
				check = true;
			}
		}
		if (check == false) {
			throw new IllegalArgumentException("iva should be 6, 13 or 23");
		}

		if (prod.getDiscount() < 0 || prod.getDiscount() > 100) {
			throw new IllegalArgumentException("discount should be 0-100");
		}

		repository.create(prod);

	}

	
	@Override
	public void edit(Product product) throws IllegalArgumentException{
		Product oldProd = repository.getbyId(product.getId());
		
		List<Long> oldProdShelves = oldProd.getShelvesIds();
		List<Long> newProdShelves = product.getShelvesIds();
		List<Long> emptyShelvesIds = SB.selectEmptyShelves();
		
			
		
		if(!newProdShelves.isEmpty()&&emptyShelvesIds.isEmpty()) {
			throw new IllegalArgumentException("ids de prateleiras invalidos - nao ha prateleiras vazias");
		}
		
		System.out.println("!newProdShelves.isEmpty() : " + !newProdShelves.isEmpty());
		System.out.println("!oldProdShelves.equals(newProdShelves) : " + !oldProdShelves.equals(newProdShelves));
		System.out.println("emptyShelvesIds : " + emptyShelvesIds);
		
		if (!newProdShelves.isEmpty() && !oldProdShelves.equals(newProdShelves)) {
			
			System.out.println("newProdShelves antes do remove : " + newProdShelves);
			newProdShelves.removeAll(oldProdShelves);
			System.out.println("newProdShelves depois do remove : " + newProdShelves);
			boolean validShelfId = false;
				for (int j = 0; j < emptyShelvesIds.size(); j++) {
					for (int i = 0; i < newProdShelves.size(); i++) {
System.out.println("ëntrei no for");

//retainAll newProdShelves.retainAll(emptyShelvesIds)
						if (newProdShelves.get(i) == emptyShelvesIds.get(j)) {
							validShelfId = true;
							break;												
						}
					}
				}

				if( validShelfId = false) {
					throw new IllegalArgumentException("ids de prateleiras invalidos");
				}
				
				newProdShelves.addAll(oldProdShelves);
				
				
				
				
			//falta alterar na prat
		
		
		
//			Product oldProduct = repository.getbyId(product.getId());
//			if (!oldProduct.getShelvesIds().equals(product.getShelvesIds())) {
//				SB.updateProductOnShelfs(product.getId(),oldProduct.getShelvesIds(),product.getShelvesIds());
			}


		
		
		
		int[] iva = { 6, 13, 23 };
		boolean check = false;
		for (int i = 0; i < iva.length; i++) {
			if (product.getIva() == iva[i]) {
				check = true;
			}
		}
		if (check == false) {
			throw new IllegalArgumentException("iva should be 6, 13 or 23");
		}

		if (product.getDiscount() < 0 || product.getDiscount() > 100) {
			throw new IllegalArgumentException("discount should be 0-100");
		}
		
		
		repository.edit(product);

	}
	
	
	@Override
	public void addProductToShelf(Product productToAdd, long selectedId)  { // ten de ser editado
		Shelf shelfSelected = SB.getbyId(selectedId);
		shelfSelected.setProductId(productToAdd.getId());
		productToAdd.addShelfId(shelfSelected.getId());
		SB.edit(shelfSelected);
		repository.edit(productToAdd);
	}

	@Override
	public Product updateshelvesIdsInProduct(Product productInShelf, long productIdInShelf) { // acho q esta é p o remove
		List<Long> shelvesIdsInProduct = productInShelf.getShelvesIds();

		for (int i = 0; i < shelvesIdsInProduct.size(); i++) {
			if (shelvesIdsInProduct.get(i) == productIdInShelf) {
				productInShelf.removeShelfId(shelvesIdsInProduct.get(i));
				break;
			}
		}

		repository.edit(productInShelf);
		return productInShelf;
	}

	
	
}
