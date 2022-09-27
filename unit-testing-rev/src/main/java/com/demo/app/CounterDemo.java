package com.demo.app;

public class CounterDemo {
	private int count = 0;

	public CounterDemo(){
		System.out.println("COunter created..");
	}
	public void increment() {
		count++;
	}

	public void decrement() {
		count=count-1;
	}

	public int getCount() {
		return this.count;
	}
}
