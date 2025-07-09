package com.litmus7.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.retail.dto.Product;
import com.litmus7.retail.util.DBUtil;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void addProduct(Product product) {
		String sql = "INSERT INTO products (productId,name,category,price,stockQuantity) VALUES (?,?,?,?,?)";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getCategory());
			pstmt.setDouble(4, product.getPrice());
			pstmt.setInt(5, product.getStockQuantity());
		} catch (SQLException e) {
			System.out.println("Error adding product: " + e.getMessage());
		}
	}

	@Override
	public Product getProductById(int productId) {
		String sql = "SELECT productId,name,category,price,stockQuantity FROM products WHERE productId=?;";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, productId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Product(rs.getInt("productId"), rs.getString("name"), rs.getString("category"),
							rs.getDouble("price"), rs.getInt("stockQuantity"));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error fetching the product by id: " + e.getMessage());
		}
		System.out.println("Product ID: " + productId + " not found!");
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT productId,name,category,price,stockQuantity FROM products;";
		try (Connection conn = DBUtil.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {

			while (rs.next()) {
				Product p = new Product(rs.getInt("productId"), rs.getString("name"), rs.getString("category"),
						rs.getDouble("price"), rs.getInt("stockQuantity"));
				list.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Error fetching all the products: " + e.getMessage());
		}
		return list;
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE products SET name=?,category=?,price=?,stockQuantity=? WHERE productId=?;";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getCategory());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setInt(4, product.getStockQuantity());
			pstmt.setInt(5, product.getProductId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error updating the product: " + e.getMessage());
		}
	}

	@Override
	public void deleteProduct(int productId) {
		String sql = "DELETE FROM products WHERE productId=?;";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, productId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error deleting the product: " + e.getMessage());
		}

	}

	@Override
	public Product getProductByName(String name) {
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("SELECT name,category,price,stockQuantity FROM products WHERE name=?")) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Product(rs.getInt("productId"), rs.getString("name"), rs.getString("category"),
						rs.getDouble("price"), rs.getInt("stockQuantity"));
			}
		} catch (SQLException e) {
			System.out.println("Error fetching the product by name: " + e.getMessage());
		}
		return null;
	}

}
