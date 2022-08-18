package com.demo.inheritance;

public class Student extends Person {
	
	private String grade;
	
	public Student(int id, String name,String location,String grade) {
		super(id,name,location);
		this.grade=grade;
	}

	
	@Override
	  public String getDetails() {
	  
	  return super.getDetails()+" "+grade; }
	 
	
}
