package com.litmus7.retaildiscountsystem.dto;

/**
 * PremiumCustomer implements the interface and provides method definition.
 */
public class PremiumCustomer implements Discountable {

	/**
	 * applyDiscount of premium customers will apply a discount of 10% to the total
	 * amount if its greater than 5000 or 7%.
	 */
	@Override
	public double applyDiscount(double totalAmount) {
		if (totalAmount > 5000) {
			return totalAmount * 0.90;
		} else {
			return totalAmount * 0.93;
		}

	}

}
