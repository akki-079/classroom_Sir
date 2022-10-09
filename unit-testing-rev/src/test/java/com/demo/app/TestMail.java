<<<<<<< HEAD
package com.demo.app;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMail {

	//Message message = new Message("test header", "test Body");
	Message message = mock(Message.class); //dummy object, mock creates mock message,methods are empty
	Mail mail = new Mail("a@gmail.com","b@gmail.com",message);
	
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
	} //got error should resolve 
}
=======
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
>>>>>>> 45987a59c53394b74bc91bb9c1a6a67fef44b04c
