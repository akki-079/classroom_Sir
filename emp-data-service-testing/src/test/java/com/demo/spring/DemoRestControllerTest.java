package com.demo.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoRestControllerTest {

	@LocalServerPort
	int port;

	@Autowired
	TestRestTemplate template;
	
	@Test
	public void testDemoRestController() {
		ResponseEntity<String> response=template.getForEntity("http://localhost:"+port+"/info", String.class);
		Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
		Assertions.assertTrue(response.getBody().contains("REST"));
	}

}
