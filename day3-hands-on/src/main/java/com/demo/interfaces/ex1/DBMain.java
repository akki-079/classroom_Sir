package com.demo.interfaces.ex1;

public class DBMain {

	public static void main(String[] args) {
		MyConnection db=new PostGresDB();
		
		System.out.println(db.getConnectionInfo());
		System.out.println(db.getDBDetails());
		

	}

}
