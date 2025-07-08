package com.litmus7.retail.app;

import java.util.List;
import java.util.Scanner;

import com.litmus7.retail.dao.ProductDAO;
import com.litmus7.retail.dao.ProductDAOImpl;
import com.litmus7.retail.dto.Product;

public class ProductApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductDAO productDao = new ProductDAOImpl();
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
				productDao.addProduct(product);
				break;
			case 2:
				System.out.println("Enter ProductId to search:");
				int searchId = scanner.nextInt();
				Product found = productDao.getProductById(searchId);
				if (found != null) {
					System.out.println(found);
				}
				break;
			case 3:
				List<Product> allProducts = productDao.getAllProducts();
				if (allProducts.isEmpty()) {
					System.out.println("No products found.");
				} else {
					for (Product p : allProducts) {
						System.out.println(p);
					}
				}
				break;
			case 4:
				System.out.println("Enter product id to update: ");
				int updateId = scanner.nextInt();
				scanner.nextLine();
				Product updateObject = productDao.getProductById(updateId);
				if (updateObject != null) {
					System.out.print("Enter new name (current: " + updateObject.getName() + "): ");
					String newName = scanner.nextLine();
					System.out.print("Enter new category (current: " + updateObject.getCategory() + "): ");
					String newCategory = scanner.nextLine();
					System.out.print("Enter new price (current: " + updateObject.getPrice() + "): ");
					double newPrice = scanner.nextDouble();
					System.out.print("Enter new stock (current: " + updateObject.getStockQuantity() + "): ");
					int newStockQuantity = scanner.nextInt();
					updateObject.setName(newName);
					updateObject.setCategory(newCategory);
					updateObject.setPrice(newPrice);
					updateObject.setStockQuantity(newStockQuantity);

					productDao.updateProduct(updateObject);
				}
				break;
			case 5:
				System.out.println("Enter product id to delete: ");
				int deleteId = scanner.nextInt();
				productDao.deleteProduct(deleteId);
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
