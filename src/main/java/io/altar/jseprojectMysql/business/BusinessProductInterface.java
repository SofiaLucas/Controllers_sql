package io.altar.jseprojectMysql.business;

import io.altar.jseprojectMysql.model.Product;

public interface BusinessProductInterface extends BusinessServiceInterface<Product> {

//	static final ProductRepository PDB = ProductRepository.getInstance();

	//void addProductToShelf(Product productToAdd, List<Long> selectedId) throws NoSuchFieldException;

	Product updateshelvesIdsInProduct(Product productInShelf, long productIdInShelf);
}
