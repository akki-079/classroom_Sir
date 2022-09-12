package com.demo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Map<Integer, Emp> db=new ConcurrentHashMap<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opration=request.getParameter("operation");
		switch (opration) {
		case "register":
			String id=request.getParameter("empId");
			Integer empId=Integer.parseInt(id);
			String name=request.getParameter("name");
			String city=request.getParameter("city");
			String salary=request.getParameter("salary");
			Double sal=Double.parseDouble(salary);
			db.put(empId, new Emp(empId, name, city, sal));
			System.out.println(db);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		case "list":
			Collection<Emp> data=db.values();
			List<Emp> empList=new ArrayList<>(data);
			request.getSession().setAttribute("eList", empList);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
			break;
		case "find":
			String id1=request.getParameter("empId");
			Integer empId1=Integer.parseInt(id1);
			Emp emp=db.get(empId1);
			request.getSession().setAttribute("e", emp);
			request.getRequestDispatcher("/finder.jsp").forward(request, response);
			break;
		default:
			break;
		}
		
	}

}
