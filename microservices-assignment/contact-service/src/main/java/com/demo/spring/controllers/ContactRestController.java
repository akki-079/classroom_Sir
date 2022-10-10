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

import com.demo.spring.entity.Contact;

import com.demo.spring.exceptions.ContactNotFoundException;

import com.demo.spring.repository.ContactRepository;

import com.demo.spring.util.Message;

@RestController
@RequestMapping("/contact")
public class ContactRestController {
	
	@Autowired
	ContactRepository contactRepo; 
	
	@GetMapping(path="/{cno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contact> findDeptById(@PathVariable("cno") int id) throws ContactNotFoundException{
		Optional<Contact> contOp = contactRepo.findById(id);
		if(contOp.isPresent()) {
			return ResponseEntity.ok(contOp.get());
		} else {
			throw new ContactNotFoundException();
		}
	}
	
	@PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> save(@RequestBody Contact con) {
		if(contactRepo.existsById(con.getContactId())) {
			return ResponseEntity.ok(new Message("Contact already exists"));
		} else {
			contactRepo.save(con);
			return ResponseEntity.ok(new Message("Contact saved"));
		}
	}
	
	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contact>> listDep() {
		return ResponseEntity.ok(contactRepo.findAll());
	}
	
	@PutMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateContact(@RequestBody Contact c){
		if(contactRepo.existsById(c.getContactId())) {
			contactRepo.save(c);
			return ResponseEntity.ok(new Message("Contact updated"));	
		} else {
			return ResponseEntity.ok(new Message("Contact does not exists"));
		}
	}
	
	@PostMapping(path = "/{cno}")
	public ResponseEntity<Message> removeContact(@PathVariable int cno){
		if(contactRepo.existsById(cno)) {
			contactRepo.deleteById(cno);
			return ResponseEntity.ok(new Message("Contact removed"));	
		} else {
			return ResponseEntity.ok(new Message("Contact does not exists"));
		}
	}
	
	
	
	@ExceptionHandler(ContactNotFoundException.class)
	public ResponseEntity<Message> handleEmpNotFound(ContactNotFoundException ex){
		return ResponseEntity.ok(new Message("Contact not found.."));
	}
	

}
