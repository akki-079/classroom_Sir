package com.demo.web.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/shopping2")
public class ShoppingServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String itemName = request.getParameter("itemName");
		String itemPrice = request.getParameter("itemPrice");
		
		HttpSession session=request.getSession(true);
		
		session.setAttribute(itemName, itemPrice);
		
		System.out.println("Data added to http session");
		request.getRequestDispatcher("/shop.html").forward(request, response);
	}

}
