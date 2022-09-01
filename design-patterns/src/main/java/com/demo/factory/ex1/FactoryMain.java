package com.demo.factory.ex1;

public class FactoryMain {

	public static void main(String[] args) {
		Cycle c= CycleFactory.createCycle("bi");
		
		System.out.println(c.getCycleDetails());

	}

}
