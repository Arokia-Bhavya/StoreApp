package com.store.inventory.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@ExceptionHandler(UserAccessNotFoundException.class)
	  public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserAccessNotFoundException ex) {
	    ErrorResponse errorResponse=new ErrorResponse("User of given Id doesnt have access","High",101);
	    return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.UNAUTHORIZED);
	  }
}
