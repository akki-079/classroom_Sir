package com.demo.threads;

public class Main1 {

	public static void main(String[] args) throws InterruptedException{
		String name=Thread.currentThread().getName();
		System.out.println(" thread "+name+" started");
		
		System.out.println(Thread.currentThread());
		
		MyThread t1=new MyThread();
		t1.setName("John");
		t1.start();
		
		MyThread t2=new MyThread();
		t2.setName("Peter");
		t2.start();
		
		t1.join();
		t2.join();
		//t1.start();
		
		System.out.println(" thread "+name+" ended..");
		
		//Thread Priority 1-10 1 min, 5 normal 10 max

	}

}
