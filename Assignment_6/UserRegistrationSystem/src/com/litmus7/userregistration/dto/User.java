package com.litmus7.userregistration.dto;

public class User {
	private String username;
	private int age;
	private String email;
	private String password;

	public User(String username, int age, String email, String password) {
		this.username = username;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String toString() {
		return "Username: " + username + ", Age: " + age + ", Email: " + email;
	}
}
