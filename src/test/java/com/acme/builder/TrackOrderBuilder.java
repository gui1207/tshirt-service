package com.acme.builder;

import com.acme.tshirt_service.TrackOrder;

public class TrackOrderBuilder {
	
	private TrackOrderBuilder() {}	
	
	public static TrackOrder buildTrackOrder(Long orderId) {
		TrackOrder trackOrder = new TrackOrder();
		trackOrder.setOrderId(orderId);
		
		return trackOrder;
	}
}
