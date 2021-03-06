package io.altar.jseprojectMysql.controlers;

import java.util.List;
import java.util.stream.Collectors;

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

import io.altar.jseprojectMysql.business.EntityBusiness;
import io.altar.jseprojectMysql.model.Entity_;
import io.altar.jseprojectMysql.model.DTOs.EntityDTO;
import io.altar.jseprojectMysql.repositories.EntityRepository;

public abstract class EntityControler<E extends Entity_<D>, B extends EntityBusiness<R, E, D>, R extends EntityRepository<E, D>, D extends EntityDTO> {

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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<D> getAll() {
		return service.getAll().stream().map(E::toDTO).collect(Collectors.toList());
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(D entityDTO) {
		try {
			E entity = toEntity(entityDTO);
			service.create(entity);
			return Response.ok().build();
		} catch (IllegalArgumentException e) {
			return Response.status(406).entity(e.getMessage()).build();
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
			return Response.status(406).entity(e.getMessage()).build();
		} catch (UnsupportedOperationException e) {
			return Response.status(405).entity(e.getMessage()).build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	public Response edit(@PathParam("id") long id, D entityDTO) {

		try {
			E entity = toEntity(entityDTO);
			service.edit(entity);
			return Response.ok().build();
		} catch (IllegalArgumentException e) {
			return Response.status(406).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consult(@PathParam("id") long id) {
		try {
			D entityDTO = service.getbyId(id).toDTO();
			return Response.status(200).entity(entityDTO).build();
		} catch (IllegalArgumentException e) {
			return Response.status(406).entity(e.getMessage()).build();
		}

	}

	public abstract E toEntity(D entityDTO);
}
