package com.litmus7.retaildiscountsystem.dto;

/**
 * Discountable Interface has a method applyDiscount implemented by other
 * classes.
 */
public interface Discountable {
	double applyDiscount(double totalAmount);
}
