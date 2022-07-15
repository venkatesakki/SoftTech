create table user_entity(
	employee_id varchar(10) PRIMARY key,
	first_name varchar(40) not null,
	last_name varchar(40) not null,
	gender varchar(15) not null,
	age smallint not null,
	address_line_1 varchar(250) not null,
	address_line_2 varchar(250)  null,
	city varchar(50) not null,
	state varchar(50) not null,
	country varchar(50) not null,
	pincode int not null,
	phone_number NUMERIC(10) not null,
	email_id varchar(150) not null,
    password varchar(20) not null,
 	role_type varchar(20) not null,
	manager_id varchar(10) null,
	FOREIGN key(manager_id)
	REFERENCES user_entity(employee_id)
);
create table books(

    book_id varchar(10) PRIMARY key,	
	book_name varchar(200) not null,
	author_name varchar(50) not null,
	publisher_name varchar(250) not null,
	no_of_pages int not null,
	price DOUBLE PRECISION not null,
	language varchar(2) not null,
	rating varchar(6) not null	
);
drop table user_entity
create table videos(
	
	video_id varchar(10) primary key,
	video_name varchar(250) not null,
	duration_in_min smallint not null,
    duration_in_sec smallint not null,
	url varchar(500) not null	
);