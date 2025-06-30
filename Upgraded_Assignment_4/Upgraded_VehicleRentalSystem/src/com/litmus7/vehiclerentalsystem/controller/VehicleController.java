package com.litmus7.vehiclerentalsystem.controller;

import java.util.List;

import com.litmus7.vehiclerentalsystem.dto.Response;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.exception.VehicleServiceException;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

/**
 * Controller class for Vehicle Rental System. Acts as an intermediary between
 * UI and Service layer. Handles service exceptions and prepares a Response
 * object
 */
public class VehicleController {
	private VehicleService vehicleService = new VehicleService();
	private static final int SUCCESS_STATUS_CODE = 200;
	private static final int ERROR_STATUS_CODE = 500;

	/**
	 * Loads vehicle from the specified file
	 * 
	 * @param vehicleFile path to the file containing vehicle data
	 * @return response object containing vehicles or error info
	 */
	public Response dataFromFile(String vehicleFile) {
		Response response = new Response();
		List<Vehicle> vehicles = null;
		try {
			vehicles = vehicleService.dataFromFile(vehicleFile);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setVehicles(vehicles);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("couldnt load file");
		}
		return response;
	}

	/**
	 * Adds a new vehicle to the system.
	 * 
	 * @param vehicle vehicle to be added
	 * @return response object containing updated vehicle list or error info
	 */
	public Response addVehicle(Vehicle vehicle) {
		Response response = new Response();
		try {
			String message = vehicleService.addVehicle(vehicle);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setErrorMessage(message);
			response.setVehicles(vehicleService.getVehicles());
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
}
