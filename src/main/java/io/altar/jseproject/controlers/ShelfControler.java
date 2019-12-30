package io.altar.jseproject.controlers;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.business.ShelfBusiness;
import io.altar.jseproject.model.Shelf;

@Path("shelves")
public class ShelfControler {

	
	
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
	public Collection<Shelf> getAllShelves() {
		return shelvesDataBase.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf create(Shelf shelf) {
		shelvesDataBase.create(shelf);
		return shelf;
	}
	
	@DELETE
	@Path("/{id}")
	public void remove(@PathParam("id") long idToRemove) {
		Shelf shelfToRemove = shelvesDataBase.getbyId(idToRemove);
		shelvesDataBase.remove(shelfToRemove);
			
			}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf edit (@PathParam("id") long id, Shelf shelf) {
		shelvesDataBase.edit(shelf);
		return shelf;
		
	}
	
	@GET
	@Path("/{id}")
	@Produces( MediaType.APPLICATION_JSON ) 
	public Shelf consult(@PathParam("id") long id) {
		return shelvesDataBase.getbyId(id);

	}

	

}
