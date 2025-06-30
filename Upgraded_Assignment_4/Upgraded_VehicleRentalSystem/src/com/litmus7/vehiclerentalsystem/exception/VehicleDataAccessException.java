package com.litmus7.vehiclerentalsystem.exception;

/**
 * Exception for errors in DAO layer.
 */
public class VehicleDataAccessException extends Exception {

	public VehicleDataAccessException(String message, Throwable cause) {
		super(message, cause);
	}
}
