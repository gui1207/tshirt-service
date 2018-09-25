package com.acme.exception;

public class TshirtException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TshirtException() {
		super();
	}

	public TshirtException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TshirtException(String message, Throwable cause) {
		super(message, cause);
	}

	public TshirtException(String message) {
		super(message);
	}

	public TshirtException(Throwable cause) {
		super(cause);		
	}

}
