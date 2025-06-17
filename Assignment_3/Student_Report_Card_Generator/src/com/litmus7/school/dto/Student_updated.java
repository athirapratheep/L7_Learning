package com.litmus7.school.dto;

import java.util.Scanner;

/**
 * Represents a student with name, roll number, marks, total, average, and
 * grade. Provides methods to input details, compute total and average,
 * determine grade, and print the report card.
 */
public class Student_updated {
	
	private String name;
	private int rollNumber;
	private int[] marks = new int[5];
	private int total;
	private double average;
	private Grade grade;

	/**
	 * Enum representing possible student grades.
	 */
	private enum Grade {
		A, B, C, D, F
	}

	/**
	 * Accepts student details from console input including name, roll number, and
	 * marks in five subjects.
	 */
	public void inputDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name:");
		name = scanner.nextLine();
		System.out.println("Enter the roll number:");
		rollNumber = scanner.nextInt();
		System.out.println("Enter the marks in 5 subjects:");
		for (int i = 0; i < 5; i++) {
			System.out.print("Subject " + (i + 1) + ": ");
			marks[i] = scanner.nextInt();
		}
		scanner.close();
	}

	/**
	 * Calculates the total marks obtained by the student.
	 */
	public void calculateTotal() {
		total = 0;
		for (int mark : marks) {
			total += mark;
		}
		System.out.println("Total marks: " + total);
	}

	/**
	 * Calculates the average of marks.
	 */
	public void calculateAverage() {
		average = total / 5.0;
		System.out.println("The Average is: " + average);
	}

	/**
	 * Determines the grade based on the average marks.
	 */
	public void evaluateGrade() {
		if (average >= 90) {
			grade = Grade.A;
		} else if (average >= 75) {
			grade = Grade.B;
		} else if (average >= 60) {
			grade = Grade.C;
		} else if (average >= 50) {
			grade = Grade.D;
		} else {
			grade = Grade.F;
		}
	}

	/**
	 * Prints the report card with all student details.
	 */
	public void printReportCard() {
		System.out.println("-- Report Card --");
		System.out.println("Name: " + name);
		System.out.println("Roll Number: " + rollNumber);
		System.out.println("Total Marks: " + total);
		System.out.println("Average Marks: " + average);
		System.out.println("Grade: " + grade);
	}
}
