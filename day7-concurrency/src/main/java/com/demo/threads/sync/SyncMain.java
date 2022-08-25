package com.demo.threads.sync;

public class SyncMain {

	public static void main(String[] args) throws InterruptedException{
		TableGenerator tableGenerator=new TableGenerator();
		
		Thread t1=new Thread(new TableWorker(tableGenerator, 6));
		
		Thread t2=new Thread(new TableWorker(tableGenerator, 8));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}
