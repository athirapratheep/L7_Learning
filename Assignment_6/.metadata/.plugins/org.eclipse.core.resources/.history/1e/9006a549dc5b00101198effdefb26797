package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dao.UserDAO;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.*;

public class UserService {
	private UserDAO userDao = new UserDAO();

	public void registerUser(User user)
			throws InvalidAgeException, InvalidEmailException, WeakPasswordException, DatabaseException {
		validateUser(user);
		userDao.SaveUser(user);
	}

	private void validateUser(User user) throws InvalidAgeException, InvalidEmailException, WeakPasswordException {
		if (user.getUsername() == null || user.getUsername().isEmpty()) {
			throw new IllegalArgumentException("Username cant be empty");
		}
		if (user.getAge() < 18 || user.getAge() > 60) {
			throw new InvalidAgeException("Age must be between 18 and 60");
		}
		if (user.getEmail() == null || !user.getEmail().contains("@") || !user.getEmail().contains(".")) {
			throw new InvalidEmailException("Invalid email format. Must contain '@' and '.' ");
		}
		if (user.getPassword() == null || user.getPassword().length() < 6) {
			throw new WeakPasswordException("Password too weak. Must be atleast 6 characters.");
		}
	}
}
