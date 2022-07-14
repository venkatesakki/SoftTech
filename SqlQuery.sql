create table user_entity(
	employee_id varchar(10) PRIMARY key,
	first_name varchar(40) not null,
	last_name varchar(40) not null,
	gender varchar(15) not null,
	age smallint not null,
	address_line_1 varchar(100) not null,
	address_line_2 varchar(100)  null,
	city varchar(50) not null,
	state varchar(50) not null,
	country varchar(50) not null,
	pincode int not null,
	phone_number NUMERIC(10) not null,
	email_id varchar(50) not null,
    password varchar(20) not null,
 	role_type varchar(20) not null,
	manager_id varchar(10) null,
	FOREIGN key(manager_id)
	REFERENCES user_entity(employee_id)
);

select * from user_entity;
insert into user_entity
values('STech-02','bala','R','Male',25,'balaji nagar',null,'chennai','tamilnadu',
	   'india',631001,1234567891,'bala@gmail.com',
	   'bala@123','employee','STech-01')
select * from user_entity where manager_id='STech-01'



create table books(

    book_id varchar(4) PRIMARY key,	
	book_name varchar(25) not null,
	author_name varchar(20) not null,
	publisher_name varchar(25) not null,
	no_of_pages int not null,
	price DOUBLE PRECISION not null,
	language varchar(2) not null,
	rating varchar(6) not null	
);
select * from books;

insert into books VALUES('bk-1','Ponniyin selvan','Kalki','LKM Publiction'
						 ,1708,430.00,'ta','4.5/5');
,('bk-2','Aram','Jeyamohan','JK Publiction'
						 ,520,450.00,'ta','4.2/5');
,('bk-3','Harry Potter','Robert j.Drowney','HP Publiction'
	                     ,852,1250.00,'en','4.3/5');



create table videos(
	
	video_id varchar(4) primary key,
	video_name varchar(25) not null,
	duration varchar(8) not null,
	url varchar(50) not null	
);
select * from videos

drop table videos

insert into videos VALUES('v-1','codeEvolution','01:20','https://www.youtube.com/watch?v=YiYtwbnPfkY')
,('v-2','9Exception','00:55','https://www.youtube.com/watch?v=1f6GOjT_zsc')
,('v-3','Questpond','00:42:26','https://www.youtube.com/watch?v=Zb4dPi7CANU')