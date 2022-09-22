package com.demo.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.data.Data;
import com.demo.spring.entity.Emp;

@Controller

public class EmpController {
	
	public EmpController() {
		System.out.println("COntroller Created..");
	}
	/*
	 * @RequestMapping(path = "/index", method = RequestMethod.GET) public String
	 * indexPage() { return "index"; }
	 * 
	 * @RequestMapping(path = "/finder", method = RequestMethod.GET) public String
	 * getFinderPage() { return "finder"; }
	 * 
	 * @RequestMapping(path = "/register", method = RequestMethod.GET) public String
	 * getRegisterPage() { return "register"; }
	 */

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView();
		List<Emp> empList = new ArrayList<>(Data.getData().values());
		mv.setViewName("list");
		mv.addObject("eList", empList);
		return mv;
	}

	@RequestMapping(path = "/register1", method = RequestMethod.POST)
	public String register(Emp e) {
		Data.getData().put(e.getEmpId(), e);
		return "index";
	}
}
