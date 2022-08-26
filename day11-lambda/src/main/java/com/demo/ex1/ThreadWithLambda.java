package com.demo.ex1;

public class ThreadWithLambda {

	public static void main(String[] args) {
		Thread t1 = new Thread(()->System.out.println("Hello"));

	}

}
