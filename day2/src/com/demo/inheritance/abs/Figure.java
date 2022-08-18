package com.demo.inheritance.abs;

public abstract class Figure {

	protected int dimension1;
	protected int dimension2;

	public Figure(int dimension1, int dimension2) {
		this.dimension1 = dimension1;
		this.dimension2 = dimension2;
	}
	
	public abstract double area();

}
