package com.demo.app;

public class MyCalculator {

	public int num1 = 30, num2 = 10;
	public double add = 0, sub = 0, mul = 0, divide = 0;

	public void calculate() {
		ICalculation obj = (num1, num2) -> num1 + num2;
		add = obj.doCalculation(num1, num2);

		obj = (num1, num2) -> num1 - num2;
		sub = obj.doCalculation(num1, num2);

		obj = (num1, num2) -> num1 * num2;
		mul = obj.doCalculation(num1, num2);

		obj = (num1, num2) -> num1 / num2;
		divide = obj.doCalculation(num1, num2);

	}
	
	
	
	
}
