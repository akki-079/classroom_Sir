package com.demo.ex1;

public class Box {
	private int length;
	private int breadth;
	private int height;
	private String color="colour less";

	public Box(int length, int breadth, int height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	
	public Box(int length, int breadth, int height,String color) {
		this(length,breadth,height);
		this.color=color;
	}

	public double getVolume() {

		double vol = length * breadth * height;
		return vol;
	}

	public String getColor() {
		return color;
	}
	
	
}
