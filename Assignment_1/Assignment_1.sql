CREATE TABLE Students (
student_ID INT PRIMARY KEY,
name VARCHAR(25),
email VARCHAR(40),
dob DATE,
advisor_ID INT);

CREATE TABLE Advisors (
advisor_ID INT PRIMARY KEY,
name VARCHAR(25),
email VARCHAR(40),
specialization VARCHAR(25));

CREATE TABLE Courses (
course_code INT PRIMARY KEY,
title VARCHAR(25), 
description VARCHAR(100),
instructor VARCHAR(25));


ALTER TABLE Students 
ADD FOREIGN KEY(advisor_ID) REFERENCES Advisors(advisor_ID) ON DELETE SET NULL;

CREATE TABLE StudentCourses(
student_ID INT NOT NULL,
course_code INT NOT NULL,
PRIMARY KEY(student_ID,course_code),
FOREIGN KEY(student_ID) REFERENCES Students(student_ID) ON DELETE CASCADE,
FOREIGN KEY(course_code) REFERENCES Courses(course_code) ON DELETE CASCADE);