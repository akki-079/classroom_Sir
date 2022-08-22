package com.demo.exceptions;

public class ExceptionDemo3 {

	public static void main(String[] args) {
		try {
			int a = 30;
			int b = 10;
			double d = a / b;

			int[] nums = new int[5];
			System.out.println(nums[4]);

			String[] names = new String[4];
			System.out.println(names[3].length());

			System.out.println("No Exceptions");

		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("The program resumed normal flow...");

	}

}
