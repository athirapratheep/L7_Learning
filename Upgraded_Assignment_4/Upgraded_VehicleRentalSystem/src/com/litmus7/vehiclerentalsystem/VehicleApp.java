package com.litmus7.vehiclerentalsystem;

import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

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
		VehicleService service = new VehicleService();
		service.loadVehicles("vehicles.txt");
		System.out.println("Loaded Vehicles: ");
		Vehicle newBike = new Bike("Hero", "Splendor", 25, true, 110);
		service.addVehicle(newBike);
		System.out.println("\nAfter adding New Vehicle: ");
		service.displayAllVehicles();
		System.out.println("Search vehicle by keyword: ");
		String keyword = scanner.nextLine();
		service.searchByBrandOrModel(keyword);
		System.out.println();
		System.out.println("Total Rental Price of vehicles is: " + service.totalRentalPrice());
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
//Total Rental Price of vehicles is: 281.0
