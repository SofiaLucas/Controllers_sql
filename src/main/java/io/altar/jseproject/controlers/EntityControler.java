//package io.altar.jseproject.controlers;
//
//import java.util.Collection;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.UriInfo;
//
//import io.altar.jseproject.model.Entity;
//import io.altar.jseproject.model.Product;
//
//public class EntityControler <T extends Entity, E extends Business>{
//
//	EntityControler <T, E> service = new EntityControler <T, E>();
//	
//	@Context
//	protected UriInfo context;
//
//	@GET
//	@Path("status")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String status() {
//		return "Url : " + context.getRequestUri().toString() + " is OK";
//	}
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Collection<T> getAllProducts() {
//		return service.getAll();
//	}
//
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public T createProduct(T entity) {
//		productsDataBase.create(entity);
//		return product;
//	}
//	
//	@DELETE
//	@Path("/{id}")
//	public void removeProduct(@PathParam("id") long idToRemove) {
//		Product productToRemove = productsDataBase.getbyId(idToRemove);
//		productsDataBase.remove(productToRemove);
//		
//		if (!productToRemove.getShelvesIds().isEmpty()) {			//!!
//			shelvesDataBase.removeProductFromShelf(idToRemove);
//			}
//			}
//	
//	@PUT
//	@Path("/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Product edit (@PathParam("id") long id, Product product) {
//		 productsDataBase.edit(product);
//		return product;
//		
//	}
//	
//	@GET
//	@Path("/{id}")
//	@Produces( MediaType.APPLICATION_JSON ) 
//	public Product consult(@PathParam("id") long id) {
//		return productsDataBase.getbyId(id);
//
//	}
//
//	
//}
