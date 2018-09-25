package com.acme.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class TshirtOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	@PositiveOrZero
	private int productCode;
	@Enumerated(EnumType.STRING)	
	@NotNull(message = "Size is invalid")
	private TshirtSize size;
	@Email(message = "Email should be valid")
	private String email;
	@Size(min = 10, max = 255, message = "Name must be between 10 and 255 characters")
	private String name;
	@Size(min = 10, max = 255, message = "Address1 must be between 10 and 255 characters")
	private String address1;
	private String address2;
	@Size(min = 5, max = 255, message = "City must be between 5 and 255 characters")
	private String city;
	@Size(min = 5, max = 255, message = "StateOrProvince must be between 5 and 255 characters")
	private String stateOrProvince;
	@Size(min = 5, max = 255, message = "PostalCode must be between 5 and 255 characters")
	private String postalCode;
	@Size(min = 5, max = 255, message = "Country must be between 5 and 255 characters")
	private String country;	
	private OrderStatus status;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}
