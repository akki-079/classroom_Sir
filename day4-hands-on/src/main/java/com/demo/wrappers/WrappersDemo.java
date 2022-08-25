package com.demo.wrappers;

public class WrappersDemo {

	public static void main(String[] args) {
		
		String data="25";
		
		int num=Integer.parseInt(data);
		System.out.println(num);
		
		
		int x=20;
		
		
		Integer xObj=new Integer(x); //till java 1.4
		
		Integer yObj=x; //java 5 onwards Auto boxing
		
		
		int y=yObj;
		
		Double d = 20.7;

	}

}
