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
	public Response<List<Vehicle>> dataFromFile(String vehicleFile) {
		Response<List<Vehicle>> response = new Response<>();
		try {
			List<Vehicle> vehicles = vehicleService.dataFromFile(vehicleFile);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setErrorMessage("Vehicles loaded successfully");
			response.setData(vehicles);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("couldnt load file: " + e.getMessage());
		}
		return response;
	}

	/**
	 * Adds a new vehicle to the system.
	 * 
	 * @param vehicle vehicle to be added
	 * @return response object containing updated vehicle list or error info
	 */

	public Response<List<Vehicle>> addVehicle(Vehicle vehicle) {
		Response<List<Vehicle>> response = new Response<>();
		try {
			String message = vehicleService.addVehicle(vehicle);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setErrorMessage(message);
			response.setData(vehicleService.getVehicles());
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Failed to add vehicle:" + e.getMessage());
		}
		return response;
	}
	public Response<List<Vehicle>> searchVehicles(String keyword) {
	    Response<List<Vehicle>> response = new Response<>();
	    List<Vehicle> result = vehicleService.searchByBrandOrModel(keyword);

	    if (!result.isEmpty()) {
	        response.setStatusCode(200);
	        response.setData(result);
	    } else {
	        response.setStatusCode(404);
	        response.setErrorMessage("No vehicles found for keyword: " + keyword);
	    }
	    return response;
	}

	public Response<Double> getTotalRentalPrice() {
	    Response<Double> response = new Response<>();
	    double total = vehicleService.totalRentalPrice();
	    response.setStatusCode(200);
	    response.setData(total);
	    return response;
	}
}
