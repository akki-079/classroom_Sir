package com.demo.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class ListDemoLegacy {

	public static void main(String[] args) {

		List<A> objectsList = new ArrayList();

		objectsList.add(new A());
		//objectsList.add(new B());
		//objectsList.add(new C());
		objectsList.add(new A());
		//objectsList.add(new B());
		//objectsList.add(new C());
		
		Iterator<A> itr=objectsList.iterator();
		
		while(itr.hasNext()) {
			A a=itr.next();
			/* A a=(A)o; */
		}
	}

}
