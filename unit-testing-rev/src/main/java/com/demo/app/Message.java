<<<<<<< HEAD
package com.demo.app;

public class Message {
	private String header;
	private String body;

	public Message(String header, String body) {
		this.header = header;
		this.body = body;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getMessageDetails() {
		System.out.println("message get details called");
		return header+":"+body;
	}
}
=======
package com.demo.app;

public class Message {

	private String header;
	private String body;

	public Message(String header, String body) {
		this.header = header;
		this.body = body;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public String getMessageDetails() {
		System.out.println("message: getMessageDetails() called..");
		return header+":"+body;
	}

	
}
>>>>>>> 45987a59c53394b74bc91bb9c1a6a67fef44b04c
