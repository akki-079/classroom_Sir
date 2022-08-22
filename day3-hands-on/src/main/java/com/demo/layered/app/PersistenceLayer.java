package com.demo.layered.app;

public class PersistenceLayer {

	public String save(String message) {
		System.out.println("saving message : "+message);
		return "Message saved";
	}
}
