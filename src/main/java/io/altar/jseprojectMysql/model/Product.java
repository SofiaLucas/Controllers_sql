package io.altar.jseprojectMysql.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import io.altar.jseprojectMysql.model.DTOs.ProductDTO;


@Entity
@NamedQueries({
	@NamedQuery (name=Product.GET_ALL_PRODUCTS, query= "SELECT p FROM Product p"),
	@NamedQuery(name = Product.GET_ALL_PRODUCTS_IDS, query = "SELECT p.id FROM Product p"),
	@NamedQuery(name = Product.GET_PRODUCTS_COUNT, query = "SELECT COUNT(p.id) FROM Product p")
})
public class Product extends Entity_ <ProductDTO>  {

	public static final String GET_ALL_PRODUCTS = "getAllProducts";
	public static final String GET_ALL_PRODUCTS_IDS =  "getAllProductsIds";
	public static final String GET_PRODUCTS_COUNT = "getProductsCount";
	
	public static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
	private List<Shelf> shelves;
	private int discount;
	private int iva;
	private float pvp;

	public static String getName () {
		return "Product";
	}

	public List<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public ProductDTO toDTO() {
		return new ProductDTO(this.getId(), this.getShelves().stream().map(Shelf::getId).collect(Collectors.toList()),
				this.getDiscount(), this.getIva(), this.getPvp());
	}
	
	@Override
	public String toString() {
		return "Product [shelves=" + shelves + ", discount=" + discount + ", iva=" + iva + ", pvp=" + pvp + "]";
	}
}
