<<<<<<< HEAD
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
=======
package com.demo.app;

public class CounterDemo {
	private int count = 0;

	public CounterDemo(){
		System.out.println("COunter created..");
	}
	public void increment() {
		count++;
	}

	public void decrement() {
		count=count-1;
	}

	public int getCount() {
		return this.count;
	}
}
>>>>>>> 45987a59c53394b74bc91bb9c1a6a67fef44b04c
