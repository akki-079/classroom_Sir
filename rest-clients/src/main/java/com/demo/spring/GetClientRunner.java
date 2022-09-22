package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetClientRunner implements CommandLineRunner {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public void run(String... args) throws Exception {

		String response = restTemplate.getForObject("http://localhost:8181/find/104", String.class);

		System.out.println(response);
	}

}
