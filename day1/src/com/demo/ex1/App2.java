package com.demo.ex1;

import com.demo.Overload;

public class App2 {

	public static void main(String[] args) {
		//System.out.println("Elements in Args Array : "+args.length);
		
		Overload o= new Overload();
		
		o.add();
		o.add(2, 3);
		o.add(2, 3.0f);
		o.add(2, 3.0);
		o.add(2.0, 3.0);

	}

}
