package com.demo.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.demo.spring.entity.User;
import com.demo.spring.exception.UserAlreadyExistsException;
import com.demo.spring.exception.UserNotFoundException;
import com.demo.spring.repository.UserRepository;
import com.demo.spring.util.Message;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(path = "/{userid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findOneUser(@PathVariable("userid") Integer userId) {
		Optional<User> userOp = userRepository.findById(userId);
		if(userOp.isPresent()) {
			return ResponseEntity.ok(userOp.get());
		}else {
			throw new UserNotFoundException();
		}
	}
	
	@GetMapping(path = "/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> listAllUser(){
		return ResponseEntity.ok(userRepository.findAll());
	}

	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveEmp(@RequestBody User user) {
		if (userRepository.existsById(user.getUserId())) {
			throw new UserAlreadyExistsException();
		} else {
			userRepository.save(user);
			return ResponseEntity.ok(new Message("User Saved!"));
		}
	}
	
	@DeleteMapping(path = "/delete/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> deleteEmp(@PathVariable("userid") int userId) {
		Optional<User> userOp = userRepository.findById(userId);

		if (userOp.isPresent()) {
			userRepository.deleteById(userId);
			return ResponseEntity.ok(new Message("Deleted User"));
		} else {
			throw new UserNotFoundException();
		}
	}
	
    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> updateEmp(@RequestBody User user) {
        if (userRepository.existsById(user.getUserId())) {
            userRepository.save(user);
            return ResponseEntity.ok(new Message("User updated"));
        } else {
            throw new UserNotFoundException();
        }
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Message> handleUserNotFoundException(UserNotFoundException une) {
        return ResponseEntity.ok(new Message("User not found"));
    }
    
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Message> handleExsistsNotFoundException(UserAlreadyExistsException uae) {
        return ResponseEntity.ok(new Message("User already exists"));
    }
}
