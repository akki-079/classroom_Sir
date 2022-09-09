package com.demo.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class NameFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Request received from " + request.getRemoteHost());
		String name = request.getParameter("username");
		if (name.equalsIgnoreCase("pavan")) {
			chain.doFilter(request, response);
		} else {
			response.getWriter().write("You are not allowed here..");
		}

	}

}
