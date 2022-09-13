package com.demo.spring;

public class GreetService {
	private Greet greet;

	public void greet() {
		System.out.println(greet.greetMessage());
	}

	public void setGreet(Greet greet) {
		this.greet = greet;
	}
	
	
}
