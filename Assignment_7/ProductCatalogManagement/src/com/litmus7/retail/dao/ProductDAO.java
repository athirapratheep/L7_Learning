package com.litmus7.retail.dao;
import java.util.*;
import com.litmus7.retail.dto.Product;

public interface ProductDAO {
	void addProduct(Product product);
	Product getProductById(int productId);
	Product getProductByName(String name);
	List<Product> getAllProducts();
	void updateProduct(Product product);
	void deleteProduct(int productId);
}
