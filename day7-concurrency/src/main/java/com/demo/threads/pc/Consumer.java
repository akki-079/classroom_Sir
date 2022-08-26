package com.demo.threads.pc;

public class Consumer implements Runnable {

	private SharedQueue queue;

	public Consumer(SharedQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				queue.get();
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
