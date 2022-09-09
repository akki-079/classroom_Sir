package com.demo.app;

import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReadBundle {

	public static void main(String[] args) throws Exception{
		ResourceBundle bundle= ResourceBundle.getBundle("app");
		
		String name=bundle.getString("name");
		String city=bundle.getString("city");
		String age=bundle.getString("age");
		
		System.out.println(name+" "+age+" "+city);
		
		
		InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("app.properties");
		Properties props= new Properties();
		props.load(is);
		
		System.out.println(props);

	}

}
