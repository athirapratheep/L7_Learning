CREATE TABLE Customers (
customer_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE,
city VARCHAR(50),
signupdate DATE );

CREATE TABLE Orders (
order_id INT AUTO_INCREMENT PRIMARY KEY,
customer_id INT,
orderdate DATE,
totalamount DECIMAL(10,2) CHECK(totalamount>0),
CONSTRAINT fk_customer_id FOREIGN KEY(customer_id) REFERENCES Customers (customer_id));

CREATE TABLE Products (
product_id INT AUTO_INCREMENT PRIMARY KEY,
productname VARCHAR(100) NOT NULL,
category VARCHAR(50) NOT NULL,
price DECIMAL(10,2) CHECK (price>0));

CREATE TABLE OrderDetails(
orderdetail_id INT AUTO_INCREMENT PRIMARY KEY,
order_id INT,
product_id INT,
quantity INT CHECK (quantity>0),
price DECIMAL(10,2) CHECK (price>0),
CONSTRAINT fk_order_id FOREIGN KEY(order_id) REFERENCES Orders(order_id),
CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES Products (product_id));


CREATE INDEX idx_customers_city ON Customers(city);
CREATE INDEX idx_orders_orderdate ON Orders(orderdate);
CREATE INDEX idx_orders_customer_id ON Orders(customer_id);
CREATE INDEX idx_products_category ON Products(category);
CREATE INDEX idx_orderdetails_product_id ON OrderDetails(product_id);
CREATE INDEX idx_orderdetails_order_id ON OrderDetails(order_id);

INSERT INTO Customers (customer_id, name, email, city, signupdate) VALUES
(1, 'Aisha Mehra', 'aisha.mehra@example.com', 'Mumbai', '2024-03-10'),
(2, 'Ravi Sharma', 'ravi.sharma@example.com', 'Delhi', '2023-11-22'),
(3, 'Neel Roy', 'neel.roy@example.com', 'Mumbai', '2025-01-05'),
(4, 'Sneha Pillai', 'sneha.pillai@example.com', 'Chennai', '2022-12-31'),
(5, 'John Mathew', 'john.mathew@example.com', 'Kolkata', '2024-08-15'),
(6, 'Ishita Nair', 'ishita.nair@example.com', 'Pune', '2024-07-20');  

INSERT INTO products (product_id, productname, category, price) VALUES
(101, 'LED TV', 'Electronics', 25000.00),
(102, 'Bluetooth Speaker', 'Electronics', 3000.00),
(103, 'Notebook', 'Stationery', 50.00),
(104, 'Pen Set', 'Stationery', 100.00),
(105, 'Microwave', 'Appliances', 8000.00),
(106, 'Smartphone', 'Electronics', 15000.00),
(107, 'Coffee Mug', 'Kitchenware', 200.00);

INSERT INTO Orders (order_id, customer_id, orderdate, totalamount) VALUES
(1001, 1, '2025-06-01', 28000.00),
(1002, 2, '2025-05-10', 150.00),
(1003, 3, '2025-04-15', 20000.00),
(1004, 4, '2023-12-25', 499.00),
(1005, 5, '2024-09-05', 7500.00);

INSERT INTO OrderDetails (orderdetail_id, order_id, product_id, quantity, price) VALUES
(501, 1001, 101, 1, 25000.00),   
(502, 1001, 102, 1, 3000.00), 
(503, 1002, 103, 3, 50.00),     
(504, 1003, 106, 1, 15000.00),  
(505, 1003, 102, 2, 3000.00),   
(506, 1004, 104, 2, 100.00),     
(507, 1005, 105, 1, 8000.00);   

-- answers: basic queries
SELECT * FROM Customers;
SELECT Orders.order_id,Orders.customer_id,Orders.orderdate,Orders.totalamount FROM Orders WHERE orderdate >= curdate() - INTERVAL 30 DAY;
SELECT productname,price FROM Products;
SELECT COUNT(product_id) AS product_count,category FROM Products GROUP BY category;

-- filtering and conditions
SELECT Customers.customer_id, Customers.name, Customers.city FROM Customers WHERE city='Mumbai';
SELECT Orders.order_id, Orders.customer_id, Orders.totalamount FROM Orders WHERE totalamount>5000;
SELECT Customers.customer_id, Customers.name,Customers.signupdate FROM Customers WHERE signupdate>'2024-01-01';

-- joins
SELECT Customers.name,Orders.order_id,Orders.orderdate,Orders.totalamount FROM 
Orders JOIN Customers ON Orders.customer_id=Customers.customer_id;

SELECT Orders.order_id,Products.productname,OrderDetails.quantity FROM
OrderDetails JOIN Products ON OrderDetails.product_id=Products.product_id
 JOIN Orders ON Orders.order_id=OrderDetails.order_id;

SELECT Customers.customer_id, Customers.name, Orders.order_id  FROM Customers LEFT JOIN Orders ON Customers.customer_id=Orders.customer_id
WHERE Orders.order_id IS NULL;

-- aggregation and grouping
SELECT Customers.customer_id,Customers.name,SUM(Orders.totalamount) FROM
Customers JOIN Orders ON Customers.customer_id=Orders.customer_id
GROUP BY Customers.customer_id;

SELECT Products.productname,SUM(OrderDetails.quantity) AS totalquantity FROM Products
JOIN OrderDetails ON Products.product_id=OrderDetails.product_id GROUP BY Products.productname
ORDER BY totalquantity DESC 
LIMIT 1;

SELECT Customers.customer_id,Customers.name, AVG(Orders.totalamount) AS avg_amount
FROM Customers JOIN Orders
ON Customers.customer_id=Orders.customer_id GROUP BY Customers.customer_id;

SELECT SUM((OrderDetails.price) * (OrderDetails.quantity)) AS total_products,Products.category FROM
OrderDetails JOIN Products ON OrderDetails.product_id=Products.product_id GROUP BY Products.category;

-- subqueries
SELECT customer_id,name FROM ( SELECT Customers.customer_id,Customers.name,SUM(Orders.totalamount) AS totalspent
FROM Customers JOIN Orders ON Customers.customer_id=Orders.customer_id GROUP BY Customers.customer_id,Customers.name) 
AS totals WHERE totalspent > (SELECT AVG(totalamount) FROM Orders);

SELECT Products.product_id, Products.productname, Products.category, Products.price FROM Products WHERE product_id NOT IN(SELECT DISTINCT product_id FROM orderdetails);

SELECT Customers.customer_id,Customers.name, MAX(Orders.orderdate) FROM Customers JOIN Orders
ON Customers.customer_id=Orders.customer_id GROUP BY Customers.customer_id;

-- advanced queries

SELECT Customers.customer_id,Customers.name,SUM(Orders.totalamount) AS totalspent
FROM Customers JOIN Orders ON Customers.customer_id=Orders.customer_id
GROUP BY Customers.customer_id ORDER BY totalspent DESC;

SELECT Customers.customer_id,Customers.name,COUNT(Orders.order_id) AS ordercount FROM
Customers JOIN Orders ON Customers.customer_id=Orders.customer_id
GROUP BY Customers.customer_id,Customers.name ORDER BY ordercount DESC LIMIT 3;

SELECT Products.productname,COUNT(DISTINCT Orders.customer_id) AS uniqueorders
FROM OrderDetails JOIN Products ON OrderDetails.product_id=Products.product_id
JOIN Orders ON OrderDetails.order_id=Orders.order_id GROUP BY Products.productname;