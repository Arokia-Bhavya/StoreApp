package com.store.inventory.errorhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.store.inventory.domain.ErrorResponse;

@RestControllerAdvice
public class ErrorHandling {
	
	@ExceptionHandler(ProductNotFoundException.class)
	  public ErrorResponse handleNotFoundException(ProductNotFoundException ex) {
	    ErrorResponse errorResponse=new ErrorResponse("Product of given Id doesnt exist","High",101);
	    return errorResponse;
	  }
}
