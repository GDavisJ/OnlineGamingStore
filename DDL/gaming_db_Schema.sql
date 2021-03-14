CREATE SCHEMA gaming_db;
CREATE TABLE gaming_db.users (
  id int NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  firstname VARCHAR(45) NOT NULL,
  lastname VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  phonenumber VARCHAR(45) NOT NULL,
  CONSTRAINT primary_key PRIMARY KEY (id));
  
  CREATE TABLE gaming_db.products (
  prodId int NOT NULL AUTO_INCREMENT,
  productName VARCHAR(45) NOT NULL,
  productDescription VARCHAR(500) NOT NULL,
  productQuantity INTEGER NOT NULL,
  productPrice DOUBLE NOT NULL,
  CONSTRAINT primary_key PRIMARY KEY (prodId));
  
 
  INSERT INTO gaming_db.users(username, password, firstname, lastname, email, phonenumber) VALUES('gdavis', '1234', 'Gary', 'Davis','gdavis@test.com', '1234567891');
  INSERT INTO gaming_db.users(username, password, firstname, lastname, email, phonenumber) VALUES('tdavis', '1234', 'Tanner', 'Davis','tdavis@test.com', '1234567891');

  INSERT INTO gaming_db.products(productName, productDescription, productQuantity, productPrice) VALUES('Xbox Controller', 'Xbox One Controller', 25, 60.30);
  INSERT INTO gaming_db.products(productName, productDescription, productQuantity, productPrice) VALUES('Xbox One Console', 'The Xbox One is an eighth-generation home video game console developed by Microsoft.', 42, 229.99);
  
  SELECT * FROM gaming_db.products;
