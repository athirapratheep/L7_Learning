package com.litmus7.codepractice;

public class Product {
	private String productId;
	private String productName;
	private String category;
	private double price;
	private int quantityAvailable;

	public Product(String productId, String productName, String category, double price, int quantityAvailable) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public String toString() {
		return productId + "-" + productName + "-" + category + "-" + price + "-Qty" + quantityAvailable;
	}
}
