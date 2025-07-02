package com.litmus7.retaildiscountsystem.ui;

import java.util.Scanner;

import com.litmus7.retaildiscountsystem.dto.Discountable;
import com.litmus7.retaildiscountsystem.dto.PremiumCustomer;
import com.litmus7.retaildiscountsystem.dto.RegularCustomer;
import com.litmus7.retaildiscountsystem.dto.WholesaleCustomer;

public class RetailStoreApp {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter customer type(1-Regular,2-Premium,3-Wholesale): ");
		int customerType=scanner.nextInt();
		System.out.println("Enter total purchase amount: ");
		double totalAmount=scanner.nextDouble();
		Discountable customer =null;
		switch(customerType) {
		case 1:
			customer=new RegularCustomer();
			break;
		case 2:
			customer=new PremiumCustomer();
			break;
		case 3:
			customer=new WholesaleCustomer();
			break;
		default:
			System.out.println("Invalid customer type.");
			System.exit(0);
		}
		double finalAmount = customer.applyDiscount(totalAmount);
		double discountApplied=totalAmount-finalAmount;
		System.out.println("Customer Type: "+customer.getClass().getSimpleName());
		System.out.println("Original Amount: "+totalAmount);
		System.out.println("Discount Applied: "+ discountApplied);
		System.out.println("Final Payable Amount: "+ finalAmount);
		scanner.close();
	}

}
