package com.demo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.maths.Mail;
import com.demo.maths.Message;

@TestInstance(Lifecycle.PER_CLASS)
public class MailIntTest {

	Mail mail;
	
	@BeforeAll
	public void init() {
		Message message=new Message("Class Info","Class ends at 5:40pm today");
		mail=new Mail("participants", "Instructor", message);
	}
	
	@Test
	public void testMailMessageBody() {
		String message=mail.getMessage().getBody();
		Assertions.assertTrue(message.contains("5:40"));
	}
}
