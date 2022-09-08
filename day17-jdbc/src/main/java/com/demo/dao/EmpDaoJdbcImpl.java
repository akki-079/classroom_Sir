package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.demo.entity.Emp;
import com.demo.exceptions.EmpExistsException;
import com.demo.exceptions.EmpNotFoundException;

public class EmpDaoJdbcImpl implements EmpDao {

	@Override
	public Emp findById(Integer id) throws EmpNotFoundException {
		Connection conn=null;
		try {
			conn = getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from employee where empno=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				Emp emp = new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
				return emp;
			} else {
				throw new EmpNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		} catch (EmpNotFoundException e) {
			throw e;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String save(Emp e) throws EmpExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Integer id) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Emp e) throws EmpNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection() throws SQLException {
		final String JDBC_URL = "jdbc:mariadb://localhost:3306/sapientdb";
		Connection conn = null;
		try {

			Class.forName("org.mariadb.jdbc.Driver");

			conn = DriverManager.getConnection(JDBC_URL, "root", "root");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new SQLException("Connection could not be created..");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}
}
