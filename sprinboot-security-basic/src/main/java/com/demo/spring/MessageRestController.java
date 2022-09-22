package com.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

	@GetMapping(path="/gethello")
	public String getCall() {
		return "GET: Hello there";
	}
	
	@PostMapping(path="/posthello")
	public String postCall() {
		return "POST: Hello there";
	}
}
