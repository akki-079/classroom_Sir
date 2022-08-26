package com.demo.threads.pc;

public class Main {

	public static void main(String[] args) {
		SharedQueue queue= new SharedQueue();
		Thread t1 = new Thread(new Consumer(queue));
		Thread t3 = new Thread(new Consumer(queue));
		Thread t2 = new Thread(new Producer(queue));
		
		t1.start();
		t2.start();
		t3.start();

	}

}
