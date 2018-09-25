package com.acme.entity;

public enum OrderStatus {

	WAITING_CARRIER,
	IN_TRANSIT,
	DELIVERED;
    
    public String value() {
        return name();
    }

    public static OrderStatus fromValue(String v) {
        return valueOf(v);
    }
    
}
