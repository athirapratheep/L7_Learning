package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

public class Bike extends Vehicle {
	/**
	 * Represents a bike in the vehicle rental system. Inherits common attributes
	 * from vehicle and adds bike specific details.
	 */
	private boolean hasGear;
	private int engineCapacity;

	/**
	 * Default constructor to initialize default car details.
	 */
	public Bike() {
		super();
		hasGear = true;
		engineCapacity = 100;
	}

	/**
	 * @param brand             the brand of the bike
	 * @param model             the model of the bike
	 * @param rentalPricePerDay the rental price per day
	 * @param hasGear           whether the bike has gears
	 * @param engineCapacity    the engine capacity in cc
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Accepts bike specific details from the user in addition to vehicle details.
	 */
	public void inputDetails() {
		super.inputDetails();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Does it have gears(true/false)? ");
		hasGear = scanner.nextBoolean();
		System.out.println("Enter engine capacity: ");
		engineCapacity = scanner.nextInt();

	}

	/**
	 * Displays bike specific details along with vehicle details.
	 */
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Has Gear: " + hasGear);
		System.out.println("Engine Capacity (cc): " + engineCapacity + "cc");
	}
}
