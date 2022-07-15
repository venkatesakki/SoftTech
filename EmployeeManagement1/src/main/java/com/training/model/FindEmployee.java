package com.training.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connectionPool.BasicConnectionPool;

public class FindEmployee 
{
	static Connection con = null;
	static BasicConnectionPool bc = null;
	static Employee emp = null;
	public static Employee find(String employee_id) 
	  { 
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			System.out.println("add====" + con);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			String sql = "select * from user_entity where employee_id=?";
			try (PreparedStatement pstm = con.prepareStatement(sql);) {
				pstm.setString(1, employee_id);
				ResultSet rs = pstm.executeQuery();
				if (rs.next()) {
					String employeeId = rs.getString("employee_id");
					String password = rs.getString("password");
					String roleType=rs.getString("role_type");

					emp = new Employee(employeeId, password,roleType);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
	  
	  return emp; }
}
