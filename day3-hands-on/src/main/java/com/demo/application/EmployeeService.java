package com.demo.application;

public class EmployeeService {

	private EmpDAO empDao = new EmpDAO();

	public String registerEmployee(int id, String name, double salary, String doorNo, String city, int pinCode) {

		Address address = new Address(doorNo, city, pinCode);

		Employee emp = new Employee(id, name, address, salary);
		String response = empDao.save(emp);
		return response;
	}

}