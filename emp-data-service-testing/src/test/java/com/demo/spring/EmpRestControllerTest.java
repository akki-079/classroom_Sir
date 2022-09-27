package com.demo.spring;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmpRestControllerTest {

	@LocalServerPort
	int port;

	@Autowired
	TestRestTemplate template;
	
	
	RestTemplate patchTemplate=new RestTemplate();

	@Test
	public void testFindOne() {
		ResponseEntity<Emp> response = template.getForEntity("http://localhost:" + port + "/find/102", Emp.class);

		Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
		Assertions.assertTrue(response.getHeaders().getContentType().equals(MediaType.APPLICATION_JSON));
		Assertions.assertEquals(102, response.getBody().getEmpId());
	}

	@Test
	public void testFindOneFailure() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port + "/find/1020",
				String.class);

		Assertions.assertTrue(response.getStatusCodeValue() == 404);
		Assertions.assertTrue(response.getHeaders().getContentType().equals(MediaType.APPLICATION_JSON));
		// Assertions.assertEquals("Emp not found", response.getBody().getStatus());

	}

	@Test
	public void updateSalary() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<Void> req = new HttpEntity<>(headers);
//---------
		HttpClient httpClient = HttpClientBuilder.create().build();
	patchTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
//---
		ResponseEntity<String> response = patchTemplate.exchange("http://localhost:" + port + "/update/102/56000",
				HttpMethod.PATCH, req, String.class);
		Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testList() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<Void> req = new HttpEntity<>(headers);

		ResponseEntity<List<Emp>> response = template.exchange("http://localhost:" + port + "/list", HttpMethod.GET,
				req, new ParameterizedTypeReference<List<Emp>>() {
				});
		Assertions.assertTrue(response.getBody().size() > 0);
	}
}
