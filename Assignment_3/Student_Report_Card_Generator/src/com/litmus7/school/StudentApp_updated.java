package com.litmus7.school;

import com.litmus7.school.dto.Student_updated;

public class StudentApp_updated {

	public static void main(String[] args) {
		
		Student_updated student = new Student_updated();
		student.inputDetails();
		student.calculateTotal();
		student.calculateAverage();
		student.evaluateGrade();
		student.printReportCard();
	}

}
