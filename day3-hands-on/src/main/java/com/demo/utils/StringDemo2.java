package com.demo.utils;

public class StringDemo2 {

	public static void main(String[] args) {
		String sample="this is a basic java class as we are advised to learn java in our class";
		
		System.out.println(sample.indexOf("java"));
		
		String words[]=sample.split(" ");
		System.out.println(words.length);
		
		System.out.println(sample.substring(sample.indexOf("java")+4, sample.lastIndexOf("java")));

	}

}
