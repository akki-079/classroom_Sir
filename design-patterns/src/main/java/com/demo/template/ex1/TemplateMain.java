package com.demo.template.ex1;

public class TemplateMain {

	public static void main(String[] args) {
		Game pubg = new PubG();
		Game mario = new Mario();

		pubg.play();
		mario.play();

		Game2 pubg2 = new PubG2();
		pubg2.play();

	}

}
