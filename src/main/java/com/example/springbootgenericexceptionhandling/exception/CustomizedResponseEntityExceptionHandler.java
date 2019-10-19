package com.example.springbootgenericexceptionhandling.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * This exception handler method is going to handle all exception, 
	 * if there is no handler defined for raised exception
	 * 
	 * @param ex The raised Exception object
	 * @param request
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), "Internal server error");
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	/**
	 * This exception handler method is going to handle only UserNotFoundException
	 * 
	 * @param ex The raised UserNotFoundException object
	 * @param request
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), "User not found");
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
		
	}

}
