package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Contact;
import com.demo.spring.exception.ContactAlreadyExistsException;
import com.demo.spring.exception.ContactNotFoundException;
import com.demo.spring.repository.ContactRepository;
import com.demo.spring.util.Message;

@RestController
@RequestMapping(path = "/contact")
public class ContactController {

	@Autowired
	ContactRepository contactRepository;
	
	@GetMapping(path = "/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contact>> listAllContacts(){
		return ResponseEntity.ok(contactRepository.findAll());
	}
	
	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveEmp(@RequestBody Contact contact) {
		if (contactRepository.existsById(contact.getContactId())) {
			throw new ContactAlreadyExistsException();
		} else {
			contactRepository.save(contact);
			return ResponseEntity.ok(new Message("Contact Saved!"));
		}
	}
	
	 @DeleteMapping(path = "/delete/{contactId}", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Message> deleteContact(@PathVariable("contactId") int id) {
	        if (contactRepository.existsById(id)) {
	            contactRepository.deleteById(id);
	            return ResponseEntity.ok(new Message("Contact Deleted"));

	        } else {
	            throw new ContactNotFoundException();

	        }
	    }
	
    @PatchMapping(path = "/update/{contactid}/{city}/{pin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> updateEmp(@PathVariable("contactid") Integer contactId,@PathVariable("city") String city, @PathVariable("pin") String pinCode ) {
        if (contactRepository.existsById(contactId)) {
            contactRepository.updateAddress(contactId, city, pinCode);
            return ResponseEntity.ok(new Message("Contacts address updated "));
        } else {
            throw new ContactNotFoundException();
        }
    }
    
    @GetMapping(path = "/listcontacts/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>> listContactsbyUserId(@PathVariable("userid") Integer id) {
        return ResponseEntity.ok(contactRepository.findAllContactsByUser(id));
    }
    
    @GetMapping(path = "/listtag/{contacttag}/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>> findByTagAndId(@PathVariable("contacttag") String tag, @PathVariable("userid") Integer userId) {
        return ResponseEntity.ok(contactRepository.findByTagAndUserId(tag, userId));
    }
    
    @DeleteMapping(path = "/deleteall/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> deleteAll(@PathVariable("userId") int id) {
        contactRepository.deleteAllById(id);
        return ResponseEntity.ok(new Message("Contacts deleted with userId:"+id));
    }
    
    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<Message> handleUserNotFoundException(ContactNotFoundException une) {
        return ResponseEntity.ok(new Message("Contact not found"));
    }
    
    @ExceptionHandler(ContactAlreadyExistsException.class)
    public ResponseEntity<Message> handleExsistsNotFoundException(ContactAlreadyExistsException uae) {
        return ResponseEntity.ok(new Message("Contact already exists"));
    }
}
