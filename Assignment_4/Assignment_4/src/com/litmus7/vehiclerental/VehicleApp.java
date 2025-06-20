package com.litmus7.vehiclerental;

import com.litmus7.vehiclerental.dto.*;

/**
 * Main application class to test vehicle rental system. Demonstrates use of
 * inheritance, constructors, and method overriding. It creates and displays
 * both Car and Bike objects using default and parameterized constructors. This
 * serves as the driver class for the entire application.
 * 
 * @author athirapratheep
 * @since 2025
 */
public class VehicleApp {

	/**
	 * Creates and tests Car and Bike objects using both constructors.
	 */
	public static void main(String[] args) {
		// Test Car with parameterized constructor
		Car car1 = new Car("Honda", "Civic", 1400, 4, false);
		System.out.println("\n---Displaying Car Details(parameterized)---");
		car1.displayDetails();

		// Test Car with default constructor
		Car car2 = new Car();
		System.out.println("\n---Enter Car Details---");
		car2.inputDetails();
		System.out.println("\n---Displaying Car Details---");
		car2.displayDetails();

		// Test Bike with parameterized constructor
		Bike bike1 = new Bike("Suzuki", "Gixxer", 600, false, 125);
		System.out.println("\n---Displaying Bike Details(parameterized)---");
		bike1.displayDetails();

		// // Test Bike with default constructor and input
		Bike bike2 = new Bike();
		System.out.println("\n---Enter Bike Details---");
		bike2.inputDetails();
		System.out.println("\n---Displaying Bike Details---");
		bike2.displayDetails();
	}

}
