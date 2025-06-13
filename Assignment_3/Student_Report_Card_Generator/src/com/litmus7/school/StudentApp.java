package com.litmus7.school;
import com.litmus7.school.dto.Student;
public class StudentApp {

	public static void main(String[] args) {
		Student s = new Student();
		s.inputDetails();
		s.calculateTotal();
		s.calculateAverage();
		s.getGrade();
		s.printReportCard();	}

}
