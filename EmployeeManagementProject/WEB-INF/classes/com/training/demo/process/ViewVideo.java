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

public class ViewVideo implements Command {
	@Override
	public String execute(Map<String, String> map,HttpServletRequest request){
		Connection con = null;
		List<Videos> videoList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String videoId=null;
		try {
			con = Constants.DB.getDbConnection();
			videoId = map.get("id");
			preparedStatement = con.prepareStatement(Constants.VIDEO_ENTITY_BY_ID);
			preparedStatement.setString(1, videoId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String videoName = resultSet.getString("video_name");
				int durationMin = resultSet.getInt("duration_in_min");
				int durationSec = resultSet.getInt("duration_in_sec");
				String url = resultSet.getString("url");
				Videos video=new Videos(videoId, videoName, durationMin, durationSec, url);
				videoList.add(video);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
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
		}request.setAttribute(Constants.EMPLOYEE_ID, videoId);
		 request.setAttribute(Constants.LIST, videoList);
		 return Constants.SUCCESS;
	}
}
