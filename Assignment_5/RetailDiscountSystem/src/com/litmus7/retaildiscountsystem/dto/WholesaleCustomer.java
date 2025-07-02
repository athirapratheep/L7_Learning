package com.litmus7.retaildiscountsystem.dto;

/**
 * 
 */
public class WholesaleCustomer implements Discountable {

	/**
	 * applyDiscount of wholesale customers will apply a discount of 15% to the
	 * total amount if its greater than 10000 else 20%.
	 */
	@Override
	public double applyDiscount(double totalAmount) {
		if (totalAmount > 10000) {
			return totalAmount * 0.85;
		} else {
			return totalAmount * 0.80;
		}

	}
}