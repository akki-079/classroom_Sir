package com.demo.interfaces.ex1;

public class MySqlDB implements MyConnection{

	@Override
	public String getConnectionInfo() {
		
		return "MySql DB Conneccted..";
	}

	@Override
	public String getDBDetails() {
		
		return "MySql version 8.0.1";
	}

}
