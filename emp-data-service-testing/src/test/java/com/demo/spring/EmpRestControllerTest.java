package com.demo.spring;



import java.util.List;

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
import org.springframework.http.ResponseEntity;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmpRestControllerTest {



   @LocalServerPort
    int port;
    
    @Autowired
    TestRestTemplate template;



   @Autowired
    EmpRepository empRepository;
    
    @Test
    public void testEmpRestControllerFindFailure() {
        ResponseEntity<String> response= template.getForEntity("http://localhost:"+port+"/find/11", String.class);
        Assertions.assertTrue(response.getBody().contains("Emp"));
    }
    @Test
    public void testEmpRestControllerFind() {
        ResponseEntity<String> response= template.getForEntity("http://localhost:"+port+"/find/110", String.class);
        Assertions.assertTrue(response.getBody().contains("vinay"));
    }
    @Test
    public void testEmpRestControllerSave() {
        Emp emp = new Emp(110, "vinay chittor", "bangalore", 8000.0);
        ResponseEntity<String> response= template.postForEntity("http://localhost:"+port+"/save",emp, String.class);
          Assertions.assertTrue(response.getBody().contains("Emp Already Exsists"));
    }
    @Test
    public void testEmpRestControllerSaveFailure() {
    	Emp emp = new Emp(1100, "vinay chittor G", "bangalore", 8000.0);
    	ResponseEntity<String> response= template.postForEntity("http://localhost:"+port+"/save",emp, String.class);
    	Assertions.assertTrue(response.getBody().contains("Emp Saved"));
    }
    @Test
    public void getEmpListTest()
    {
        HttpHeaders headers = new HttpHeaders();
       headers.set("Accept", "application/json");
       HttpEntity<Void> req = new HttpEntity<>(headers);
                                                   //
       ResponseEntity<List<Emp>> empList = template.exchange("http://localhost:" + port + "/list",
               HttpMethod.GET, req, new ParameterizedTypeReference<List<Emp>>() {
               });
       Assertions.assertTrue(empList.getBody().size() > 0);
    }
}