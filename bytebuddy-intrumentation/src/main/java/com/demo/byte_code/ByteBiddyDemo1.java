package com.demo.byte_code;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class ByteBiddyDemo1 {

	public void testByteBuddy() throws Exception {
		/*
		 * class HelloType extends Object{
		 * public String toString(){
		 * return "Hello From HelloType";
		 * }
		 * }
		 */
		Class<?> dynamicType = new ByteBuddy()
				.subclass(Object.class)
				.name("HelloType")
				.method(ElementMatchers.named("toString"))
				.intercept(FixedValue.value("Hello From HelloType"))
				.make()
				.load(getClass().getClassLoader())
				.getLoaded();

		System.out.println(dynamicType.newInstance().toString());

	}

	public static void main(String[] args) throws Exception{

		ByteBiddyDemo1 buddy1 = new ByteBiddyDemo1();
		buddy1.testByteBuddy();
	}
}
