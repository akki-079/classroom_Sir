package com.demo.maths;

public class Mail {

	private String toAddress;
	private String fromAddress;
	private Message message;
	public Mail(String toAddress, String fromAddress) {
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
	
	}
	
	public String getMailDetails() {
		return fromAddress+" "+toAddress+" "+message.getBody();
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
