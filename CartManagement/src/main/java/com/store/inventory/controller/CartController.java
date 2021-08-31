package com.store.inventory.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.inventory.domain.Cart;
import com.store.inventory.errorhandling.CartNotFoundException;
import com.store.inventory.repository.CartRepository;

@RestController
@RequestMapping("store-app/cart")
public class CartController {

	@Autowired
	CartRepository cartRepo;
	
	@PostMapping("create")
	public ResponseEntity<Cart> createCart(@RequestBody Cart Cart)
	{
		Cart = cartRepo.save(Cart);
		return new ResponseEntity<Cart>(Cart,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart)
	{
		cart = cartRepo.save(cart);
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}

	@DeleteMapping("/{cartId}")
	public HttpStatus deleteCart(@PathVariable Long cartId)
	{
		cartRepo.deleteById(cartId);		
		return HttpStatus.OK;
	}
	
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> rerieveCart(@PathVariable Long cartId) throws CartNotFoundException
	{		
		Optional<Cart> cartOptional = cartRepo.findById(cartId);
		Cart Cart = cartOptional.orElseThrow(CartNotFoundException::new);
		return new ResponseEntity<Cart>(Cart,HttpStatus.OK);
	}
	
}
