package com.acme.builder;

import com.acme.entity.OrderStatus;
import com.acme.entity.TshirtOrder;
import com.acme.entity.TshirtSize;

public class TshirtOrderBuilder {
	
	private TshirtOrderBuilder() {}
	
	public static TshirtOrder build() {
		TshirtOrder tshirtOrder = new TshirtOrder();
		tshirtOrder.setOrderId(1L);
		tshirtOrder.setProductCode(9001);
		tshirtOrder.setSize(TshirtSize.M);
		tshirtOrder.setName("Customer Name");
		tshirtOrder.setEmail("customer@email.com");
		tshirtOrder.setAddress1("Customer address1");
		tshirtOrder.setAddress2("Customer address2");
		tshirtOrder.setCity("Customer City");
		tshirtOrder.setPostalCode("00001");
		tshirtOrder.setStateOrProvince("Customer State");
		tshirtOrder.setCountry("Customer Country");
		
		return tshirtOrder;
	}
	
	public static TshirtOrder buildInvalidProduct() {
		TshirtOrder tshirtOrder = new TshirtOrder();
		tshirtOrder.setProductCode(9999);
		tshirtOrder.setSize(TshirtSize.M);
		tshirtOrder.setName("Customer Name");
		tshirtOrder.setEmail("customer@email.com");
		tshirtOrder.setAddress1("Customer address1");
		tshirtOrder.setAddress2("Customer address2");
		tshirtOrder.setCity("Customer City");
		tshirtOrder.setPostalCode("00001");
		tshirtOrder.setStateOrProvince("Customer State");
		tshirtOrder.setCountry("Customer Country");
		
		return tshirtOrder;
	}
	
	public static TshirtOrder buildTrackOrder() {
		TshirtOrder tshirtOrder = new TshirtOrder();
		tshirtOrder.setOrderId(1L);
		tshirtOrder.setStatus(OrderStatus.WAITING_CARRIER);
		
		return tshirtOrder;
	}

}
