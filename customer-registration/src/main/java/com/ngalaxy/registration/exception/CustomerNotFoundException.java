package com.ngalaxy.registration.exception;

public class CustomerNotFoundException extends RuntimeException {

	private Integer errorCode;
	private String errorMessage;
	public CustomerNotFoundException(Integer errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
