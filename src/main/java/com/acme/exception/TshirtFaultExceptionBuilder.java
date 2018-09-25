package com.acme.exception;

import com.acme.tshirt_service.TshirtFault;
import com.acme.tshirt_service.TshirtFaultException;

public class TshirtFaultExceptionBuilder {
	
	private TshirtFaultExceptionBuilder() {}	
	
	public static TshirtFaultException buildException(Exception e) {
		String message = e.getMessage();;	
		
		TshirtFaultException tshirtFaultException = new TshirtFaultException(message, new TshirtFault());		
		
		return tshirtFaultException;
	}

}
