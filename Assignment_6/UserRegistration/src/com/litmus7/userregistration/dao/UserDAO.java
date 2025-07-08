package com.litmus7.userregistration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.DatabaseException;

public class UserDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/UserReg";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public void saveUser(User user) throws DatabaseException {
		String sql = "INSERT INTO users (username, age, email, password) VALUES (?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, user.getUsername());
			pstmt.setInt(2, user.getAge());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException("Error saving user to database", e);
		}
	}
}
