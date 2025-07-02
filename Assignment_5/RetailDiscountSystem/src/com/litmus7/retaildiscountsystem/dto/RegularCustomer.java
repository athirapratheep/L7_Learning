package com.litmus7.retaildiscountsystem.dto;

/**
 * RegularCustomer implements the interface and provides method definition.
 */
public class RegularCustomer implements Discountable {

	/**
	 * applyDiscount of regular customers will apply a discount of 5% to the total
	 * amount.
	 */
	@Override
	public double applyDiscount(double totalAmount) {
		return totalAmount * 0.95;
	}

}
