package com.demo.interfaces.ex1;

public class OracleDB implements MyConnection{

	@Override
	public String getConnectionInfo() {
		
		return "Oracle DB Conneccted..";
	}

	@Override
	public String getDBDetails() {
		
		return "Oracle DB 11g";
	}

}
