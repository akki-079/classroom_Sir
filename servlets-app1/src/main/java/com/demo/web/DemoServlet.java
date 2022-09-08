package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println("Processing requset by "+Thread.currentThread().getName());
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("username");
		
		out.write("<h1>Hello"+name+" from Demo Servlet</h1>");
	}

}
