package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Processing requset by "+Thread.currentThread().getName());
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<h1>Response to GET Method</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Processing requset by "+Thread.currentThread().getName());
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<h1>Response to POST Method</h1>");
	}
}
