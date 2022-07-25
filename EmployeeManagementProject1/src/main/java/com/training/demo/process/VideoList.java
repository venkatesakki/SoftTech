package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.Videos;

public class VideoList implements Command
{
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) 
	{
		Connection con = null;
		
		Map<String, Object> resultMap = new HashMap<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Videos> videoList = new ArrayList<>();
		try {
			 System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
				con = Constant.db.getDbConnection();
			System.out.println("add====" + con);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String uri = "success";
		resultMap.put(Constant.uriPath, uri);
		
		try {
			preparedStatement = con.prepareStatement(Constant.selectAllVideosEntity);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) 
			{
				String videoId=resultSet.getString("video_id");
				String videoName = resultSet.getString("video_name");
				int durationInMin = resultSet.getInt("duration_in_min");
				int durationInSec = resultSet.getInt("duration_in_sec");
				String url = resultSet.getString("url");
				Videos video=new Videos(videoId, videoName, durationInMin, durationInSec, url);
				videoList.add(video);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(con!=null) {
					Constant.db.releaseDbConnection(con);
					con.close();
				}if(preparedStatement!=null) {
					preparedStatement.close();
				}if(resultSet!=null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resultMap.put(Constant.list, videoList);
		request.setAttribute(Constant.list, resultMap.get(Constant.list));
		return resultMap;
	}
	
}
