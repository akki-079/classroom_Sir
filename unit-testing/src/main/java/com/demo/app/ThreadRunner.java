package com.demo.app;

import java.util.List;
import java.util.Vector;

public class ThreadRunner {
	private List<Data> dataList = new Vector<>();

	public void runThread() throws Exception {
	
		for (int i = 1; i < 11; i++) {
			Data d = new Data();
			d.setNumber(i);
			dataList.add(d);
		}

		DataProcessor p1 = new DataProcessor(dataList, 0);
		DataProcessor p2 = new DataProcessor(dataList, 5);

		p1.start();
		p2.start();

		p1.join();
		p2.join();

		System.out.println(dataList);

	}

	public List<Data> getData() {
		return dataList;
	}

}
