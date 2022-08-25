package com.demo.threads.sync;

public class TableGenerator {

	public synchronized void genTable(int x) {
		try {
		for(int i=1;i<11;i++) {
			System.out.println(x+" x "+i+" = "+(x*i));
			Thread.sleep(1000);
		}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
