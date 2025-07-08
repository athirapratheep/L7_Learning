package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dao.UserDAO;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.DatabaseException;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.WeakPasswordException;

public class UserRegistrationService {
	private UserDAO userDAO = new UserDAO();

	public void registerUser(User user)
			throws InvalidAgeException, InvalidEmailException, WeakPasswordException, DatabaseException {
		validateUser(user);
		userDAO.saveUser(user);
	}

	private void validateUser(User user) throws InvalidAgeException, InvalidEmailException, WeakPasswordException {
		if (user.getUsername() == null || user.getUsername().isEmpty()) {
			throw new IllegalArgumentException("Username cannot be empty");
		}

		if (user.getAge() < 18 || user.getAge() > 60) {
			throw new InvalidAgeException("Age must be between 18 and 60.");
		}

		String email = user.getEmail();
		if (email == null || !email.contains("@") || !email.contains(".")) {
			throw new InvalidEmailException("Invalid email format. Must contain '@' and '.'.");
		}

		if (user.getPassword() == null || user.getPassword().length() < 6) {
			throw new WeakPasswordException("Password too weak. Must be at least 6 characters.");
		}
	}
}
