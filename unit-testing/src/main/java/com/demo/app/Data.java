package com.demo.app;

public class Data {
	private int number;
	private int square;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSquare() {
		return square;
	}

	public void setSquare(int square) {
		this.square = square;
	}

	@Override
	public String toString() {
		return "["+number+","+square+"]";
	}
}
