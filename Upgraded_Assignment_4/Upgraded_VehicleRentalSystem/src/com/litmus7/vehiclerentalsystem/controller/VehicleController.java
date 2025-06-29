package com.litmus7.vehiclerentalsystem.controller;

import java.util.List;

import com.litmus7.vehiclerentalsystem.dto.Response;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.exception.VehicleServiceException;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

public class VehicleController {
	private VehicleService vehicleService=new VehicleService();
	private static final int SUCCESS_STATUS_CODE=200;
	private static final int ERROR_STATUS_CODE=500;
	public Response dataFromFile(String vehicleFile) {
		Response response=new Response();
		List<Vehicle> vehicles=null;
		try {
			vehicles=vehicleService.dataFromFile(vehicleFile);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setVehicles(vehicles);
		}catch(VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("couldnt load file");
		}
		return response;
	}
	public Response addVehicle(Vehicle vehicle)
	{
		Response response=new Response();
		try {
			String message=vehicleService.addVehicle(vehicle);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setErrorMessage(message);
			response.setVehicles(vehicleService.getVehicles());
		}catch(VehicleServiceException e)
		{
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
}
