package com.store.inventory.errorhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.store.inventory.domain.ErrorResponse;

@RestControllerAdvice
public class ErrorHandling {
	
	@ExceptionHandler(CartNotFoundException.class)
	  public ErrorResponse handleNotFoundException(CartNotFoundException ex) {
	    ErrorResponse errorResponse=new ErrorResponse("Cart of given Id doesnt exist","High",101);
	    return errorResponse;
	  }
	
	@ExceptionHandler(CartItemNotFoundException.class)
	  public ErrorResponse handleNotFoundException(CartItemNotFoundException ex) {
	    ErrorResponse errorResponse=new ErrorResponse("CartItem of given Id doesnt exist","High",101);
	    return errorResponse;
	  }
}
