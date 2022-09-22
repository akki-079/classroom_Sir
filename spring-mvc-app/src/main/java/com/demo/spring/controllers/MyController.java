package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(path = "/app", method = RequestMethod.GET)
	public String greet() {
		System.out.println("Inside Controller....");
		return "demo";
	}
	
	@RequestMapping(path = "/app", method = RequestMethod.POST)
	public String greet2() {
		System.out.println("Inside POST Controller....");
		return "demo";
	}
}
