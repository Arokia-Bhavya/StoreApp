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
import com.store.inventory.domain.CartItem;
import com.store.inventory.errorhandling.CartItemNotFoundException;
import com.store.inventory.errorhandling.CartNotFoundException;
import com.store.inventory.errorhandling.ProductNotFoundException;
import com.store.inventory.repository.CartItemRepository;
import com.store.inventory.repository.CartRepository;
import com.store.inventory.service.CartService;

@RestController
@RequestMapping("store-app/cartItem")
public class CartItemController {
	
	
	@Autowired
	CartItemRepository cartItemRepo;
	@Autowired
	CartRepository cartRepo;
	@Autowired
	CartService cartService;

	
	@PostMapping("create")
	public ResponseEntity<CartItem> createCart(@RequestBody CartItem cartItem) throws CartNotFoundException, ProductNotFoundException
	{
		Optional<Cart> cartOptional = cartRepo.findById(cartItem.getCartId());
		Cart Cart = cartOptional.orElseThrow(CartNotFoundException::new);
		boolean isProductExist=cartService.isProductExist(cartItem.getProductId());
		if(!isProductExist)
			throw new ProductNotFoundException();
		cartItem= cartItemRepo.save(cartItem);
		return new ResponseEntity<CartItem>(cartItem,HttpStatus.CREATED);
	}
	
	@PutMapping("update")
	public ResponseEntity<CartItem> updateCart(@RequestBody CartItem cartItem)
	{
		cartItem = cartItemRepo.save(cartItem);
		return new ResponseEntity<CartItem>(cartItem,HttpStatus.OK);
	}

	@DeleteMapping("/{cartItemId}")
	public HttpStatus deleteCart(@PathVariable Long cartItemId)
	{
		cartItemRepo.deleteById(cartItemId);		
		return HttpStatus.OK;
	}
	
	@GetMapping("/{cartItemId}")
	public ResponseEntity<CartItem> rerieveCart(@PathVariable Long cartItemId) throws CartItemNotFoundException
	{		
		Optional<CartItem> cartItemOptional = cartItemRepo.findById(cartItemId);
		CartItem cartItem = cartItemOptional.orElseThrow(CartItemNotFoundException::new);
		return new ResponseEntity<CartItem>(cartItem,HttpStatus.OK);
	}
	
}
