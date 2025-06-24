package com.litmus7.vehiclerentalsystem;

import com.litmus7.vehiclerentalsystem.dto.*;
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
