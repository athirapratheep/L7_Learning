CREATE TABLE employee(
emp_id INT PRIMARY KEY,
first_name VARCHAR(40),
last_name VARCHAR(40),
birth_day DATE,
sex varchar(1),
salary INT,
super_id INT,
branch_id INT);

CREATE TABLE branch (
branch_id INT PRIMARY KEY,
branch_name VARCHAR(40),
mgr_id iNT,
mgr_start_date DATE,
FOREIGN KEY(mgr_id) REFERENCES employee(emp_id) ON DELETE SET NULL);

ALTER TABLE employee 
ADD FOREIGN KEY(branch_id) 
REFERENCES branch(branch_id)
ON DELETE SET NULL;

ALTER TABLE employee 
ADD FOREIGN KEY(super_id) 
REFERENCES employee(emp_id)
ON DELETE SET NULL;

CREATE TABLE client (
  client_id INT PRIMARY KEY,
  client_name VARCHAR(40),
  branch_id INT,
  FOREIGN KEY(branch_id) REFERENCES branch(branch_id) ON DELETE SET NULL
);

CREATE TABLE works_with (
  emp_id INT,
  client_id INT,
  total_sales INT,
  PRIMARY KEY(emp_id, client_id),
  FOREIGN KEY(emp_id) REFERENCES employee(emp_id) ON DELETE CASCADE,
  FOREIGN KEY(client_id) REFERENCES client(client_id) ON DELETE CASCADE
);

CREATE TABLE branch_supplier (
  branch_id INT,
  supplier_name VARCHAR(40),
  supply_type VARCHAR(40),
  PRIMARY KEY(branch_id, supplier_name),
  FOREIGN KEY(branch_id) REFERENCES branch(branch_id) ON DELETE CASCADE
);

INSERT INTO employee VALUES(100, 'David', 'Wallace', '1967-11-17', 'M', 250000, NULL, NULL);

INSERT INTO branch VALUES(1, 'Corporate', 100, '2006-02-09');

UPDATE employee
SET branch_id = 1
WHERE emp_id = 100;

INSERT INTO employee VALUES(101, 'Jan', 'Levinson', '1961-05-11', 'F', 110000, 100, 1);

-- Scranton
INSERT INTO employee VALUES(102, 'Michael', 'Scott', '1964-03-15', 'M', 75000, 100, NULL);

INSERT INTO branch VALUES(2, 'Scranton', 102, '1992-04-06');

UPDATE employee
SET branch_id = 2
WHERE emp_id = 102;


INSERT INTO employee VALUES(104, 'Kelly', 'Kapoor', '1980-02-05', 'F', 55000, 102, 2);
INSERT INTO employee VALUES(105, 'Stanley', 'Hudson', '1958-02-19', 'M', 69000, 102, 2);

-- Stamford
INSERT INTO employee VALUES(106, 'Josh', 'Porter', '1969-09-05', 'M', 78000, 100, NULL);

INSERT INTO branch VALUES(3, 'Stamford', 106, '1998-02-13');

UPDATE employee
SET branch_id = 3
WHERE emp_id = 106;

INSERT INTO employee VALUES(107, 'Andy', 'Bernard', '1973-07-22', 'M', 65000, 106, 3);
INSERT INTO employee VALUES(108, 'Jim', 'Halpert', '1978-10-01', 'M', 71000, 106, 3);


-- BRANCH SUPPLIER
INSERT INTO branch_supplier VALUES(2, 'Hammer Mill', 'Paper');
INSERT INTO branch_supplier VALUES(2, 'Uni-ball', 'Writing Utensils');
INSERT INTO branch_supplier VALUES(3, 'Patriot Paper', 'Paper');
INSERT INTO branch_supplier VALUES(2, 'J.T. Forms & Labels', 'Custom Forms');
INSERT INTO branch_supplier VALUES(3, 'Uni-ball', 'Writing Utensils');
INSERT INTO branch_supplier VALUES(3, 'Hammer Mill', 'Paper');
INSERT INTO branch_supplier VALUES(3, 'Stamford Lables', 'Custom Forms');

-- CLIENT
INSERT INTO client VALUES(400, 'Dunmore Highschool', 2);
INSERT INTO client VALUES(401, 'Lackawana Country', 2);
INSERT INTO client VALUES(402, 'FedEx', 3);
INSERT INTO client VALUES(403, 'John Daly Law, LLC', 3);
INSERT INTO client VALUES(404, 'Scranton Whitepages', 2);
INSERT INTO client VALUES(405, 'Times Newspaper', 3);
INSERT INTO client VALUES(406, 'FedEx', 2);

-- WORKS_WITH
INSERT INTO works_with VALUES(105, 400, 55000);
INSERT INTO works_with VALUES(102, 401, 267000);
INSERT INTO works_with VALUES(108, 402, 22500);
INSERT INTO works_with VALUES(107, 403, 5000);
INSERT INTO works_with VALUES(108, 403, 12000);
INSERT INTO works_with VALUES(105, 404, 33000);
INSERT INTO works_with VALUES(107, 405, 26000);
INSERT INTO works_with VALUES(102, 406, 15000);
INSERT INTO works_with VALUES(105, 406, 130000);

SELECT * FROM employee ORDER BY sex,first_name,last_name;
SELECT * FROM employee LIMIT 5;
SELECT first_name,last_name from employee;
SELECT first_name AS forename, last_name AS surname FROM employee;

SELECT DISTINCT branch_id from employee;

SELECT COUNT(emp_id) AS Count FROM employee;
INSERT INTO employee VALUES(103, 'Angela', 'Martin', '1971-06-25', 'F', 63000, 102, 2);

SELECT COUNT(emp_id) FROM employee WHERE sex='F' AND birth_day > '1970-01-01';

SELECT AVG(salary) FROM employee WHERE sex='M';

SELECT SUM(salary) FROM employee WHERE sex='M';
SELECT COUNT(sex),sex FROM employee GROUP BY sex;

SELECT SUM(total_sales) AS totalsales,client_id FROM works_with GROUP BY client_id;

SELECT * FROM client WHERE client_name LIKE '%LLC';
SELECT * FROM employee WHERE first_name LIKE '%a%';

SELECT * FROM employee WHERE birth_day LIKE '____-10%';

select first_name FROM employee UNION SELECT branch_name FROM branch;

INSERT INTO branch VALUES(4,'BUffalo',NULL,NULL);

SELECT employee.emp_id,employee.first_name,branch.branch_name FROM employee 
JOIN branch
ON employee.emp_id=branch.mgr_id;

SELECT employee.first_name FROM employee WHERE employee.emp_id IN (SELECT works_with.emp_id 
FROM works_with WHERE works_with.total_sales>30000);

SELECT client.client_name FROM client WHERE branch_id =
(SELECT branch.branch_id FROM branch WHERE branch.mgr_id=102 LIMIT 1);

DELIMITER $$
CREATE TRIGGER my_trigger BEFORE INSERT
ON employee
FOR EACH ROW BEGIN
	IF NEW.sex='M' THEN
		INSERT INTO trigger_test VALUES('ADDED A MALE');
	ELSEIF NEW.sex='F' THEN 
		INSERT INTO trigger_test VALUES('ADDED A FEMALE');
	ELSE
		INSERT INTO trigger_test VALUES('added other employee');
	END IF;
    END$$
DELIMITER ;

INSERT INTO employee VALUES(109, 'Kellyish', 'Kapoor', '1980-02-05', 'F', 550030, 102, 2);
DROP TRIGGER my_trigger;

