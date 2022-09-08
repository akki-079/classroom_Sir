package com.demo.maths;

public class Counter {

	private int count = 0;

	public void increment() {
		count++;
	}

	public void decrement() {

		count=count-1;
	}

	public int getCounter() {
		return count;
	}
}
