package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifecycleDemo extends HttpServlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet initialized......");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		out.write("<h1> Request processed by "+Thread.currentThread().getName()+"</h1>");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet is now removed...");
	}
}
