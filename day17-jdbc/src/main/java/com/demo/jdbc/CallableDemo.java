package com.demo.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CallableDemo {

	public static void main(String[] args)  throws Exception{
		
		final String JDBC_URL="jdbc:mariadb://localhost:3306/sapientdb";
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection(JDBC_URL, "root", "root");
		
		CallableStatement cst=conn.prepareCall("{call addBonus(?,?)}");
		
		cst.setInt(1, 102);
		cst.setDouble(2, 6000);
		
		cst.execute();

		
	}

}
