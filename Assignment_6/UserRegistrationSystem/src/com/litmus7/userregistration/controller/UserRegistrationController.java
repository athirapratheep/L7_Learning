package com.litmus7.userregistration.controller;

import java.util.Scanner;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.service.UserRegistrationService;
import com.litmus7.userregistration.exception.*;

public class UserRegistrationController {
	private UserRegistrationService userRegistrationService = new UserRegistrationService();

	public void startRegistration() {
		Scanner scanner=new Scanner(System.in);
		try {
			System.out.println("Enter Username: ");
			String username=scanner.nextLine();
			System.out.println("Enter Age: ");
			int age=Integer.parseInt(scanner.nextLine());
			System.out.println("Enter Email: ");
			String email=scanner.nextLine();
			System.out.println("Enter Password: ");
			String password=scanner.nextLine();
			User user=new User(username,age,email,password);
			userRegistrationService.registerUser(user);
			System.out.println("Registration successful! \nUser Details: "+user);
			
		}catch(InvalidAgeException | InvalidEmailException | WeakPasswordException | DatabaseException e) {
			System.out.println("Error: "+ e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("Age should be a valid number.");
		}catch(IllegalArgumentException e) {
			System.out.println("Error: "+e.getMessage());
		}finally {
			
			scanner.close();
		}
	}
}
