package com.demo.application;

public class EmpDAO {

	public String save(Employee emp) {
		System.out.println("Emp with saved with id " + emp.getEmpId());
		return "Emp saved";
	}
}
