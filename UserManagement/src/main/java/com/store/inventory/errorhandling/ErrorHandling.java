package com.store.inventory.errorhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.store.inventory.domain.ErrorResponse;

@RestControllerAdvice
public class ErrorHandling {
	
	@ExceptionHandler(UserNotFoundException.class)
	  public ErrorResponse handleNotFoundException(UserNotFoundException ex) {
	    ErrorResponse errorResponse=new ErrorResponse("User of given Id doesnt exist","High",101);
	    return errorResponse;
	  }
}
