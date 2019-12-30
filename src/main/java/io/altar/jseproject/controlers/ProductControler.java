package io.altar.jseproject.controlers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


import io.altar.jseproject.business.ProductBusiness;
import io.altar.jseproject.business.ShelfBusiness;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

@Path("products")
public class ProductControler {
//extends EntityControler <Product, ProductBusiness>{

	ProductBusiness productsDataBase = new ProductBusiness();
	ShelfBusiness shelvesDataBase = new ShelfBusiness();

	@Context
	protected UriInfo context;

	@GET
	@Path("status")
	@Produces(MediaType.TEXT_PLAIN)
	public String status() {
		return "Url : " + context.getRequestUri().toString() + " is OK";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Product> getAllProducts() {
		return productsDataBase.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product createProduct(Product product) {
		productsDataBase.create(product);
		return product;
	}

	@DELETE
	@Path("/{id}")
	public void removeProduct(@PathParam("id") long idToRemove) {
		Product productToRemove = productsDataBase.getbyId(idToRemove);
		productsDataBase.remove(productToRemove);

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response edit(@PathParam("id") long id, Product product) {

		if(product.getShelvesIds().isEmpty()) {
			productsDataBase.edit(product);
			return Response.status(Response.Status.OK).entity(product).build();
		}
		
		else {
		
		Product oldProd = productsDataBase.getbyId(id);
		List<Long> oldProdShelves = oldProd.getShelvesIds();

		List<Long> emptyShelvesIds = shelvesDataBase.selectEmptyShelves();

		// if(product.getShelvesIds().containsAll(oldProdShelves)) {

		product.getShelvesIds().removeAll(oldProdShelves);

		boolean emptyShelf = true;
		for (int j = 0; j < emptyShelvesIds.size(); j++) {
		for (int i = 0; i < product.getShelvesIds().size(); i++) {		

				if (product.getShelvesIds().get(i) != emptyShelvesIds.get(j)) {
					emptyShelf = false;
					break;
				}
			}
		}

			product.getShelvesIds().addAll(oldProdShelves);
			if (emptyShelf = true  ) {
				productsDataBase.edit(product);
				
				return Response.status(Response.Status.OK).entity(product).build();
				
			} else {
				return Response.status(Response.Status.BAD_REQUEST).entity("Adicionou prateleira(s) que já se encontra(m) ocupada(s)").build();
			}
		}
//			if (!product.getShelvesIds().contains(emptyShelvesIds.get(i))) {
//
//				return Response.status(Response.Status.BAD_REQUEST).entity("").build();
//				
//			} else {
//
//				productsDataBase.edit(product);
//
//				return Response.status(Response.Status.OK).entity(product).build();
//			}
		
//		

		// List<Long> newShelvesInProd = product.getShelvesIds().stream().filter(a ->
		// !a.equals(oldProdShelves)).collect(Collectors.toList());

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product consult(@PathParam("id") long id) {
		return productsDataBase.getbyId(id);

	}

}
