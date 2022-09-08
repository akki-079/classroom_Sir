package com.demo.query.hql;

public class Data {
	private Integer empId;

	private String name;

	private String city;

	private Double salary;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Data(Integer empId, String name) {
		this.empId = empId;
		this.name = name;
	}

	public Data(Integer empId, String name, String city) {
		this.empId = empId;
		this.name = name;
		this.city = city;
	}

	public Data(Integer empId, String name, String city, Double salary) {
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

	public Data(Integer empId, String name, Double salary) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}
	
	
}
