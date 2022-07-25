package com.training.iface;

import com.connectionPool.DbConnection;

public interface Constants {

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String URI_PATH = "uriPath";
	public static final String LIST = "list";
	public static final String MESSAGE = "message";
	public static final String EMPLOYEE_ID = "employeeId";
	public static final String ROLE_TYPE = "roleType";
	public static final String EMPLOYEE_NAME = "employeeName";
	public static final String PASSWORD="password";
	public static final String LEAVE_OBJECT = "leave";
	public static final DbConnection DB=new DbConnection();
	public static final String INSERT_EMP_ENTITY = "insert into user_entity (employee_id, first_name, last_name, gender, \n"
			+ "					age, address_line_1, address_line_2, city, state, country, pincode, \n"
			+ "					phone_number, email_id, password, role_type, manager_id)"
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SELECT_BY_EMP_ID = "select * from user_entity where employee_id=?";
	public static final String DB_EMPLOYEE_ID = "employee_id";
	public static final String DB_FIRST_NAME= "first_name";
	public static final String DB_LAST_NAME = "last_name";
	public static final String DB_PASSWORD = "password";
	public static final String DB_ROLE_TYPE = "role_type";
	public static final String INSERT_LEAVE_ENTITY="insert into leave_entity (employee_id, employee_name,from_date,to_date"
			+ ",reason, manager_id,status) values(?,?,?,?,?,?,?)";
	public static final String LEAVE_ENTITY_BY_ID = "Select * from leave_entity where employee_id=?";
	public static final String SELECT_ALL_BOOK_ENTITY ="Select * from books";
	public static final String SELECT_ALL_VIDEO_ENTITY ="Select * from videos";
	public static final String BOOK_ENTITY_BY_ID = "Select * from books where book_id=?";
	public static final String VIDEO_ENTITY_BY_ID = "Select * from videos where video_id=?";
	public static final String VIEW_EMP_BY_MANAGER_ID = "Select * from user_entity where manager_id=?";
	public static final String VIEW_LEAVE_ENTITY_BY_MANAGER_ID ="Select * from leave_entity where status is null and manager_id=?";
	public static final String VIEW_LEAVE_ENTITY_BY_SERIAL_NO ="Select * from leave_entity where serial_no=?";
	public static final String UPDATE_LEAVE_STATUS ="update leave_entity set status =? where serial_no=?";
	
	
}
