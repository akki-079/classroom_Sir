package com.demo.utils;

public class StringDemo {
	public static void main(String[] args) {
		
		String s1="hello";
		String s2="hi";
		String s3="hello";
		
		String s4=new String("hello");
		
		System.out.println("s1==s3 : "+(s1==s3));
		
		System.out.println("s1==s4 : "+(s1==s4));
		
		String s5="hello";
		
		System.out.println("s3==s5 : "+(s1==s3));
		
		String s6=new String("hello");
		
		System.out.println("s4==s6 : "+(s4==s6));
		
		//String(s) are immutable
		
		String s7="This is a good example";
		String s8=s7;
		
		s7="This is a better example";
		
		System.out.println(s7==s8);
	}
}
