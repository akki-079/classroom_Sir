package com.demo.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args)  throws Exception{
		
		final String JDBC_URL="jdbc:mariadb://localhost:3306/sapientdb";
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection(JDBC_URL, "root", "root");
		
		PreparedStatement pst=
				conn.prepareStatement("insert into employee(empno,name,address,salary) values (?,?,?,?)");
		
		pst.setInt(1, 105);
		pst.setString(2, "Babita");
		pst.setString(3, "Noida");
		pst.setDouble(4, 87000);
		
		int row=pst.executeUpdate();
		
		System.out.println("Rows Inserted = "+row);

		
	}

}
