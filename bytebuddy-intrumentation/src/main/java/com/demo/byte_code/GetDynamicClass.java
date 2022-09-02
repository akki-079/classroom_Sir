package com.demo.byte_code;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class GetDynamicClass {

	public String createMethod() throws IllegalAccessException,InstantiationException{
		Class<?> dynamicType=new ByteBuddy()
								.subclass(Object.class)
								.name("MyDynamicType")
								.method(ElementMatchers.named("toString"))
								.intercept(FixedValue.value("Hello there"))
								.make()
								.load(getClass().getClassLoader())
								.getLoaded();
		
		return dynamicType.newInstance().toString();
	}
}
