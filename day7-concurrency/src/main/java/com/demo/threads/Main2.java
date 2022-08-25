package com.demo.threads;

public class Main2 {

	public static void main(String[] args) throws InterruptedException{
		Thread t1 = new Thread(new MyRunnableWorker());
		
		Thread t2 = new Thread(new MyRunnableWorker());
		
		t1.start();
		t2.start();
		
		
		t1.join();
		t2.join();

	}

}
