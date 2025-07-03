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
 * Service class for Vehicle Rental System. Contains business logic for managing
 * vehicles. Calls DAO layer for data access. Handles validations and prevents
 * duplicate entries.
 */
public class VehicleService {
	private List<Vehicle> vehicles = new ArrayList<>();
	VehicleFileDao vehicleFileDAO = new VehicleFileDao();

	/**
	 * Loads vehicle data from file using DAO.
	 * 
	 * @param vehiclesFile path to vehicle data file
	 * @return list of vehicles
	 * @throws VehicleServiceException if file reading fails
	 */
	public List<Vehicle> dataFromFile(String vehiclesFile) throws VehicleServiceException {
		try {
			vehicles = vehicleFileDAO.getAllVehiclesFromFile(vehiclesFile);
		} catch (VehicleDataAccessException e) {
			throw new VehicleServiceException("Service failed to load vehicles");
		}
		return vehicles;
	}

	/**
	 * Adds a new vehicle if it does not already exist.
	 * 
	 * @param vehicle vehicle to add
	 * @return success manage
	 * @throws VehicleServiceException if vehicle already exists
	 */
	public String addVehicle(Vehicle vehicle) throws VehicleServiceException {
		if (!vehicles.contains(vehicle)) {
			vehicles.add(vehicle);
			return "Vehicle added successfully";
		}
		throw new VehicleServiceException("Vehicle already exists");
	}

	/**
	 * Gets the current list of vehicles
	 * 
	 * @return list of vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	/**
	 * @param searchword the brand or model to search Searches and displays vehicles
	 *                   matching a given model or brand
	 */

	public List<Vehicle> searchByBrandOrModel(String keyword) {
	    List<Vehicle> result = new ArrayList<>();
	    for (Vehicle v : vehicles) {
	        if (v.getBrand().equalsIgnoreCase(keyword) || v.getModel().equalsIgnoreCase(keyword)) {
	            result.add(v);
	        }
	    }
	    return result;
	}
	/**
	 * Calculates the total rental price of all vehicles per day
	 * 
	 * @return total rental cost per day
	 */
	public double totalRentalPrice() {
	    double total = 0;
	    for (Vehicle v : vehicles) {
	        total += v.getrentalPricePerDay();
	    }
	    return total;
	}
}


