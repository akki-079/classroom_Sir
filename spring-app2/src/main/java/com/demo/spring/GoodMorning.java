package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class GoodMorning implements Greet {

	@Override
	public String greetMessage() {
		return "Good morning to you";
	}

}
