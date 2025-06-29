package com.litmus7.vehiclerentalsystem.dto;

//import java.util.Scanner;

/**
 * Represents a car in the vehicle rental system. Inherits common attributes
 * from vehicle and adds car specific details.
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
	 * @param brand             the brand of the car
	 * @param model             the model of the car
	 * @param rentalPricePerDay the rental price per day
	 * @param numberOfDoors     the number of doors in the car
	 * @param isAutomatic       whether the car has automatic transmission
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}
	public String toString() {
		return "Car{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", rentalPricePerDay=" + getrentalPricePerDay() +
                ", Number of doors="+ numberOfDoors+
                ", isAutomatic="+isAutomatic+
                '}';
	}

	
}
