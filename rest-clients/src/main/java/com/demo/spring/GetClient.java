package com.demo.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetClient {
	public static void main(String[] args) {
		final String BASE_URL="http://localhost:8181";
		RestTemplate restTemplate = new RestTemplate();
		
		EmpDTO empData=new EmpDTO(123,"Srinivas","Bangalore",90000.0);
/*
		String response = restTemplate.postForObject(BASE_URL+"/save",empData, String.class);

		System.out.println(response);

		

		ResponseEntity<String> resp = restTemplate.postForEntity(BASE_URL+"/save",empData, String.class);

		System.out.println(resp.getBody());
		
		*/
		
		//Exchange Starts
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<EmpDTO> req=new HttpEntity<>(empData,headers);
		
		ResponseEntity<String> resp2=
				restTemplate.exchange(BASE_URL+"/save", HttpMethod.POST, req, String.class);
	
		System.out.println(resp2.getBody());
	}
}
