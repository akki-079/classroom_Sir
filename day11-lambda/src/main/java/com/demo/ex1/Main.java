package com.demo.ex1;

public class Main {

	public static void main(String[] args) {
		
		Greeter goodEvening=new Greeter() {
			@Override
			public String getGreet(String name) {
				
				return "Good Evening to "+name;
			}
		};
		
		
		Greeter goodNight=(name)->"Good Night to "+name;

	}

}

class GoodMorning implements Greeter{
	@Override
	public String getGreet(String name) {
		
		return "Good Morning to "+name;
	}
}