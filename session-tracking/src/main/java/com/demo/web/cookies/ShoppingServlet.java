package com.demo.web.cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shopping")
public class ShoppingServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String itemName=request.getParameter("itemName");
		String itemPrice=request.getParameter("itemPrice");
		
		Cookie c1=new Cookie(itemName, itemPrice);
		
		response.addCookie(c1);
		System.out.println("Cookie added");
		request.getRequestDispatcher("/shop.html").forward(request, response);
		
	}

}
