package com.store.inventory.errorhandling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class ProductNotFoundException extends Exception{	
	
	String msg;

}
