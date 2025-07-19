-- Create the database
CREATE DATABASE IF NOT EXISTS databasedb;

-- Use the database
USE databasedb;

-- Create the fans table
CREATE TABLE IF NOT EXISTS fans (
    ID INT PRIMARY KEY,
    firstname VARCHAR(25),
    lastname VARCHAR(25),
    favoriteteam VARCHAR(25)
);

-- Add sample data
INSERT INTO fans (ID, firstname, lastname, favoriteteam) VALUES
(1, 'John', 'Doe', 'Yankees'),
(2, 'Jane', 'Smith', 'Lakers'),
(3, 'Mike', 'Brown', 'Patriots'),
(4, 'Emily', 'Johnson', 'Celtics'),
(5, 'Chris', 'Davis', 'Warriors'),
(6, 'Amanda', 'Wilson', 'Red Sox'),
(7, 'Robert', 'Martinez', 'Mets'),
(8, 'Sophia', 'Garcia', 'Dodgers'),
(9, 'David', 'Lopez', 'Giants'),
(10, 'Olivia', 'Clark', 'Bulls'),
(11, 'James', 'Rodriguez', 'Heat'),
(12, 'Isabella', 'Lewis', 'Knicks'),
(13, 'Daniel', 'Walker', 'Packers'),
(14, 'Mia', 'Hall', 'Seahawks'),
(15, 'Matthew', 'Allen', 'Broncos'),
(16, 'Ella', 'Young', 'Eagles'),
(17, 'Joseph', 'Hernandez', 'Cubs'),
(18, 'Ava', 'King', 'Spurs'),
(19, 'Andrew', 'Wright', 'Raiders'),
(20, 'Charlotte', 'Scott', 'Chiefs');

-- Create the student1 user if not exists and grant privileges
CREATE USER IF NOT EXISTS 'student1'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON databasedb.* TO 'student1'@'localhost';
FLUSH PRIVILEGES;