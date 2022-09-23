package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetClientRunner implements CommandLineRunner { //executes as soon as bean is created,initialization

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		String response = restTemplate.getForObject("http://localhost:8080/find/110", String.class);

		System.out.println(response);


	}

}
