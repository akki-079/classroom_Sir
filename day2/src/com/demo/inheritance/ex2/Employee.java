package com.demo.inheritance.ex2;

public class Employee extends Person {
	
	private double salary;
	
	public Employee(int id, String name,String location,double salary) {
		super(id,name,location);
		this.salary=salary;
	}

	
	@Override
	  public String getDetails() {
	  
	  return super.getDetails()+" "+salary; }
	 
	public int getChildren() {
		return 5;
	}
}
