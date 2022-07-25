package com.training.iface;

import com.connectionPool.DbConnection;

public interface Constant {

	public static final String uriPath = "uriPath";
	public static final String list = "list";
	public static final String message = "message";
	public static final String employeeId = "employeeId";
	public static final String roleType = "roleType";
	public static final String employeeName = "employeeName";
	public static final String password="password";
	public static final String leaveObject = "leave";
	public static final DbConnection db=new DbConnection();
	public static final String insertEmpEntity = "insert into user_entity (employee_id, first_name, last_name, gender, \n"
			+ "					age, address_line_1, address_line_2, city, state, country, pincode, \n"
			+ "					phone_number, email_id, password, role_type, manager_id)"
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String selectByEmployeeId = "select * from user_entity where employee_id=?";
	public static final String dbEmployeeId = "employee_id";
	public static final String dbFirstName= "first_name";
	public static final String dbLastName = "last_name";
	public static final String dbpassword = "password";
	public static final String dbRoleType = "role_type";
	public static final String insertLeaveEntity="insert into leave_entity (employee_id, employee_name,from_date,to_date"
			+ ",reason, manager_id,status) values(?,?,?,?,?,?,?)";
	public static final String leaveEntityById = "Select * from leave_entity where employee_id=?";
	public static final String selectAllBooksEntity ="Select * from books";
	public static final String selectAllVideosEntity ="Select * from videos";
	public static final String bookEntityById = "Select * from books where book_id=?";
	public static final String videoEntityById = "Select * from videos where video_id=?";
	public static final String viewEmployeeBymanagerId = "Select * from user_entity where manager_id=?";
	public static final String viewleaveEntityBymanagerId ="Select * from leave_entity where status is null and manager_id=?";
	public static final String viewleaveEntityBySerialNo ="Select * from leave_entity where serial_no=?";
	public static final String updateleaveStatus ="update leave_entity set status =? where serial_no=?";
	
	
}
