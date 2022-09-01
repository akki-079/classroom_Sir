package p2;

import java.util.List;
import java.util.Vector;

public class ChangeToSquare {
	public static void main(String[] args) throws Exception {
		List<Integer> numList = new Vector<>();
		for (int x = 0; x < 10; x++) {
			numList.add(x + 2);
		}
		
		System.out.println("before : "+numList);
		SquareThread st=new SquareThread(numList);
		st.start();
		st.join();
		System.out.println("After : "+numList);

	}
}

class SquareThread extends Thread{
	private List<Integer> numList;
	
	public SquareThread(List<Integer> numList) {
		this.numList=numList;
	}
	
	@Override
	public void run() {
		for(int i=0;i<numList.size();i++) {
			System.out.println(numList.size());
			int num=numList.get(i);
			System.out.println(num);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			numList.set(i, num*num);
		}
	}
}