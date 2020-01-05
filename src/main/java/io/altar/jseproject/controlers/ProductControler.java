package io.altar.jseproject.controlers;


import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.business.ProductBusiness;
import io.altar.jseproject.model.*;


import io.altar.jseproject.repositories.ProductRepository;

@Path("products")
public class ProductControler extends EntityControler <Product, ProductBusiness, ProductRepository>{
		
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDTO> getAll() {
		return service.getAll().stream()
				.map(product -> new ProductDTO(
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
