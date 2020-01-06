package io.altar.jseprojectMysql.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private List<Long> shelfIds = new ArrayList<Long>();
	private int discount;
	private int iva;
	private float pvp;

	public ProductDTO() {
	}

	public ProductDTO(long id, List<Long> shelfIds, int discount, int iva, float pvp) {
		this.id=id;
		this.shelfIds = shelfIds;
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}

	public List<Long> getShelfIds() {
		return shelfIds;
	}

	public void setShelfIds(List<Long> shelfIds) {
		this.shelfIds = shelfIds;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
