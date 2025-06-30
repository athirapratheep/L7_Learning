package com.litmus7.vehiclerentalsystem.dto;

import java.util.List;

/**
 * Response class that encapsulates response data and status for controller
 * methods. Holds status code, error message, and list of vehicles. Used to
 * communicate back to UI layer.
 */
public class Response {
	private int statusCode;
	private String errorMessage;
	private List<Vehicle> vehicles;

	/**
	 * @return status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode status code to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage error message to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;

	}

	/**
	 * @return list of vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles list of vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
