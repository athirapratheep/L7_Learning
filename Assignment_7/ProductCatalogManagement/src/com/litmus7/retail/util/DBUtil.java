package com.litmus7.retail.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DBUtil {
	private static String url;
	private static String username;
	private static String password;
	private static String driverClassName;

	static {
		try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
			Properties props = new Properties();
			props.load(input);

			url = props.getProperty("jdbc.url");
			username = props.getProperty("jdbc.username");
			password = props.getProperty("jdbc.password");
			driverClassName = props.getProperty("jdbc.driverClassName");

		//	Class.forName(driverClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}