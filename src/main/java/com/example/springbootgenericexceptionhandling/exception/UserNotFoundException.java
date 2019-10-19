package com.example.springbootgenericexceptionhandling.exception;

public class UserNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String arg0) {
		super(arg0);
	}
	
	

}
