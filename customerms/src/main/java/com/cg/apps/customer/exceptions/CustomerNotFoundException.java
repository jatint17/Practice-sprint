package com.cg.apps.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException(String msg) {
		super(msg);
	}

}
