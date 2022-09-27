package com.demo.app;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMail {

	//Message message=new Message("test header", "test Body");
	Message message=mock(Message.class);
	
	Mail mail=new Mail("a@gmail.com","b@gmail.com",message);
	
	@Test
	public void printMockMessage() {
		System.out.println(message.getClass().getName());
		System.out.println(message.getClass().getSuperclass().getName());
	}
	
	@Test
	public void testGetFromAddress() {
		Assertions.assertTrue(mail.getFromAddress().contains("b"));
	}
	
	@Test
	public void testMessageInMail() {
		when(message.getMessageDetails()).thenReturn("message here");
		Assertions.assertTrue(mail.getMailDetails().contains("message"));
	}
}
