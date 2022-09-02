package demo_misc;

public class CalMain {

	public static void main(String[] args) {
		ICalculation cal1=(a,b)->a+b;
		
		double result1=cal1.doOperation(4, 5);
		System.out.println(result1);
		
		

	}

}
