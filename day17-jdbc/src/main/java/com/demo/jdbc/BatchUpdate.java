package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdate {

	public static void main(String[] args) throws Exception {

		final String JDBC_URL = "jdbc:mariadb://localhost:3306/sapientdb";

		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");

		PreparedStatement pst = conn
				.prepareStatement("insert into employee(empno,name,address,salary) values (?,?,?,?)");

		// 1
		pst.setInt(1, 110);
		pst.setString(2, "Sukumar");
		pst.setString(3, "Kochi");
		pst.setDouble(4, 77000);
		pst.addBatch();

		// 2
		pst.setInt(1, 111);
		pst.setString(2, "Chetan");
		pst.setString(3, "Mumbai");
		pst.setDouble(4, 97000);
		pst.addBatch();

		// 3
		pst.setInt(1, 112);
		pst.setString(2, "Thor");
		pst.setString(3, "Newyork");
		pst.setDouble(4, 87000);
		pst.addBatch();

		// 4
		pst.setInt(1, 113);
		pst.setString(2, "Mohanlal");
		pst.setString(3, "Kochi");
		pst.setDouble(4, 97000);
		pst.addBatch();

		try {
			conn.setAutoCommit(false);
			int[] rows = pst.executeBatch();
			conn.commit();
			System.out.println("Committed: Rows Inserted = " + rows.length);
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("rolledback Tx");
			e.printStackTrace();
		}finally {
			conn.setAutoCommit(true);
			conn.close();
		}
		
	}

}
