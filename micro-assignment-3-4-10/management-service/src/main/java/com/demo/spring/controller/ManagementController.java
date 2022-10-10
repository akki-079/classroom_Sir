package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.dto.ContactDTO;
import com.demo.spring.dto.UserDTO;
import com.demo.spring.exception.UserAlreadyExistsException;
import com.demo.spring.exception.UserNotFoundException;
import com.demo.spring.util.Message;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	RestTemplate restTemplateOne;

	@Autowired
	@Qualifier("restTemplateTwo")
	RestTemplate restTemplateTwo;

	@GetMapping(path = "/contact/{userid}")
	@CircuitBreaker(name = "management-service", fallbackMethod = "fallbackGetListAllContacts")
	public ResponseEntity getContactInUser(@PathVariable("userid") Integer userId) {
		UserDTO userDto = null;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<Void> req = new HttpEntity<>(headers);
		ResponseEntity<UserDTO> response1 = restTemplateOne.exchange("http://user-service/user/" + userId,
				HttpMethod.GET, req, UserDTO.class);
		userDto = response1.getBody();

		ResponseEntity<List<ContactDTO>> response2 = restTemplateTwo.exchange(
				"http://contact-service/contact/listcontacts/" + userId, HttpMethod.GET, req,
				new ParameterizedTypeReference<List<ContactDTO>>() {
				});

		List<ContactDTO> conList = response2.getBody();
		userDto.setContactList(conList);
		return ResponseEntity.ok(userDto);

	}

	@GetMapping(path = "/findcontact/{contacttag}/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name = "management-service", fallbackMethod = "fallbackGetFindContact")
	public ResponseEntity<List<ContactDTO>> findContact(@PathVariable("contacttag") String ct,
			@PathVariable("userid") Integer userId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> req = new HttpEntity<>(headers);
		ResponseEntity<UserDTO> response1 = restTemplateOne.exchange("http://user-service/user/" + userId,
				HttpMethod.GET, req, UserDTO.class);
		UserDTO userDto = response1.getBody();

		if (userDto.getUserId() != 0) {
			ResponseEntity<List<ContactDTO>> response2 = restTemplateTwo.exchange(
					"http://contact-service/contact/listtag/" + ct + "/" + userId, HttpMethod.GET, req,
					new ParameterizedTypeReference<List<ContactDTO>>() {
					});
			List<ContactDTO> contactList = response2.getBody();
			return ResponseEntity.ok(contactList);
		} else {
			throw new UserNotFoundException();
		}
	}

	@GetMapping(path = "/deletecontacts/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name = "management-service", fallbackMethod = "fallbackGetDelete")
	public ResponseEntity<Message> deleteAllContact(@PathVariable("userid") Integer userId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<Void> req = new HttpEntity<>(headers);
		ResponseEntity<String> response1 = restTemplateOne.exchange("http://user-service"
				+ "/user/delete/" + userId,
				HttpMethod.DELETE, req, String.class);
		System.out.println(response1.getBody());

		if (response1.getBody().contains("Deleted User")) {
			ResponseEntity<ContactDTO> response2 = restTemplateTwo.exchange(
					"http://contact-service/contact/deleteallcontact/" + userId, HttpMethod.DELETE, req, ContactDTO.class);
			response2.getStatusCode();
			return ResponseEntity.ok(new Message("Contacts deleted..."));
		} else {
			throw new UserNotFoundException();
		}
	}
	
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@CircuitBreaker(name = "management-service", fallbackMethod = "fallbackGetSave")
    public ResponseEntity<Message> saveUserAndContact(@RequestBody UserDTO userDto) {

        
        ContactDTO cDto=userDto.getContactList().get(0);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        
        HttpEntity<UserDTO> req1 = new HttpEntity<>(userDto,headers);
        
        HttpEntity<ContactDTO> req2 = new HttpEntity<>(cDto,headers);

        ResponseEntity<String> response1 = restTemplateOne.exchange("http://user-service/user/",
                HttpMethod.POST, req1, String.class);

        //System.out.println(response1.getBody());
        if (response1.getBody().contains("User Saved!")) {

            restTemplateTwo.exchange("http://contact-service/contact/", HttpMethod.POST, req2,
                    String.class);

            return ResponseEntity.ok(new Message("User and his contact saved successfully"));

        } else {
            throw new UserAlreadyExistsException();
        }
    }

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Message> handleUserNotFoundException(UserNotFoundException ex) {
		return ResponseEntity.ok(new Message("User Not found"));
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Message> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
		return ResponseEntity.ok(new Message("User already exists"));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle404(Exception ex) {
		return ResponseEntity.status(404).body(ex.getMessage());
	}


	public ResponseEntity fallbackGetListAllContacts(Integer userId,Exception ex) {
        return ResponseEntity.ok("Service Down, please try after some time..");
    }
    public ResponseEntity fallbackGetFindContact(String ct,Integer userId,Exception ex) {
        return ResponseEntity.ok("Service Down, please try after some time..");
    }
    public ResponseEntity fallbackGetDelete(Integer userId,Exception ex) {
        return ResponseEntity.ok("Service Down, please try after some time..");
    }
    public ResponseEntity fallbackGetSave(UserDTO userDto,Exception ex) {
        return ResponseEntity.ok("Service Down, please try after some time..");
    }
}
