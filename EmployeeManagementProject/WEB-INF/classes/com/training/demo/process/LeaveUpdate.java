package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constants;

public class LeaveUpdate implements Command
{
	@Override
	public String execute(Map<String, String> map,HttpServletRequest request) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try {
			con = Constants.DB.getDbConnection();
		    int serialNum = Integer.parseInt(map.get("serialNo"));
		    String status=map.get("status");
			preparedStatement = con.prepareStatement(Constants.UPDATE_LEAVE_STATUS);
			int update=0;
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, serialNum);
			update=preparedStatement.executeUpdate();
			if(update > 0) {
				return Constants.SUCCESS;
			}
			else {
				 return Constants.ERROR;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(preparedStatement!=null) {
					preparedStatement.close();
				}if(con!=null){
					Constants.DB.releaseDbConnection(con);
				}
			} catch (SQLException e){
				e.printStackTrace();
			}
		}return null;
	}
}
