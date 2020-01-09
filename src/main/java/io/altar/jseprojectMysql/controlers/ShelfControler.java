package io.altar.jseprojectMysql.controlers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import io.altar.jseprojectMysql.business.ProductBusiness;
import io.altar.jseprojectMysql.business.ShelfBusiness;
import io.altar.jseprojectMysql.model.Shelf;
import io.altar.jseprojectMysql.model.DTOs.ShelfDTO;
import io.altar.jseprojectMysql.repositories.ShelfRepository;

@RequestScoped
@Path("shelves")
public class ShelfControler extends EntityControler <Shelf, ShelfBusiness, ShelfRepository, ShelfDTO>{

	@Inject
	ProductBusiness PB;
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<ShelfDTO> getAll() {
//		return service.getAll().stream()
//				.map(shelf -> new ShelfDTO(
//						shelf.getId(),
//						shelf.getCapacity(),
//						shelf.getProduct().getId(),
//						shelf.getDailyPrice()						
//						))
//						.collect(Collectors.toList());
//	}
	

	@Override	
	public Shelf toEntity (ShelfDTO shelfDTO) {
		Shelf shelf = new Shelf();
		if(shelfDTO.getId()>0) {
			shelf.setId(shelfDTO.getId());
		}
		
		shelf.setCapacity(shelfDTO.getCapacity());
		shelf.setDailyPrice(shelfDTO.getDailyPrice());
		shelf.setProduct(shelfDTO.getProductId()>0 ? PB.getbyId(shelfDTO.getProductId()) : null);

		return shelf;
		
	}
}
