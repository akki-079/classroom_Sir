package com.demo.spring;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.spring.entity.Contact;
import com.demo.spring.repository.ContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ContactControllerMockMvcTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	ContactRepository contactRepository;

	@Autowired
	TestRestTemplate template;

	@Test
	public void testFindAllListByTag() throws Exception {
		List<Contact> list = new ArrayList<>();
		list.add(new Contact(10, "home", "Chennai", "567483", "ion@gmail.com", 14));
		when(contactRepository.findByTagAndUserId("office", 10)).thenReturn(list);
		mvc.perform(get("/contact/listtag/office/10")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(content().json(
						"[ {'contactId': 10,'contactTag': 'home','city': 'Chennai','pinCode': '567483','email':'ion@gmail.com','userId': 14}]"));

	}

	@Test
	public void testDeleteSuccess() throws Exception {
		when(contactRepository.existsById(600)).thenReturn(true);
		mvc.perform(delete("/contact/delete/600").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("Contact Deleted"));
	}

	@Test
	public void testDeleteFailure() throws Exception {
		when(contactRepository.existsById(600)).thenReturn(false);
		mvc.perform(delete("/contact/delete/600").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print())
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("Contact not found"));
	}

	@Test
	public void testDeleteAll() throws Exception {

		when(contactRepository.deleteAllById(100)).thenReturn(100);

		mvc.perform(delete("/contact/deleteall/100").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.status").value("Contacts deleted with userId:100"));

	}
	   @Test
	    public void testUpdateSuccess() throws Exception {

	        Contact contact = new Contact(100,"Home","Bailhongal","591102","xyz@gmail.com",10);
	        ObjectMapper mapper = new ObjectMapper();
	        String contactJson = mapper.writeValueAsString(contact);
	        when(contactRepository.existsById(100)).thenReturn(true);
	        
	        
	        mvc.perform(patch("/contact/update/100/Mangalore/592102").content(contactJson).contentType(MediaType.APPLICATION_JSON_VALUE))// consumes JSON
	                .andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	                .andExpect(jsonPath("$.status").value("Contacts address updated "));
	    }
	    
	    @Test
	    public void testUpdateFailure() throws Exception {

	        Contact contact = new Contact(100,"Home","Bailhongal","591102","xyz@gmail.com",10);
	        ObjectMapper mapper = new ObjectMapper();// from jackson
	        String contactJson = mapper.writeValueAsString(contact);
	        when(contactRepository.existsById(100)).thenReturn(false);

	        mvc.perform(patch("/contact/update/100/Bailhongal/591102").content(contactJson).contentType(MediaType.APPLICATION_JSON_VALUE))// consumes JSON
	                .andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	                .andExpect(jsonPath("$.status").value("Contact not found"));
	    }

	    @Test
        public void testSaveSuccess() throws Exception {
        Contact contact = new Contact(100,"home","Bangalore","511","john@gmail.com",10);
            ObjectMapper mapper = new ObjectMapper();// from jackson
            String contactJson = mapper.writeValueAsString(contact);
           when(contactRepository.existsById(100)).thenReturn(false);
            mvc.perform(post("/contact/").content(contactJson).contentType(MediaType.APPLICATION_JSON_VALUE))// consumes JSON
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(jsonPath("$.status").value("Contact Saved!"));
        }
     
    
        @Test
        public void testSaveFailure() throws Exception {
            Contact contact = new Contact(180,"home","Chennai","571","sare@gmail.com",10);
            ObjectMapper mapper = new ObjectMapper();// from jackson
            String cotactJson = mapper.writeValueAsString(contact);
           when(contactRepository.existsById(180)).thenReturn(true);
            mvc.perform(post("/contact/").content(cotactJson).contentType(MediaType.APPLICATION_JSON_VALUE))// consumes JSON
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(jsonPath("$.status").value("Contact already exists"));
        }
        
        @Test
        public void testFindAllByUserId() throws Exception {
            List<Contact> list = new ArrayList<>();
            list.add(new Contact(10, "home", "Chennai", "567483", "ion@gmail.com", 14));
            when(contactRepository.findAllContactsByUser(10)).thenReturn(list);
            mvc.perform(get("/contact/listcontacts/10")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(content().json(
                            "[ {'contactId': 10,'contactTag': 'home','city': 'Chennai','pinCode': '567483','email':'ion@gmail.com','userId': 14}]"));
        }
        @Test
        public void FindAllTest() throws Exception{
            List<Contact> list = new ArrayList<>();
            list.add(new Contact(10, "home", "Chennai", "567483", "ion@gmail.com", 14));
            when(contactRepository.findAll()).thenReturn(list);
            mvc.perform(get("/contact/"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(content().json("[ {'contactId': 10,'contactTag': 'home','city': 'Chennai','pinCode': '567483','email':'ion@gmail.com','userId': 14}]"));

        }
}