package com.demo.ex2;

public class DuckMain {

	public static void main(String[] args) {
		Duck d1 = new Duck("mini");
		Duck d2 = new Duck("tiny");
		Duck d3 = new Duck("rony");
		Duck d5 = new Duck("tanny");
		Duck d4 = new Duck("genie");

		System.out.println("Total ducks : " + Duck.getCount());
		
		//Duck.getDuckName();
		
		d1.getDuckName();

	}

}
