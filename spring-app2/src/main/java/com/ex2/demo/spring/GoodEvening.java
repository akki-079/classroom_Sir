package com.ex2.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodEvening implements Greet {

	@Autowired
	private String name;
	
	@Override
	public String greetMessage() {
		return "Good Evening to you "+name;
	}

}
