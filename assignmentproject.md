Problem Statement
	
VisitorTrackingApplication 
	1. would contain an model class as Visitor(entity unique id, name,unique key emailid, 
											visit date, purpose of visit , whom to meet)
	2. develop a service and dao layer for that implement crud operations 
	3. application requirement filter the visitors (whom to meet, visit date, whom to meet on specific date)
	4. my application should be able to find totalvisitors (purpose, visit date and whom to meet)
	5. my application should be able to sort the visitors by any criteria (by lambda and streams)
	6. every sql query and other property should be read from properties file
		
Instruction:
	1. follow naming convetion
	2. follow appropriate package structure
	3. create appropriate custom exception and throw them whenever needed
	4. best practices in daoimpl


rq5xqzx - classroom code for sharing the project


CREATE TABLE tbl_visitorbook (
	id INTEGER PRIMARY KEY,
	name VARCHAR(50),
	emailid VARCHAR(50) UNIQUE,
	visitdate DATE,
	purpose VARCHAR(50),
	whomtomeet VARCHAR(50) 
	
);
