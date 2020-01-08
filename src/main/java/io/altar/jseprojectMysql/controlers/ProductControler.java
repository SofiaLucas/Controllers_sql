package io.altar.jseprojectMysql.controlers;


import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import io.altar.jseprojectMysql.business.ProductBusiness;
import io.altar.jseprojectMysql.business.ShelfBusiness;
import io.altar.jseprojectMysql.model.Product;
import io.altar.jseprojectMysql.model.Shelf;
import io.altar.jseprojectMysql.model.DTOs.ProductDTO;
import io.altar.jseprojectMysql.repositories.ProductRepository;

@RequestScoped
@Path("products")
public class ProductControler extends EntityControler <Product, ProductBusiness, ProductRepository, ProductDTO>{
		
	@Inject
	ShelfBusiness SB;
	
//	public ProductControler() {
//		service = new ProductBusiness();
//	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON) // to DTO
//	public List<ProductDTO> getAll() {
//		return service.getAll().stream()
//				.map(product -> new ProductDTO(
//						product.getId(),
//						product.getShelves().stream().map(
//								Shelf::getId).collect(Collectors.toList()),
//						product.getDiscount(),
//						product.getIva(),
//						product.getPvp()
//						)
//				)
//				.collect(Collectors.toList());
//	}

	
	
	
	public Product toEntity (ProductDTO productDTO) {
		Product product = new Product();
		if (productDTO.getId()>0) { // no caso de ser um update
		
			productDTO.setId(product.getId());
			
		//	SS.removeProductsByProductId(entityDTO.getId());
			
		}
		product.setDiscount(productDTO.getDiscount());
		product.setIva(productDTO.getIva());
		product.setShelves(productDTO.getShelfIds().stream().map(entityId -> SB.getbyId(entityId)).collect(Collectors.toList()));
		productDTO.getShelfIds().forEach(shId -> SB.getbyId(shId).setProduct(product));
		
		return product;
		
	}
	
	

}
