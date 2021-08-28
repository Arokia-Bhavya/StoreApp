package com.store.inventory.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.inventory.domain.User;
import com.store.inventory.errorhandling.UserNotFoundException;
import com.store.inventory.repository.UserRepository;

@RestController
@RequestMapping("/store-app/users")
public class UserManagementController {
	
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("create")
	public User createUser(@RequestBody User user)
	{
		user = userRepo.save(user);
		return user;
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user)
	{
		user = userRepo.save(user);
		return user;
	}

	@DeleteMapping("/{userId}")
	public HttpStatus deleteUser(@PathVariable Long userId)
	{
		userRepo.deleteById(userId);
		return HttpStatus.OK;
	}
	
	@GetMapping("/{userId}")
	public User rerieveUser(@PathVariable Long userId) throws UserNotFoundException
	{		
		Optional<User> userOptional = userRepo.findById(userId);
		User user = userOptional.orElseThrow(UserNotFoundException::new);
		return user;
	}
}
