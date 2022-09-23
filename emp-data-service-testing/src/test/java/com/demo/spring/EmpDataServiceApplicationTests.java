package com.demo.spring;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class EmpDataServiceApplicationTests {

	@Autowired
	MockMvc mvc;
	
	@MockBean
	EmpRepository empRepo;
	
	@Test
	public void testfindOneEmp() throws Exception {
		when(empRepo.findById(110)).thenReturn(Optional.of(new Emp(110,"vinya", "hubli",9000.0)));
		mvc.perform(get("/find/110"))
		.andDo(print()) //prints res and req both
		.andExpect(status().isOk()) // to check if res is ok
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.name").value("vinya"));
	}
	
	@Test
	public void testSaveEmp() throws Exception {
		Emp emp = new Emp(110,"vinya", "hubli", 9000.0);
		ObjectMapper mapper = new ObjectMapper();
		String empJson=mapper.writeValueAsString(emp);

		when(empRepo.existsById(110)).thenReturn(false); //forcefully making it false
		
		mvc.perform(post("/save").content(empJson).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("Emp Saved")); //$ = complete json returned value
	}
	
	@Test
	public void testUpdateSalary() throws Exception {
		Emp emp = new Emp(110,"vinya", "hubli", 9000.0);
		
		when(empRepo.findById(110)).thenReturn(Optional.of(emp));
		when(empRepo.updateSalary(110,90000.0)).thenReturn(1);
		
		mvc.perform(patch("/updatesal/110/90000.0"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.status").value("Salary Updated"));
	}
	
	@Test
	public void testUpdateSalaryFailure() throws Exception {
		Emp emp = new Emp(110,"vinya", "hubli", 9000.0);
		
		when(empRepo.findById(110)).thenReturn(Optional.empty()); // proxy - fake objects
		when(empRepo.updateSalary(110,90000.0)).thenReturn(1);
		
		mvc.perform(patch("/updatesal/110/90000.0"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(jsonPath("$.status").value("Emp does not exist"));
	}
}
