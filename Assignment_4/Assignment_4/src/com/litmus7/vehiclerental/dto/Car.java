package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

/**
 * Represents a car in the vehicle rental system.
 * Inherits common attributes from vehicle and adds car specific details.
 */
public class Car extends Vehicle {
	private int numberOfDoors;
	private boolean isAutomatic;

	/**
	 * Default constructor to initialize default car details.
	 */
	public Car() {
		super();
		numberOfDoors = 4;
		isAutomatic = false;
	}

	/**
	 * @param brand the brand of the car
	 * @param model the model of the car
	 * @param rentalPricePerDay the rental price per day
	 * @param numberOfDoors the number of doors in the car
	 * @param isAutomatic whether the car has automatic transmission
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Accepts car specific details from the user in addition to vehicle details.
	 */
	public void inputDetails() {
		super.inputDetails();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of doors: ");
		numberOfDoors = scanner.nextInt();
		System.out.println("Is it automatic (true/false)? ");
		isAutomatic = scanner.nextBoolean();
	}

	/**
	 * Displays car specific details along with vehicle details.
	 */
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Number of Doors: " + numberOfDoors);
		System.out.println("Automatic: " + isAutomatic);
	}
	
}
