package com.demo.ex1;

/**
 * 
 * @author Shantanu Banerjee
 * This is a demonstration for static methods and private
 * constructor
 *
 */
public class Maths {
	/**
	 * COnstruction of the object is restricted
	 */
	private Maths() {
		
	}
	
	/**
	 * 
	 * @param input 1 for the method
	 * @param b input 2 for the method
	 * @return (a+b)
	 */
	public static int add(int a, int b) {
		return a + b;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int multiply(int a, int b) {
		return a * b;
	}
	
	
}
