package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constants;
import com.training.model.Videos;

public class VideoList implements Command
{
	@Override
	public String execute(Map<String, String> map,HttpServletRequest request){
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Videos> videoList = new ArrayList<>();
		try {
			con = Constants.DB.getDbConnection();
			preparedStatement = con.prepareStatement(Constants.SELECT_ALL_VIDEO_ENTITY);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String videoId=resultSet.getString("video_id");
				String videoName = resultSet.getString("video_name");
				int durationInMin = resultSet.getInt("duration_in_min");
				int durationInSec = resultSet.getInt("duration_in_sec");
				String url = resultSet.getString("url");
				Videos video=new Videos(videoId, videoName, durationInMin, durationInSec, url);
				videoList.add(video);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(resultSet!=null) {
					resultSet.close();
				}if(preparedStatement!=null){
					preparedStatement.close();
				}if(con!=null){
					Constants.DB.releaseDbConnection(con);
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}request.setAttribute(Constants.LIST, videoList);
		 return Constants.SUCCESS;
	}
}
