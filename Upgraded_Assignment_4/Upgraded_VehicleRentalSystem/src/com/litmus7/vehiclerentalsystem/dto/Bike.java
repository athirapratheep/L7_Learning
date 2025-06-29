package com.litmus7.vehiclerentalsystem.dto;

//import java.util.Scanner;

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

	public String toString() {
		return "Bike{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", rentalPricePerDay=" + getrentalPricePerDay() +
                ", hasGear="+ hasGear+
                ", engineCapacity="+engineCapacity+
                '}';
	}
}
