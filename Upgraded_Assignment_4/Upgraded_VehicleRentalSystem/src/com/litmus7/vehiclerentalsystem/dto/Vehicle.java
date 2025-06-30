package com.litmus7.vehiclerentalsystem.dto;

//import java.util.Scanner;

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
	 * @return brand getter for brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @return model getter for model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return rentaPricePerDay getter for rentalPricePerDay
	 */
	public double getrentalPricePerDay() {
		return rentalPricePerDay;
	}

	/**
	 * displaying the objects
	 */
	public String toString() {
		return "Vehicle{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", rentalPricePerDay="
				+ rentalPricePerDay + '}';
	}
}
