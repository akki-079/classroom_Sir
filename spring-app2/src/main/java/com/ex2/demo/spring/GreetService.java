package com.ex2.demo.spring;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class GreetService {
	
	//@Autowired
	@Qualifier("goodMorning")
	//@Inject
	@Resource
	private Greet greet;
	
	public void greet() {
		System.out.println(greet.greetMessage());
	}

	
	
}
