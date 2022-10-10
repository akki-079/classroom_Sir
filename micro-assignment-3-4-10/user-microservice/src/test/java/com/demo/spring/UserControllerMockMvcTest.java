package com.demo.spring;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.spring.entity.User;
import com.demo.spring.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerMockMvcTest {

	
	@Autowired
    MockMvc mvc;

	@MockBean
	UserRepository userRepo;
	
	@Autowired
	TestRestTemplate template;
	
	@Test
	public void testFindSuccess() throws Exception {
		User user = new User(10,"vinay");
		when(userRepo.findById(10)).thenReturn(Optional.of(user));
		mvc.perform(get("/user/10")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.userName").value("vinay"));
	}
	@Test
	public void testFindFailure() throws Exception {
		User user = new User(1000,"vinay");
		when(userRepo.findById(1000)).thenReturn(Optional.empty());
		mvc.perform(get("/user/1000")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User not found"));
	}
	@Test
	public void testFindAll() throws Exception {
		List<User> users = new ArrayList<>();
		users.add(new User(10,"sawad"));
            when(userRepo.findAll()).thenReturn(users);
            mvc.perform(get("/user/"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().json("[ {'userId': 10,'userName': 'sawad'}]"));
	}
	@Test
		public void testSaveSuccess() throws Exception {
			User user = new User(15,"Pari");
			ObjectMapper mapper = new ObjectMapper();
			String userJson = mapper.writeValueAsString(user);

			when(userRepo.existsById(15)).thenReturn(false);
			
			mvc.perform(post("/user/").content(userJson).contentType(MediaType.APPLICATION_JSON_VALUE))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(jsonPath("$.status").value("User Saved!"));
		}
	 @Test
		public void testSaveFailure() throws Exception {
			User user = new User(15,"Pari");
			ObjectMapper mapper = new ObjectMapper();
			String userJson = mapper.writeValueAsString(user);

			when(userRepo.existsById(15)).thenReturn(true);
			
			mvc.perform(post("/user/").content(userJson).contentType(MediaType.APPLICATION_JSON_VALUE))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(jsonPath("$.status").value("User already exists"));
		}
	@Test
	public void testDeleteFailure() throws Exception {

		when(userRepo.existsById(15)).thenReturn(false);
		
		
		mvc.perform(delete("/user/delete/15").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User not found"));
	}
	
	@Test
	public void testUpdateSuccess() throws Exception {

		User user = new User(90,"vinay");
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(user);
		when(userRepo.existsById(90)).thenReturn(true);
		
		
		mvc.perform(put("/user/update").content(userJson).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User updated"));
	}
	@Test
	public void testUpdateFailure() throws Exception {

		User user = new User(2000,"vinay");
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(user);
		when(userRepo.existsById(2000)).thenReturn(false);
		
		
		mvc.perform(put("/user/update").content(userJson).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("User not found"));
	}
	
}
