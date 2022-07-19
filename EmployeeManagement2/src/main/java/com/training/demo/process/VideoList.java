package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.connectionPool.BasicConnectionPool;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.Videos;

public class VideoList implements Command
{

	Connection con = null;
	BasicConnectionPool bc = null;
	Map<String, Object> map2 = new HashMap<>();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	List<Videos> list = new ArrayList<>();
	
	@Override
	public Map<String, Object> execute(Map<String, String> map) {
		
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			System.out.println("add====" + con);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String uri = "videosList.jsp";
		map2.put(Constant.uriPath, uri);
		String sql = "Select * from videos";
		
		try {
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) 
			{
				String videoId=resultSet.getString("video_id");
				String videoName = resultSet.getString("video_name");
				int durationInMin = resultSet.getInt("duration_in_min");
				int durationInSec = resultSet.getInt("duration_in_sec");
				String url = resultSet.getString("url");
				Videos video=new Videos(videoId, videoName, durationInMin, durationInSec, url);
				list.add(video);
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
