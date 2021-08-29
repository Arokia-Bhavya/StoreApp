package com.store.inventory.controller;

import java.util.List;
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

import com.store.inventory.domain.Product;
import com.store.inventory.errorhandling.ProductNotFoundException;
import com.store.inventory.repository.ProductRepository;

@RestController
@RequestMapping("/store-app/products")
public class ProductManagementController {
	
	@Autowired
	ProductRepository productRepo;
	
	@PostMapping("create")
	ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		product=productRepo.save(product);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@PostMapping("bulkCreate")
	HttpStatus createProduct(List<Product> productList)
	{
		productRepo.saveAll(productList);
		return HttpStatus.CREATED;
	}
	
	@GetMapping("/{productId}")
	ResponseEntity<Product> retrieveProduct(@PathVariable Long productId) throws ProductNotFoundException
	{
		Optional<Product> productOptional=productRepo.findById(productId);
		Product product=productOptional.orElseThrow(ProductNotFoundException::new);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("all")
	List<Product> retrieveProducts() 
	{
		List<Product> products=productRepo.findAll();		
		return products;
	}
	
	@DeleteMapping("/{productId}")
	HttpStatus deleteProduct(@PathVariable Long productId)
	{
		productRepo.deleteById(productId);
		return HttpStatus.OK;
	}
	
	@PutMapping("update")
	HttpStatus updateProduct(@RequestBody Product product)
	{
		productRepo.save(product);
		return HttpStatus.OK;
	}

}
