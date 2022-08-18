package com.demo.ex2;

public class Duck {

	private static int count = 0;
	private String name;

	public Duck(String name) {
		this.name = name;
		count++;
	}

	public static int getCount() {
		return count;
	}

	public String getDuckName() {
		return this.name;
	}
	
	static {
		System.out.println("Static block exeutes...");
	}
	
}
