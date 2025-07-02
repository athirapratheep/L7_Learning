package com.litmus7.retaildiscountsystem.dto;

public class WholesaleCustomer implements Discountable {

	@Override
	public double applyDiscount(double totalAmount) {
		if (totalAmount > 10000) {
			return totalAmount * 0.85;
		} else {
			return totalAmount * 0.80;
		}

	}
}