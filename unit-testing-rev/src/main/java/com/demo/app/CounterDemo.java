package com.demo.app;

public class CounterDemo {



	   private  int count =0;
	    
	    public CounterDemo() {
	        System.out.println("Counter Created...");
	    }
	    public void increment() {
	        count++;
	    }
	    
	    public void decrement() {
	        count--;
	    }
	    
	    public int getCount() {
	        return this.count;
	    }
	}