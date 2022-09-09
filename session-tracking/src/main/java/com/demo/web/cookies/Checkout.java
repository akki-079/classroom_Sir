package com.demo.web.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		out.print("<h2> Your Cart Details</h1>");
		out.print("<hr><p>");
		for(Cookie c:cookies) {
			out.write("<h2>"+c.getName()+" : "+c.getValue()+"</h2>");
		}
		
		out.print("<h2> Thank you for Shopping with us</h1>");

	}

}
