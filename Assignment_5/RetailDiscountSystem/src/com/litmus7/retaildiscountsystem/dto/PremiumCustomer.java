package com.litmus7.retaildiscountsystem.dto;

public class PremiumCustomer implements Discountable {

	@Override
	public double applyDiscount(double totalAmount) {
		if(totalAmount>5000) {
			return totalAmount*0.90;
		}else {
			return totalAmount*0.93;
		}
		
	}

}
