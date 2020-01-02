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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.business.EntityBusiness;
import io.altar.jseproject.model.Entity;
import io.altar.jseproject.repositories.EntityRepository;
//@Path("")
public class EntityControler<E extends Entity, B extends EntityBusiness<R, E>, R extends EntityRepository<E>> {

	EntityBusiness<R, E> service = new EntityBusiness<R, E>();

//	@Context
//	protected UriInfo context;
//
//	@GET
//	@Path("status")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String status() {
//		return "Url : " + context.getRequestUri().toString() + " is OK";
//	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<E> getAll() {
		return service.getAll();
	}

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
			service.getbyId(id);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}

	}

}
