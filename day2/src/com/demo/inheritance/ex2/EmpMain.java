package com.demo.inheritance.ex2;

public class EmpMain {

	public static void main(String[] args) {
		
		Person raja = new Person(1, "Raja", "Chennai");
		Employee peter = new Employee(2, "Peter", "Hyderabad", 56000);
		TraineeEmp john = new TraineeEmp(3, "John", "Bangalore", 89000, "Good");
		
		System.out.println(raja.getDetails());
		//System.out.println(peter.getDetails());
		//System.out.println(john.getDetails());
		
		//superclass type as a reference to the subclass object
		
		Person p=peter;
		System.out.println(p.getDetails());
		
		p=john;
		System.out.println(p.getDetails());
		
		
		
		Person p1= new Employee(2, "Peter", "Hyderabad", 56000);
		
		//Employee e=(Employee)new Person(1, "Raja", "Chennai");;
		
		System.out.println(raja);
		

	}

}
