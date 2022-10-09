<<<<<<< HEAD
package com.demo.app;

public class Mail {
	private String toAddress;
	private String fromAddress;
	private Message message;

	public Mail() {

	}

	
	public Mail(String toAddress, String fromAddress, Message message) {
		super();
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		this.message = message;
	}

	public String getMailDetails() {
		return fromAddress+" "+toAddress+" "+message.getHeader();
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
=======
package com.demo.app;

public class Mail {

	private String toAddress;
	private String fromAddress;
	private Message message;

	public Mail(String toAddress, String fromAddress, Message message) {
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		this.message = message;

	}

	public String getMailDetails() {
		return fromAddress + " " + toAddress + " " + message.getMessageDetails();
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
>>>>>>> 45987a59c53394b74bc91bb9c1a6a67fef44b04c
