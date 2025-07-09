package com.litmus7.retail.service;

import com.litmus7.retail.dao.ProductDAOImpl;
import com.litmus7.retail.dto.Product;
import com.litmus7.retail.exception.DuplicateProductException;
import com.litmus7.retail.exception.ProductNotFoundException;

import java.util.List;

import com.litmus7.retail.dao.ProductDAO;

public class ProductService {
	private ProductDAO productDao = new ProductDAOImpl();

	public void addProduct(Product product) throws DuplicateProductException, Exception {
		try {
			if (productDao.getProductByName(product.getName()) != null) {
				throw new DuplicateProductException("Product with name: " + product.getName() + " already exists.");
			}
			productDao.addProduct(product);
		} catch (DuplicateProductException e) {
			throw new DuplicateProductException("name already exists:" + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Failed to add the product:" + e.getMessage());
		}
	}

	public Product getProductById(int id) throws ProductNotFoundException, Exception {
		try {
			Product product = productDao.getProductById(id);
			if (product == null) {
				throw new ProductNotFoundException("Product with ID: " + id + "not found.");
			}
			return product;
		} catch (ProductNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new Exception("Failed to fetch the product:" + e.getMessage());
		}
	}

	public List<Product> getAllProducts() throws Exception {
		try {
			return productDao.getAllProducts();
		} catch (Exception e) {
			throw new Exception("Failed to fetch all the products:" + e.getMessage());
		}
	}

	public void updateProduct(Product product) throws ProductNotFoundException, Exception {
		try {
			Product exists = productDao.getProductById(product.getProductId());
			if (exists == null) {
				throw new ProductNotFoundException("Product with id" + product.getProductId() + "doesnt exists.");
			}
			productDao.updateProduct(product);
		} catch (ProductNotFoundException e) {
			throw new ProductNotFoundException("Failed to update the product:" + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Failed to update the product:" + e.getMessage());
		}
	}

	public void deleteProduct(int id) throws ProductNotFoundException, Exception {
		try {
			Product exists = productDao.getProductById(id);
			if (exists == null) {
				throw new ProductNotFoundException("Product with id: " + id + " not found.");
			}
			productDao.deleteProduct(id);
		} catch (ProductNotFoundException e) {
			throw new Exception("Product with the id not found." + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Failed to delete the product:" + e.getMessage());
		}
	}
}
