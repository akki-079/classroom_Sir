package demo_misc;

public class Main {
	
	{
		System.out.println("Hi from block of code");
	}

	public static void main(String[] args) {
		Main m= new Main();
		GenericsApp<Integer> app1=new GenericsApp<>();
		app1.setData(3, 4);
		
		System.out.println(app1.getData());
		
		GenericsApp<String> app2=new GenericsApp<>();
		app2.setData("John", "Doe");
		
		System.out.println(app2.getData());

	}

}
