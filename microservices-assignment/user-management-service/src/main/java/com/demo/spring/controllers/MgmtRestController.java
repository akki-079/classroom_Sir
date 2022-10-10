package com.demo.spring.controllers;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.ContactDTO;
import com.demo.spring.UserDTO;

@RestController
@RequestMapping("/mgmt")
public class MgmtRestController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(path = "/user/{uno}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getContactsForUser(@PathVariable("uno") int uno) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<Void> req= new HttpEntity<Void>(headers);
		ResponseEntity<UserDTO> response1 = restTemplate.exchange("http://localhost:8190/user/"+uno, HttpMethod.GET,req, UserDTO.class);
		UserDTO userDTO = response1.getBody();
		
		ResponseEntity<List<ContactDTO>> response2 = restTemplate.exchange("http://localhost:8188/contact/"+uno, HttpMethod.GET,req,new ParameterizedTypeReference<List<ContactDTO>>() {
			
		});
		
		List<ContactDTO> contactList = response2.getBody();
		userDTO.setContactList(contactList);
		return ResponseEntity.ok(userDTO);

	}
}
