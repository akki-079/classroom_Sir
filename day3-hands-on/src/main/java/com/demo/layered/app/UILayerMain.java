package com.demo.layered.app;

public class UILayerMain {

	public static void main(String[] args) {
		ServiceLayer service=new ServiceLayer();
		String result=service.compose("Assessment", "Assessment starts at 4:00pm");
		System.out.println(result);

	}

}
