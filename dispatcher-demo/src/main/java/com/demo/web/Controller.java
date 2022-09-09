package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("username");
		
		switch (name) {
		case "john":
			RequestDispatcher rd = req.getRequestDispatcher("/john");
			req.setAttribute("message", "Controller Says Hi");
			rd.forward(req, resp);
			break;
		case "peter":
			RequestDispatcher rd1 = req.getRequestDispatcher("/peter");
			rd1.forward(req, resp);
			break;
		case "greet":
			RequestDispatcher rd2 = req.getRequestDispatcher("/greet");
			rd2.include(req, resp);
			out.write("<h1>You are back in Controller</h1>");
			break;
		default:
			//resp.sendRedirect("http://google.co.in");
			//resp.sendRedirect("404.html");
			resp.sendError(404);
			break;
		}
	}
}
