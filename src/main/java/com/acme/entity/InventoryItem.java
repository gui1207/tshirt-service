package com.acme.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class InventoryItem  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@PositiveOrZero
	private int productCode;
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Size cannot be null")
	private TshirtSize size;
	@Size(min = 10, max = 255, message = "Description must be between 10 and 255 characters")
	private String description;
	@PositiveOrZero
	private int count;		
	
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public TshirtSize getSize() {
		return size;
	}
	public void setSize(TshirtSize size) {
		this.size = size;
	}	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
