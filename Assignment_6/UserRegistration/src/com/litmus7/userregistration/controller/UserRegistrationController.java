package com.litmus7.userregistration.controller;

import java.util.Scanner;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.*;
import com.litmus7.userregistration.service.UserRegistrationService;

public class UserRegistrationController {
	private UserRegistrationService userService = new UserRegistrationService();

	public void startRegistration() {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Enter username: ");
			String username = scanner.nextLine();

			System.out.print("Enter age: ");
			int age = Integer.parseInt(scanner.nextLine());

			System.out.print("Enter email: ");
			String email = scanner.nextLine();

			System.out.print("Enter password: ");
			String password = scanner.nextLine();

			User user = new User(username, age, email, password);

			userService.registerUser(user);
			System.out.println("Registration successful! User Details: " + user);

		} catch (InvalidAgeException | InvalidEmailException | WeakPasswordException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error: Age must be a valid number.");
		} catch (DatabaseException e) {
			System.out.println("Database Error: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
