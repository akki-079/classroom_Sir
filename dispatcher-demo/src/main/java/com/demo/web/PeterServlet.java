package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PeterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String driver = getServletContext().getInitParameter("driver");
		out.write("<h1>Welcome to Peter's Web site</h1>");
		out.write("<h1> Got the Driver Value " + driver + "</h1>");
	}
}
