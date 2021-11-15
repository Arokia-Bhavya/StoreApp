package com.store.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.inventory.domain.User;
import com.store.inventory.errorhandling.UserNotFoundException;
import com.store.inventory.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/store-app/users")
public class UserManagementController {
	
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping(path="createNew")
	public ResponseEntity<User> createNewUser(@RequestParam Map<String,String> body)
	{
		User user=new User();
		user.setFirstName(body.get("firstName"));
		user.setMiddleName(body.get("middleName"));
		user.setLastName(body.get("lastName"));
		user.setEmail(body.get("eMail"));
		user.setPasswordHash(body.get("passwordHash"));
		user = userRepo.save(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	@PostMapping(path="create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{		
		user = userRepo.save(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@PutMapping("update")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{
		user = userRepo.save(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> rerieveUsers()
	{		
		List<User> userList=new ArrayList<User>();
		Iterable<User> userIter = userRepo.findAll();
		userIter.forEach(e ->userList.add(e));
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	@DeleteMapping("/{userId}")
	public HttpStatus deleteUser(@PathVariable Long userId)
	{
		userRepo.deleteById(userId);		
		return HttpStatus.OK;
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> rerieveUser(@PathVariable Long userId) throws UserNotFoundException
	{		
		Optional<User> userOptional = userRepo.findById(userId);
		User user = userOptional.orElseThrow(UserNotFoundException::new);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
}
