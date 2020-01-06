package io.altar.jseprojectMysql.controlers;


import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseprojectMysql.business.ShelfBusiness;
import io.altar.jseprojectMysql.model.Shelf;
import io.altar.jseprojectMysql.model.ShelfDTO;
import io.altar.jseprojectMysql.repositories.ShelfRepository;

@RequestScoped
@Path("shelves")
public class ShelfControler extends EntityControler <Shelf, ShelfBusiness, ShelfRepository>{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShelfDTO> getAll() {
		return service.getAll().stream()
				.map(shelf -> new ShelfDTO(
						shelf.getId(),
						shelf.getCapacity(),
						shelf.getProduct().getId(),
						shelf.getDailyPrice()						
						))
						.collect(Collectors.toList());
	}
	

}
