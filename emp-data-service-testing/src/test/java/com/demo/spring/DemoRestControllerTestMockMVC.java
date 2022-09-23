package com.demo.spring;

import static org.hamcrest.CoreMatchers.containsString;import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //resolves localserverport, template
@AutoConfigureMockMvc
public class DemoRestControllerTestMockMVC {

	@Autowired
	MockMvc mvc;
	
	@Test
	public void testDemoRestController() throws Exception {
		mvc.perform(get("/info"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("REST")));
	}
	
}
