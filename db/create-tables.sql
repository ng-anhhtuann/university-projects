-- Create tables to database --
SELECT * FROM library;
CREATE TABLE publishers( publisherid INT PRIMARY KEY NOT NULL, publishername VARCHAR(50) NOT NULL, publisherphone VARCHAR(20) NOT NULL);
CREATE TABLE books( bookid INT PRIMARY KEY NOT NULL, publisherid INT NOT NULL, booktitle VARCHAR(50) NOT NULL, bookprice INT, borrowprice INT , buyer INT, borrower INT, daycanborrow INT, dayborrowleft INT);
CREATE TABLE users( userid INT PRIMARY KEY NOT NULL, username VARCHAR(50) NOT NULL,userphone VARCHAR(20) NOT NULL, useraddress VARCHAR(50) NOT NULL, usernumberborrow INT NOT NULL, usernumberbuy INT NOT NULL, userbuyamount INT, userborrowamount INT , userborrowing INT);
 