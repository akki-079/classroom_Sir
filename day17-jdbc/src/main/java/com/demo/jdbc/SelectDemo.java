package com.demo.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args)  throws Exception{
		
		final String JDBC_URL="jdbc:mariadb://localhost:3306/sapientdb";
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection(JDBC_URL, "root", "root");
		
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from employee");
		
		while(rs.next()) {
			int id=rs.getInt("EMPNO");
			String name=rs.getString("NAME");
			String city=rs.getString("ADDRESS");
			double salary=rs.getDouble("SALARY");
			System.out.println(id+" "+name+" "+city+" "+salary);
		}
		

		
	}

}
