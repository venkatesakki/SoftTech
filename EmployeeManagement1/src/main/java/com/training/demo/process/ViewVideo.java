package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.connectionPool.BasicConnectionPool;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.Employee;
import com.training.model.Videos;

public class ViewVideo implements Command {

	Connection con = null;
	BasicConnectionPool bc = null;
	Employee emp = null;
	Map<String, Object> map2 = new HashMap<>();
	List<Videos> list = new ArrayList<>();
	
	@Override
	public Map<String, Object> execute(Map<String, String> map) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			String videoId = map.get("id");
			map2.put(Constant.employeeId, videoId);
			String uri = "video.jsp";
			map2.put(Constant.uriPath, uri);
			
			
			String sql = "Select * from videos where video_id=?";
			
			try {
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, videoId);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) 
				{
					String Id = resultSet.getString("video_id");
					String videoName = resultSet.getString("video_name");
					int durationMin = resultSet.getInt("duration_in_min");
					int durationSec = resultSet.getInt("duration_in_sec");
					String url = resultSet.getString("url");
					Videos video=new Videos(videoId, videoName, durationMin, durationSec, url);
					list.add(video);
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				preparedStatement.close();
				con.close();
				resultSet.close();
				bc.releaseConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			map2.put(Constant.list, list);
			return map2;
	}

}
