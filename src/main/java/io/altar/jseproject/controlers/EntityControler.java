package io.altar.jseproject.controlers;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.business.EntityBusiness;
import io.altar.jseproject.model.Entity_;
import io.altar.jseproject.repositories.EntityRepository;

public class EntityControler<E extends Entity_, B extends EntityBusiness<R, E>, R extends EntityRepository<E>> {

	//EntityBusiness<R, E> service;
	@Inject
	protected B service;
	
	@Context
	protected UriInfo context;
	
	@GET
	@Path("status")
	@Produces(MediaType.TEXT_PLAIN)
	public String status() {
		return "Url : " + context.getRequestUri().toString() + " is Ok";
	}
	
	//joao:
//	@GET
//	@Path("allIds")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Long> getAllIds() {
//		return service.getAllIds();
//	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(E entity) {
		try {
			service.create(entity);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}

	}
	//joao:
//	@POST
//	@Path("list")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String save(List<E> entities) {
//		entities.forEach(entity -> this.save(entity));
//		return "Done";
//	}

	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") long idToRemove) {
		E entityToRemove;
		try {
			entityToRemove = service.getbyId(idToRemove);
			service.remove(entityToRemove);
			return Response.ok().build();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return Response.status(400).entity(e.getMessage()).build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response edit(@PathParam("id") long id, E entity) {

		try {
			service.edit(entity);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consult(@PathParam("id") long id) {
		try {
			E entity = service.getbyId(id);
			return Response.status(200).entity(entity).build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}

	}

}
