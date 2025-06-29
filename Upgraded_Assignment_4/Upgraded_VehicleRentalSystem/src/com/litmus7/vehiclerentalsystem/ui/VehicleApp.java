package com.litmus7.vehiclerentalsystem.ui;

import com.litmus7.vehiclerentalsystem.controller.VehicleController;
import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

import java.security.Provider.Service;
import java.util.List;
import java.util.Scanner;

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
	 * @param args main method reads input from a file and adds a new vehicle to the
	 *             system
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VehicleController controller = new VehicleController();
		Response response = controller.dataFromFile("vehicles.txt");

		if (response.getStatusCode() == 200) {
			System.out.println("Loaded vehicles:");
			printVehicles(response.getVehicles());
		} else {
			System.out.println("Error: " + response.getErrorMessage());
			return;
		}

		Vehicle newBike = new Bike("Hero", "Splendor", 25, true, 110);
		Response addResponse = controller.addVehicle(newBike);
		System.out.println("\n Add vehicle status: " + addResponse.getErrorMessage());
		if (addResponse.getStatusCode() == 200) {
			System.out.println("Updated Vehicles:");
			printVehicles(addResponse.getVehicles());
		}
	}

	private static void printVehicles(List<Vehicle> vehicles) {
		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
	}
}

//SAMPLE OUTPUT: 
//Loaded Vehicles: 
//
//After adding New Vehicle: 
//Brand: Toyota
//Model: Corolla
//Rental Price/Day: 45.5
//Number of Doors: 4
//Automatic: true
//
//Brand: Yamaha
//Model: R15
//Rental Price/Day: 30.0
//Has Gear: true
//Engine Capacity (cc): 150cc
//
//Brand: Ford
//Model: Focus
//Rental Price/Day: 50.0
//Number of Doors: 5
//Automatic: false
//
//Brand: Honda
//Model: CBR
//Rental Price/Day: 35.5
//Has Gear: false
//Engine Capacity (cc): 250cc
//
//Brand: Chevrolet
//Model: Malibu
//Rental Price/Day: 55.0
//Number of Doors: 4
//Automatic: true
//
//Brand: Suzuki
//Model: GSX
//Rental Price/Day: 40.0
//Has Gear: true
//Engine Capacity (cc): 200cc
//
//Brand: Hero
//Model: Splendor
//Rental Price/Day: 25.0
//Has Gear: true
//Engine Capacity (cc): 110cc
//
//Search vehicle by keyword: 
//honda
//Brand: Honda
//Model: CBR
//Rental Price/Day: 35.5
//Has Gear: false
//Engine Capacity (cc): 250cc
//
//Total Rental Price of vehicles is: 256.0
