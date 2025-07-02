package com.litmus7.vehiclerentalsystem.dto;

import java.util.List;

/**
 * Response class that encapsulates response data and status for controller
 * methods. Holds status code, error message, and any type of data. Used to
 * communicate back to UI layer.
 */
public class Response<T> {
	private int statusCode;
	private String errorMessage;
	private T data;
	
	public Response() {}
	public Response (int statusCode,String errorMessage,T data) {
		this.statusCode=statusCode;
		this.errorMessage=errorMessage;
		this.data=data;
	}
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
	 * @return any type of data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data	any type of data
	 */
	public void setData(T data) {
		this.data = data;
	}
}
