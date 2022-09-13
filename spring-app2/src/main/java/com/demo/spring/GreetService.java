package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:app.properties")
public class GreetService {
	
	@Autowired
	@Qualifier("goodMorning")
	private Greet greet;
	
	@Value("${name}")
	String name;

	public void greet() {
		System.out.println(greet.greetMessage()+" "+name);
	}

	
	
}
