package com.demo.singleton.ex1;

public class SingletonMain {

	public static void main(String[] args) {
		MySingleTon s1=MySingleTon.instance();
		MySingleTon s2=MySingleTon.instance();
		MySingleTon s3=MySingleTon.instance();
		
		System.out.println(s1==s3);
		
		
		
		
	}

}
