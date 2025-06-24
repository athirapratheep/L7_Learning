package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

/**
 * Class representing a generic vehicle
 */
public class Vehicle {
	private String brand;
	private String model;
	private double rentalPricePerDay;

	/**
	 * Default constructor that initializes vehicle with default values.
	 */
	public Vehicle() {
		brand = "Unknown";
		model = "Unknown";
		rentalPricePerDay = 0.0;
	}

	/**
	 * @param brand             the brand of the vehicle
	 * @param model             the model of the vehicle
	 * @param rentalPricePerDay the rental price per day
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Prompts user to input details for the vehicle using scanner The inputs
	 * include brand,model and rental price per day
	 */
	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter brand: ");
		brand = scanner.nextLine();
		System.out.println("Enter model: ");
		model = scanner.nextLine();
		System.out.println("Enter rental price per day: ");
		rentalPricePerDay = scanner.nextDouble();
		scanner.nextLine();

	}

	/**
	 * Displays the details of the vehicle.
	 */
	public void displayDetails() {
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Rental Price/Day: " + rentalPricePerDay);

	}

	/**
	 * @return brand 	getter for brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @return model 	getter for model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return rentaPricePerDay 	getter for rentalPricePerDay
	 */
	public double getrentalPricePerDay() {
		return rentalPricePerDay;
	}
}
