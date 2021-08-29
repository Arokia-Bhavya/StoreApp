package com.store.inventory.errorhandling;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CartNotFoundException extends Exception{

	String msg;
}
