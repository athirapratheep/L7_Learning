package com.litmus7.retail.app;

import java.util.Scanner;

import com.litmus7.retail.controller.ProductController;
import com.litmus7.retail.dto.Product;

public class ProductApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductController controller = new ProductController();
		while (true) {
			System.out.println("\n---RetailMart Product Catalog---");
			System.out.println("1. Add Product");
			System.out.println("2. View Product by ID");
			System.out.println("3. View All Products");
			System.out.println("4. Update Product");
			System.out.println("5. Delete Product");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter Product ID: ");
				int productId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Category: ");
				String category = scanner.nextLine();
				System.out.print("Enter Price: ");
				double price = scanner.nextDouble();
				System.out.print("Enter Stock Quantity: ");
				int stockQuantity = scanner.nextInt();

				Product product = new Product(productId, name, category, price, stockQuantity);
				controller.addProduct(product);
				break;
			case 2:
				System.out.println("Enter ProductId to search:");
				int searchId = scanner.nextInt();
				controller.viewProductById(searchId);
				break;
			case 3:
				controller.viewAllProducts();
				break;
			case 4:
				System.out.println("Enter product id to update: ");
				int updateId = scanner.nextInt();
				scanner.nextLine();
				controller.viewProductById(updateId);
				System.out.print("Enter new name : ");
				String newName = scanner.nextLine();
				System.out.print("Enter new category : ");
				String newCategory = scanner.nextLine();
				System.out.print("Enter new price : ");
				double newPrice = scanner.nextDouble();
				System.out.print("Enter new stock : ");
				int newStockQuantity = scanner.nextInt();
				Product updatedProduct = new Product(updateId, newName, newCategory, newPrice, newStockQuantity);
				controller.updateProduct(updatedProduct);
				break;
			case 5:
				System.out.println("Enter product id to delete: ");
				int deleteId = scanner.nextInt();
				controller.deleteProduct(deleteId);
				break;
			case 6:
				System.out.println("Thank you for using RetailMart Product Catalog Manager.\nGoodbye!");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

}
