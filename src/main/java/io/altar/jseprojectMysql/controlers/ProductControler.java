package io.altar.jseprojectMysql.controlers;


import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseprojectMysql.business.ProductBusiness;
import io.altar.jseprojectMysql.model.Product;
import io.altar.jseprojectMysql.model.ProductDTO;
import io.altar.jseprojectMysql.model.Shelf;
import io.altar.jseprojectMysql.repositories.ProductRepository;

@RequestScoped
@Path("products")
public class ProductControler extends EntityControler <Product, ProductBusiness, ProductRepository>{
		
	public ProductControler() {
		service = new ProductBusiness();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) // to DTO
	public List<ProductDTO> getAll() {
		return service.getAll().stream()
				.map(product -> new ProductDTO(
						product.getId(),
						product.getShelves().stream().map(
								Shelf::getId).collect(Collectors.toList()),
						product.getDiscount(),
						product.getIva(),
						product.getPvp()
						)
				)
				.collect(Collectors.toList());
	}

	
	
}
