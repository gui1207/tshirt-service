package com.acme.entity;

public enum TshirtSize {
	
	S,
    M,
    L,
    XL,
    XXL;

    public String value() {
        return name();
    }

    public static TshirtSize fromValue(String v) {
        return valueOf(v);
    }

}
