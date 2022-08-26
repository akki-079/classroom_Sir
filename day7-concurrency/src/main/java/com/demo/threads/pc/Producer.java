package com.demo.threads.pc;

public class Producer implements Runnable {

	private SharedQueue queue;
	private int count = 0;

	public Producer(SharedQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				queue.put(count);
				Thread.sleep(100);
				count++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
