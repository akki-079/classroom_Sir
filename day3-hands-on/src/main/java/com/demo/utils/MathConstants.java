package com.demo.utils;

public enum MathConstants {
PI(3.1416),
e(2.718);

private final double value;

 MathConstants(double value) {
	 System.out.println(""+value);
	this.value = value;
}
	private double value() {
		return value;
	};
	
	public double getPiValue() {
		return PI.value();
	}
}
