package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	public static Connection getDBConnection() throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "Shivam2001@");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
