package com.demo.app;

public class MailEditor {

	public Mail compose(String to, String from, String header, String body) {
		Message message = new Message(header, body);
		Mail mail = new Mail();
		mail.setToAddress(to);
		mail.setFromAddress(from);
		mail.setMessage(message);
		return mail;
	}

	public void send() {
		Mail mail = compose("john@gmail.com", "peter@gmail.com", "meeting", "be present at 5:00pm today");
		System.out.println(mail.getMessage().getBody());
	}

}
