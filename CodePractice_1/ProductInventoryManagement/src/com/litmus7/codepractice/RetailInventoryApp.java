package com.litmus7.codepractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class RetailInventoryApp {

	public static void main(String[] args) {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product("P101", "Keyboard", "Electronics", 999.99, 25));
		productList.add(new Product("P102", "Mouse", "Electronics", 499.95, 40));
		productList.add(new Product("P103", "Notebook", "Stationary", 59.99, 150));
		productList.add(new Product("P104", "Pen", "Stationary", 9.99, 300));
		productList.add(new Product("P105", "Monitor", "Electronics", 5999.00, 10));
		System.out.println();
		System.out.println("All products: ");
		for (Product p : productList) {
			System.out.println(p);
		}
		System.out.println();
		System.out.println("Products Sorted by Price: ");
		Collections.sort(productList,new PriceComparator());
		for (Product p : productList) {
			System.out.println(p);
		}
		System.out.println();
		System.out.println("Products sorted by name: ");
		productList.sort((p1,p2)->p1.getProductName().compareToIgnoreCase(p2.getProductName()));
		for(Product p:productList)
		{
			System.out.println(p);
		}
		System.out.println();
		System.out.println("quantity less than 30: ");
		for(Product p:productList)
		{
			if(p.getQuantityAvailable()<30)
			{
				System.out.println(p);
			}
		}
		System.out.println();
		System.out.println("total inventory value: ");
		for(Product p:productList)
		{
			System.out.println(p.getQuantityAvailable()*p.getPrice());
		}
		
	}

}
