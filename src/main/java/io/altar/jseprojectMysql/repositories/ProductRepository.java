package io.altar.jseprojectMysql.repositories;

import javax.enterprise.context.RequestScoped;

import io.altar.jseprojectMysql.model.Product;

@RequestScoped
public class ProductRepository extends EntityRepository<Product> {
	
	@Override
	protected Class <Product> getEntityClass(){
		return Product.class;
	}
	

	@Override
	protected String getAllEntities() {
		return Product.GET_ALL_PRODUCTS;
	}


	@Override
	protected String getAllEntitiesIds() {
		return Product.GET_ALL_PRODUCTS_IDS;
	}
	
	
	
}
