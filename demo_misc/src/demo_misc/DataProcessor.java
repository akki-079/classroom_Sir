package demo_misc;

import java.util.List;

public class DataProcessor extends Thread {

	private List<Data> dataList;
	private int start;

	public DataProcessor(List<Data> dataList, int start) {
		this.dataList = dataList;
		this.start = start;
	}

	@Override
	public void run() {
		for (int i = start; i < start + 5; i++) {
			Data d = dataList.get(i);
			int num=d.getNumber();
			d.setSquare(square(num));
			
		}
	}

	int square(int i) {
		return i * i;
	}
}
