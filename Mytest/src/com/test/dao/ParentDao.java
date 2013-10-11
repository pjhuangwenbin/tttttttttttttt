package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParentDao {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	
	Connection conn = null;
	PreparedStatement state = null;
	ResultSet rs = null;

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("can not load driver");
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(
					URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("can not get connection");
		}
	}

	public ResultSet exeQuery(String sql, String[] args) {
		try {
			getConnection();
			state = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					state.setString(i + 1, args[i]);
				}
			}
			rs = state.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int exeUpdate(String sql, String[] args) {
		int flag = 0;
		try {
			getConnection();
			state = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					state.setString(i + 1, args[i]);
				}
			}
			flag = state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return flag;

	}

	public void closeAll() {
		try {
			if (rs != null)
				rs.close();
			if (state != null)
				state.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("close error");
		}

	}

}
