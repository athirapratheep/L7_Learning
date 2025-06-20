package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

/**
 * The vehicle class serves as a super class representing a generic vehicle. It
 * contains basic attributes such as brand,model, and rental price per day.
 * 
 * @author athirapratheep
 * @since 2025
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
	 * @param brand the brand of the vehicle
	 * @param model the model of the vehicle
	 * @param rentalPricePerDay the rental price per day
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Prompts user to input details for the vehicle using scanner
	 * The inputs include brand,model and rental price per day
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
		System.out.println("Rental Proce/Day: " + rentalPricePerDay);

	}
}
