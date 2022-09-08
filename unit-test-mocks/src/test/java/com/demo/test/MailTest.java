package com.demo.test;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.maths.Mail;
import com.demo.maths.Message;

@ExtendWith(MockitoExtension.class)
public class MailTest {

	@Mock
	Message message;
	
	@InjectMocks
	Mail mail= new Mail("me", "all");
	
	@Test
	public void testMailMessage() {
		when(mail.getMessage().getBody()).thenReturn("Hello all");
		
		Assertions.assertTrue(mail.getMessage().getBody().contains("all"));
	}
	
}
