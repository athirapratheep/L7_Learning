package com.litmus7.vehiclerentalsystem.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalsystem.dto.Bike;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.exception.VehicleDataAccessException;

/**
 * DAO class for accessing vehicle data from files. Reads data and converts it
 * to Vehicle, Car, or Bike objects.
 */
public class VehicleFileDao {
	/**
	 * Reads all vehicles from a given file.
	 * 
	 * @param vehiclesFile path to the data file
	 * @return list of vehicles
	 * @throws VehicleDataAccessException if file reading fails
	 */
	public List<Vehicle> getAllVehiclesFromFile(String vehiclesFile) throws VehicleDataAccessException {
		List<Vehicle> vehicles = new ArrayList<>();
		try (BufferedReader bf = new BufferedReader(new FileReader(vehiclesFile))) {
			String line;
			while ((line = bf.readLine()) != null) {
				Vehicle vehicle = parseVehicle(line);
				if (vehicles != null) {
					vehicles.add(vehicle);
				}
			}
		} catch (FileNotFoundException e) {
			throw new VehicleDataAccessException("File not found: " + e.getMessage(), e);
		} catch (IOException e) {
			throw new VehicleDataAccessException("Error reading file: " + e.getMessage(), e);
		}
		return vehicles;
	}

	/**
	 * @param line each vehicle from the file
	 * @return new objects
	 */
	public Vehicle parseVehicle(String line) {
		String[] parts = line.split(",");
		if (parts[0].equalsIgnoreCase("Car")) {
			return new Car(parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]),
					Boolean.parseBoolean(parts[5]));
		} else if (parts[0].equalsIgnoreCase("Bike")) {
			return new Bike(parts[1], parts[2], Double.parseDouble(parts[3]), Boolean.parseBoolean(parts[4]),
					Integer.parseInt(parts[5]));
		}
		return null;
	}
}
