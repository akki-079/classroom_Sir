package com.demo.spring;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PostClientSecured {
	public static void main(String[] args) {
		final String BASE_URL = "http://localhost:8181";
		EmpDTO empData = new EmpDTO(124, "Karan", "Bangalore", 90000.0);

		RestTemplate restTemplate = new RestTemplate();

		String credentials = "peter:welcome1";
		String encryptedCredntials = new String(Base64.getEncoder().encode(credentials.getBytes()));
		System.out.println(encryptedCredntials);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Basic "+encryptedCredntials);

		HttpEntity<EmpDTO> req = new HttpEntity<>(empData,headers);

		ResponseEntity<String> resp2 = restTemplate.exchange(BASE_URL + "/save", HttpMethod.POST, req, String.class);

		System.out.println(resp2.getBody());
	}
}
