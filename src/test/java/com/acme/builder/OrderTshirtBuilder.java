package com.acme.builder;

import com.acme.tshirt_service.OrderTshirt;
import com.acme.tshirt_service.Size;

public class OrderTshirtBuilder {
	
	private OrderTshirtBuilder() {}
	
	public static OrderTshirt buildOrderTshirt() {
		OrderTshirt orderTshirt = new OrderTshirt();	
		
		orderTshirt.setProductCode(100);
		orderTshirt.setSize(Size.M);
		orderTshirt.setName("Customer Name");
		orderTshirt.setEmail("customer@email.com");
		orderTshirt.setAddress1("Customer address1");
		orderTshirt.setAddress2("Customer address2");
		orderTshirt.setCity("Customer City");
		orderTshirt.setPostalCode("00001");
		orderTshirt.setStateOrProvince("Customer State");
		orderTshirt.setCountry("Customer Country");
		
		return orderTshirt;
	}
	
	public static OrderTshirt buildOrderTshirtInvalidProduct() {
		OrderTshirt orderTshirt = new OrderTshirt();	
		
		orderTshirt.setProductCode(9999);
		orderTshirt.setSize(Size.M);
		orderTshirt.setName("Customer Name");
		orderTshirt.setEmail("customer@email.com");
		orderTshirt.setAddress1("Customer address1");
		orderTshirt.setAddress2("Customer address2");
		orderTshirt.setCity("Customer City");
		orderTshirt.setPostalCode("00001");
		orderTshirt.setStateOrProvince("Customer State");
		orderTshirt.setCountry("Customer Country");
		
		return orderTshirt;
	}

}
