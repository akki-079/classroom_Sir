package com.demo.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/emp")
	public Emp getEmp() {
		return new Emp(100, "John","Hyderabad",300000.0);
	}
}
