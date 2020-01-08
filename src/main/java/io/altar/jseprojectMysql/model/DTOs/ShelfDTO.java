package io.altar.jseprojectMysql.model.DTOs;


public class ShelfDTO extends EntityDTO {

	//private static final long serialVersionUID = 1L;
	
//	private long id;
	private int capacity;
	private long productId;
	private float dailyPrice;

	public ShelfDTO() {
	}

	public ShelfDTO(int capacity, float dailyPrice) {
		this.capacity = capacity;
		this.dailyPrice = dailyPrice;
	}

	public ShelfDTO(long id, int capacity, long productId, float dailyPrice) {
		this.id=id;
		this.capacity = capacity;
		this.productId = productId;
		this.dailyPrice = dailyPrice;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	@Override
	public String toString() {
		return "Shelf [capacity=" + capacity + ", productId=" + productId + ", dailyPrice=" + dailyPrice + "]";
	}


}
