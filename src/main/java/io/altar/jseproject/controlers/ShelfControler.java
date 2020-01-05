package io.altar.jseproject.controlers;


import java.util.Collection;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.business.ShelfBusiness;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

@Path("shelves")
public class ShelfControler extends EntityControler <Shelf, ShelfBusiness, ShelfRepository>{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Shelf> getAll() {
		return service.getAll();
	}
	

}
