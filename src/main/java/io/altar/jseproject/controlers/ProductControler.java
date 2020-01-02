package io.altar.jseproject.controlers;


import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.business.ProductBusiness;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;

@Path("products")
public class ProductControler extends EntityControler <Product, ProductBusiness, ProductRepository>{
	
	
	
	public ProductControler() {
		service = new ProductBusiness();
	}

	@Context
	protected UriInfo context;

	@GET
	@Path("status")
	@Produces(MediaType.TEXT_PLAIN)
	public String status() {
		return "Url : " + context.getRequestUri().toString() + " is OK";
	}

}
