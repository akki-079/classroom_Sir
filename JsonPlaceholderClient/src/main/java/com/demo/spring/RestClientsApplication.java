package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientsApplication.class, args); //creates ioc,creates a bean of component and run is called automatically
	}
	
	@Bean
	public RestTemplate restTemplate() {
		  return new RestTemplateBuilder().build();
	}

}
