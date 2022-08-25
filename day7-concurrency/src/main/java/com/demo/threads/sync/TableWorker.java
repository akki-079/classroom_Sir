package com.demo.threads.sync;

public class TableWorker implements Runnable {

	private TableGenerator tableGenerator;
	int x;

	public TableWorker(TableGenerator tableGenerator, int x) {
		this.tableGenerator = tableGenerator;
		this.x = x;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());
		tableGenerator.genTable(x);

	}

}
