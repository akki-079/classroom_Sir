package com.demo.inner;

public class Outer {

	
	class Inner1{
		
	}
	
	static class Inner2{
		
	}
	
	
	public static void main(String[] args) {
		
		Inner2 i2= new Inner2();
		
		Outer outer=new Outer();
		
		Inner1 i1=outer.new Inner1();
		
	}
}
