package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String getPage() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String name, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();
		if (name.equals(password)) {
			mv.setViewName("success");
			mv.addObject("user", name);
		} else {
			mv.setViewName("failure");
			mv.addObject("user", name);
		}
		return mv;

	}
}
