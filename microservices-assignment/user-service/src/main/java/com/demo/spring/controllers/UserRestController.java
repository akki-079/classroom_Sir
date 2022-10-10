package com.demo.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.demo.spring.entity.User;

import com.demo.spring.exceptions.UserNotFoundException;

import com.demo.spring.repository.UserRepository;

import com.demo.spring.util.Message;

@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	UserRepository userRepo; 
	
	@GetMapping(path="/{uno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findUserById(@PathVariable("uno") int id) throws UserNotFoundException{
		Optional<User> userOp = userRepo.findById(id);
		if(userOp.isPresent()) {
			return ResponseEntity.ok(userOp.get());
		} else {
			throw new UserNotFoundException();
		}
	}
	
	@PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> save(@RequestBody User u) {
		if(userRepo.existsById(u.getUserId())) {
			return ResponseEntity.ok(new Message("User already exists"));
		} else {
			userRepo.save(u);
			return ResponseEntity.ok(new Message("User saved"));
		}
	}
	
	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listUser() {
		return ResponseEntity.ok(userRepo.findAll());
	}
	
	@PutMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateUser(@RequestBody User u) throws UserNotFoundException{
		if(userRepo.existsById(u.getUserId())) {
			userRepo.save(u);
			return ResponseEntity.ok(new Message("User updated"));	
		} else {
			throw new UserNotFoundException();
		}
	}
	
	@PostMapping(path = "/{uno}")
	public ResponseEntity<Message> removeUser(@PathVariable int uno) throws UserNotFoundException{
		if(userRepo.existsById(uno)) {
			userRepo.deleteById(uno);
			return ResponseEntity.ok(new Message("User removed"));	
		} else {
			throw new UserNotFoundException();
		}
	}
	
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Message> handleEmpNotFound(UserNotFoundException ex){
		return ResponseEntity.ok(new Message("User not found.."));
	}
}
