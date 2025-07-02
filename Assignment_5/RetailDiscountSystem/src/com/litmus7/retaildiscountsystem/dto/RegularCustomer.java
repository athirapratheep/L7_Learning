package com.litmus7.retaildiscountsystem.dto;

public class RegularCustomer implements Discountable{

	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount * 0.95;
	}
	
}
