package com.demo.threads;

public class BlockingNonBlocking {

	public static String greet() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello there";
	}

	public static void main(String[] args) {

		new Thread(new Runnable() {

			public void run() {
				greet();

			}
		}).start();

		System.out.println("Request completed....");
	}

}
