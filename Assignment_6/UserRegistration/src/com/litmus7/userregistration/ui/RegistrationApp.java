package com.litmus7.userregistration.ui;

import com.litmus7.userregistration.controller.UserRegistrationController;

public class RegistrationApp {

	public static void main(String[] args) {
		UserRegistrationController controller = new UserRegistrationController();
		controller.startRegistration();
	}

}
