package com.demo.spring;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EmpRestControllerMockMvcTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	EmpRepository empRepository;
	
	@Test
	public void test_updateSalary() throws Exception {
		when(empRepository.findById(105)).thenReturn(Optional.of(new Emp(105, "aaa", "bbb", 40000.0)));
		when(empRepository.updateSalary(105, 78000)).thenReturn(1);
		
		mvc.perform(patch("/update/105/78000"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.status").value("Salary Updated"));
		
	}

	@Test
	public void test_updateSalaryFailure() throws Exception {
		when(empRepository.findById(105)).thenReturn(Optional.empty());
				
		mvc.perform(patch("/update/105/78000"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.status").value("Emp Does not exist"));
		
	}
	
	@Test
	public void testSave() throws Exception{
		Emp emp= new Emp(130, "Preetam", "Noida", 90000.0);
		ObjectMapper mapper=new ObjectMapper();
		String empJson=mapper.writeValueAsString(emp);
		
		when(empRepository.existsById(130)).thenReturn(false);
			
		
		mvc.perform(post("/save").content(empJson).contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.status").value("Emp saved"));
		
	}
}
