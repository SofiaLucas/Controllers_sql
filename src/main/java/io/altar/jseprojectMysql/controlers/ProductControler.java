package io.altar.jseprojectMysql.controlers;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseprojectMysql.business.ProductBusiness;
import io.altar.jseprojectMysql.business.ShelfBusiness;
import io.altar.jseprojectMysql.model.Product;
import io.altar.jseprojectMysql.model.Shelf;
import io.altar.jseprojectMysql.model.DTOs.ProductDTO;
import io.altar.jseprojectMysql.repositories.ProductRepository;

@RequestScoped
@Path("products")
public class ProductControler extends EntityControler<Product, ProductBusiness, ProductRepository, ProductDTO> {

	@Inject
	ShelfBusiness SB;

	@Override
	public Product toEntity(ProductDTO productDTO) {
		Product product = new Product();
		if (productDTO.getId() > 0) { // no caso de ser um update
			product.setId(productDTO.getId());
			SB.removeProductFromShelf(productDTO.getId());
		}

		product.setShelves(productDTO.getShelfIds().stream().map(shId -> {
			Shelf shelf = SB.getbyId(shId);
			shelf.setProduct(product);
			return shelf;
		}).collect(Collectors.toList()));
		product.setDiscount(productDTO.getDiscount());
		product.setIva(productDTO.getIva());
		product.setPvp(productDTO.getPvp());
		

//		productDTO.getShelfIds().forEach(shId -> SB.getbyId(shId).setProduct(product));
//		System.out.println(product);
		return product;

	}

}
