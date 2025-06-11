CREATE TABLE Students (
student_ID INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
email VARCHAR(50) UNIQUE,
dob DATE,
advisor_ID INT);

CREATE TABLE Advisors (
advisor_ID INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
email VARCHAR(50) UNIQUE,
specialization VARCHAR(50));

CREATE TABLE Courses (
course_code INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(50) NOT NULL, 
description VARCHAR(100),
instructor VARCHAR(50));


ALTER TABLE Students 
ADD CONSTRAINT fk_advisor_id FOREIGN KEY(advisor_ID) REFERENCES Advisors(advisor_ID) ON DELETE SET NULL;

CREATE TABLE StudentCourses(
student_ID INT AUTO_INCREMENT NOT NULL,
course_code INT NOT NULL,
status VARCHAR(50),
enrollmentdate DATE,
PRIMARY KEY(student_ID,course_code),
CONSTRAINT fk_student_id FOREIGN KEY(student_ID) REFERENCES Students(student_ID) ON DELETE CASCADE,
CONSTRAINT fk_course_code FOREIGN KEY(course_code) REFERENCES Courses(course_code) ON DELETE CASCADE);

