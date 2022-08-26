package com.demo.threads.pc;

public class SharedQueue {

	private int data;
	private boolean valueSet = false;

	public synchronized void put(int data) {
		if (valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		this.data = data;
		valueSet = true;
		System.out.println(Thread.currentThread().getName() + " put:" + data);
		notifyAll();
	}

	public synchronized void get() {
		if (!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " Got:" + data);
		valueSet = false;
		
		notifyAll();
	}
}
