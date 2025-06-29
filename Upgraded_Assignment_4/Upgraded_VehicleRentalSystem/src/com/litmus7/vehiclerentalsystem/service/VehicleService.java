package com.litmus7.vehiclerentalsystem.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalsystem.dao.VehicleFileDao;
import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.exception.VehicleDataAccessException;
import com.litmus7.vehiclerentalsystem.exception.VehicleServiceException;

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
	VehicleFileDao vehicleFileDAO = new VehicleFileDao();

	public List<Vehicle> dataFromFile(String vehiclesFile) throws VehicleServiceException {
		try {
			vehicles = vehicleFileDAO.getAllVehiclesFromFile(vehiclesFile);
		} catch (VehicleDataAccessException e) {
			throw new VehicleServiceException("Service failed to load vehicles");
		}
		return vehicles;
	}

	public String addVehicle(Vehicle vehicle) throws VehicleServiceException {
		if (!vehicles.contains(vehicle)) {
			vehicles.add(vehicle);
			return "Vehicle added successfully";
		}
		throw new VehicleServiceException("Vehicle already exists");
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}
}

//	/**
//	 * @param searchword the brand or model to search Searches and displays vehicles
//	 *                   matching a given model or brand
//	 */
//	public void searchByBrandOrModel(List<Vehicle> vehicleList, String searchword) {
//		boolean found = false;
//		for (Vehicle v : vehicleList) {
//			if (v.getBrand().equalsIgnoreCase(searchword) || v.getModel().equalsIgnoreCase(searchword)) {
//				v.displayDetails();
//				found = true;
//			}
//		}
//		if (found == false) {
//			System.out.println("No vehicle found.");
//		}
//	}
//
//	/**
//	 * Calculates the total rental price of all vehicles per day
//	 * 
//	 * @return total rental cost per day
//	 */
//	public double totalRentalPrice(List<Vehicle> vehicleList) {
//		double total = 0;
//		for (Vehicle v : vehicleList) {
//			total += v.getrentalPricePerDay();
//		}
//		return total;
//	}
//}
