package com.demo.inner;

public class InnerClassDemo2 {

	public static void main(String[] args) {

		Greeter g = new GoodMorning();
		System.out.println(g.getGreet());

		Greeter g1 = new Greeter() {
			public String getGreet() {

				return "Good Night";
			}
		};

	}

}

class GoodMorning implements Greeter {

	public String getGreet() {
		return "Good Morning";
	}

}