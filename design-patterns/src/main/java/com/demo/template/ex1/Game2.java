package com.demo.template.ex1;

public interface Game2 {

	public abstract void initGame();

	public abstract void start();

	public abstract void end();

	default public void play() {
		initGame();
		start();
		end();
	}
}

class Mario2 implements Game2{

	@Override
	public void initGame() {
		System.out.println("Mario is Loading....");
		
	}

	@Override
	public void start() {
		System.out.println("Mario is Started....");
		
	}

	@Override
	public void end() {
		System.out.println("Thank you: Mario is ending....");
		
	}
	
}


class PubG2 implements Game2{
	@Override
	public void initGame() {
		System.out.println("PubG is Loading....");
		
	}

	@Override
	public void start() {
		System.out.println("PubG is Started....");
		
	}

	@Override
	public void end() {
		System.out.println("Thank you: PubG is ending....");
		
	}
}
