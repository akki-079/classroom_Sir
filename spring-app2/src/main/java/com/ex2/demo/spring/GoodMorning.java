package com.ex2.demo.spring;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
@Named
public class GoodMorning implements Greet {

	@Autowired
	private String name;
	
	@Override
	public String greetMessage() {
		return "Good morning to you "+name;
	}

}
