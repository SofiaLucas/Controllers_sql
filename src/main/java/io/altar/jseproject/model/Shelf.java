package io.altar.jseproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery (name=Shelf.GET_ALL_SHELVES, query= "SELECT s FROM Shelf s")
})
public class Shelf extends Entity_ implements Serializable{
	
	public static final String GET_ALL_SHELVES = "getAllShelves";
	public static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	private Product product;
	private int capacity;
	private float dailyPrice;

	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	

}
