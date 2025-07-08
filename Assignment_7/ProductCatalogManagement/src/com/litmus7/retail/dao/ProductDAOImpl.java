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

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Product added successfully!");
			} else {
				System.out.println("Failed to add product.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product getProductById(int productId) {
		String sql = "SELECT * FROM products WHERE productId=?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, productId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					return new Product(rs.getInt("productId"), rs.getString("name"), rs.getString("category"),
							rs.getDouble("price"), rs.getInt("stockQuantity"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Product ID: " + productId + " not found!");
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM products";
		try (Connection conn = DBUtil.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {

			while (rs.next()) {
				Product p = new Product(rs.getInt("productId"), rs.getString("name"), rs.getString("category"),
						rs.getDouble("price"), rs.getInt("stockQuantity"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE products SET name=?,category=?,price=?,stockQuantity=? WHERE productId=?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getCategory());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setInt(4, product.getStockQuantity());
			pstmt.setInt(5, product.getProductId());
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Product updated successfully!");
			} else {
				System.out.println("Update failed, Product with id: "+product.getProductId()+" not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int productId) {
		String sql = "DELETE FROM products WHERE productId=?";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, productId);
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Product deleted successfully!");
			} else {
				System.out.println("Deletion failed, Product with id: "+ productId+" not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
