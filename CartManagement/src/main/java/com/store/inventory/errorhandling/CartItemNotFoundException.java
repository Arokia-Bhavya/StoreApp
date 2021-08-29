package com.store.inventory.errorhandling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CartItemNotFoundException extends Exception{

	String msg;
}
