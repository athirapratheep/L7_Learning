package com.litmus7.school.dto;

import java.util.Scanner;

public class Student {
	private String name;
	private int rollNumber;
	private int[]  marks = new int[5];
	private int total;
	private double average;
	private char grade;
	
	public void inputDetails() 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the name");
		name=scanner.nextLine();
		System.out.println("Enter the roll number");
		rollNumber=scanner.nextInt();
		System.out.println("Enter the marks in 5 subjects");
		for(int i=0;i<5;i++)
		{
			System.out.println("Subject"+(i+1)+":");
			marks[i]=scanner.nextInt();
		}
		scanner.close();
	}
		public void calculateTotal() 
		{
			total=0;
			for(int mark:marks)
			{
				total+=mark;
			}
			System.out.println("Total marks: "+total);
		}
		
		public void calculateAverage() 
		{
			average = total/5.0;
			System.out.println("The Average is: "+average);
		}
		
		public void getGrade() 
		{
			if(average >= 90)
			{
				grade='A';
			}
			else if(average >= 75)
			{
				grade = 'B';
			}
			else if(average >=60)
			{
				grade='C';
			}
			else if(average>=50)
			{
				grade='D';
			}
			else
			{
				grade='F';
			}
		}
		
		public void printReportCard()
		{
			System.out.println("--Report Card--");
			System.out.println("Name: "+name);
			System.out.println("Roll Number: "+rollNumber);
			System.out.println("Total Marks: "+total);
			System.out.println("Average marks: "+average);
			System.out.println("Grade: "+grade);
		}
		
}
