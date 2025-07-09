package com.litmus7.retail.controller;

import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.DuplicateProductException;
import com.litmus7.retail.exception.ProductNotFoundException;
import com.litmus7.retail.service.ProductService;

public class ProductController {
	private ProductService productService = new ProductService();

	public void addProduct(Product product) {
		try {
			productService.addProduct(product);
			System.out.println("Product added successfully");
		} catch (DuplicateProductException e) {
			System.out.println("Validation error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error addign the product: " + e.getMessage());
		}
	}

	public void viewProductById(int id) {
		try {
			Product product = productService.getProductById(id);
			System.out.println(product);
		} catch (ProductNotFoundException e) {
			System.out.println("Not found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error fetching the product: " + e.getMessage());
		}
	}

	public void viewAllProducts() {
		try {
			List<Product> products = productService.getAllProducts();
			if (products.isEmpty()) {
				System.out.println("No products found.");
			} else {
				for (Product p : products) {
					System.out.println(p);
				}
			}
		} catch (Exception e) {
			System.out.println("Error fetching the products." + e.getMessage());
		}
	}

	public void updateProduct(Product product) {
		try {
			productService.updateProduct(product);
			System.out.println("Product updated successfully!");
		} catch (ProductNotFoundException e) {
			System.out.println("Not Found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error updating product: " + e.getMessage());
		}
	}

	public void deleteProduct(int id) {
		try {
			productService.deleteProduct(id);
			System.out.println("Product deleted successfully!");
		} catch (ProductNotFoundException e) {
			System.out.println("Not Found: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error deleting product: " + e.getMessage());
		}
	}
}
