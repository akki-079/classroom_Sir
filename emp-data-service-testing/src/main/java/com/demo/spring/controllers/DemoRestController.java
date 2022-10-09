<<<<<<< HEAD
package com.demo.spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller         //search for view
@RestController         // combination of controller and response body
public class DemoRestController {
	
	
	@RequestMapping(path="/info", method = RequestMethod.GET)
	public /* @ResponseBody,not required since we use restcontroller */ String info() {  //consider this as response ,no view
		return "This is a REST service";
	}
}
=======
package com.demo.spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	
	
	@RequestMapping(path="/info", method = RequestMethod.GET)
	public String info() {
		return "This is a REST Service";
	}
}
>>>>>>> 45987a59c53394b74bc91bb9c1a6a67fef44b04c
