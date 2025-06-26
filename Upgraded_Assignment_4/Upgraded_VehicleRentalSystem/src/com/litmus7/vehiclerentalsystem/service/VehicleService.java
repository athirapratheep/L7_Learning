package com.litmus7.vehiclerentalsystem.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalsystem.dto.*;

/**
 * Service class that manages the list of vehicles.
 */
/**
 * 
 */
/**
 * 
 */
/**
 * 
 */
public class VehicleService {
	private List<Vehicle> vehicles = new ArrayList<>();

	/**
	 * Loads vehicle from a file
	 * 
	 * @param vehiclesFile the filename to load vehicles from Each line in the file
	 *                     represents a car or bike in CSV format.
	 */
	public List<Vehicle> loadVehicles(String vehiclesFile) {
		List<Vehicle> vehicles = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("vehicles.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts[0].equalsIgnoreCase("Car")) {
					vehicles.add(new Car(parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]),
							Boolean.parseBoolean(parts[5])));
				} else if (parts[0].equalsIgnoreCase("Bike")) {
					vehicles.add(new Bike(parts[1], parts[2], Double.parseDouble(parts[3]),
							Boolean.parseBoolean(parts[4]), Integer.parseInt(parts[5])));
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading the file.");
		}
		return vehicles;
	}

	/**
	 * @param v the vehicle to add Adds a vehicle manually to the list.
	 */
	public void addVehicle(Vehicle v) {
		vehicles.add(v);
	}

	/**
	 * @param searchword the brand or model to search Searches and displays vehicles
	 *                   matching a given model or brand
	 */
	public void searchByBrandOrModel(List<Vehicle> vehicleList, String searchword) {
		boolean found = false;
		for (Vehicle v : vehicleList) {
			if (v.getBrand().equalsIgnoreCase(searchword) || v.getModel().equalsIgnoreCase(searchword)) {
				v.displayDetails();
				found = true;
			}
		}
		if (found==false) {
			System.out.println("No vehicle found.");
		}
	}

	/**
	 * Calculates the total rental price of all vehicles per day
	 * 
	 * @return total rental cost per day
	 */
	public double totalRentalPrice(List<Vehicle> vehicleList) {
		double total = 0;
		for (Vehicle v : vehicleList) {
			total += v.getrentalPricePerDay();
		}
		return total;
	}
}
