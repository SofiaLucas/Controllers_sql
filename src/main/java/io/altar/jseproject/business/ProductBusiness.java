package io.altar.jseproject.business;

import java.util.List;

import javax.ws.rs.core.Response;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductBusiness extends EntityBusiness<ProductRepository, Product> implements BusinessProductInterface {

	public static final ShelfBusiness SB = new ShelfBusiness();

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
	public void edit(Product product) throws IllegalArgumentException {
		Product oldProd = repository.getbyId(product.getId());

		List<Long> oldProdShelves = oldProd.getShelvesIds();
		List<Long> newProdShelves = product.getShelvesIds();
		List<Long> emptyShelvesIds = SB.selectEmptyShelves();

		if (!newProdShelves.isEmpty() && emptyShelvesIds.isEmpty()) {
			throw new IllegalArgumentException("ids de prateleiras invalidos - nao ha prateleiras vazias");
		}

		if (!newProdShelves.isEmpty() && !oldProdShelves.equals(newProdShelves)) {

			System.out.println("newProdShelves antes do remove : " + newProdShelves);
			newProdShelves.removeAll(oldProdShelves);
			System.out.println("oldProdShelves: " + oldProdShelves);
			System.out.println("newProdShelves depois do remove : " + newProdShelves);

			for (Long shId : newProdShelves) {
				if (!emptyShelvesIds.contains(shId)) {
					throw new IllegalArgumentException(
							"ids de prateleiras invalidos; prateleiras vazias:" + emptyShelvesIds);
				}
			}
		}

		if (!oldProdShelves.equals(newProdShelves)) {
			SB.updateProductOnShelfs(product.getId(), oldProdShelves, newProdShelves);
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
		// addProductToShelf (product, newProdShelves);

	}

	@Override
	public void remove(Product productToRemove) {
		if (!productToRemove.getShelvesIds().isEmpty()) {
			SB.removeProductFromShelf(productToRemove.getId());
		}
		repository.remove(productToRemove);

	}

//	@Override
//	public void addProductToShelf(Product productToAdd, List<Long> newProdShelves) { // ten de ser editado
//		for (Long shelfId : newProdShelves) {
//				
//		Shelf shelfSelected = SB.getbyId(shelfId);
//		shelfSelected.setProductId(productToAdd.getId());
//		productToAdd.addShelfId(shelfSelected.getId());
//		
//		SB.edit(shelfSelected);
//		}
//		repository.edit(productToAdd);
//	}

	@Override
	public Product updateshelvesIdsInProduct(Product productInShelf, long productIdInShelf) { // acho q esta é p o
																								// remove
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
