package io.altar.jseproject.business;

import java.util.List;

import io.altar.jseproject.model.Product;

import io.altar.jseproject.repositories.ProductRepository;

public interface BusinessProductInterface extends BusinessServiceInterface<Product> {

//	static final ProductRepository PDB = ProductRepository.getInstance();

	//void addProductToShelf(Product productToAdd, List<Long> selectedId) throws NoSuchFieldException;

	Product updateshelvesIdsInProduct(Product productInShelf, long productIdInShelf);
}
