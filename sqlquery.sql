create table userEntity(
	id serial,
	firstName varchar(40) not null,
	lastName varchar(40) not null,
	gender varchar(15) not null,
	age smallint not null,
	phoneNumber BIGINT PRIMARY key,
	email varchar(50) not null,
	userName varchar(40) not null,
	password varchar(20) not null,
 	roleType varchar(20)  null		
);