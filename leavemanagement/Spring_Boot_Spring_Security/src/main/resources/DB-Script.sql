create database lms;
use lms;
create table user(id INT,userName VARCHAR(50) NOT NULL,password VARCHAR(20),passwordConfirm VARCHAR(20) NOT NULL,PRIMARY KEY(id));
create table role(role_id INT,name VARCHAR(255));
create table leaveDetails(id INT NOT NULL, userName VARCHAR(50) NOT NULL,fromDate DATE NOT NULL, toDate DATE NOT NULL, leaveType VARCHAR(30) NOT NULL, acceptRjectFlag BOOLEAN,status VARCHAR(50), PRIMARY KEY(id));
insert into user(id,userName,password,passwordConfirm) values (1,'Arti','Arthi@123','Arthi@123');
insert into user(id,userName,password,passwordConfirm) values (2,'Reshmi','Resh@123','Resh@123');
insert into role(role_id,name) values (1,'Employee');
insert into role(role_id,name) values (2,'RM');
