package com.training.demo.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.training.iface.Command;
import com.training.iface.Constant;
import com.training.model.Books;
public class ViewBook implements Command
{
	
	
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) 
	{
		Connection con = null;
		Map<String, Object> resultMap = new HashMap<>();
		List<Books> bookList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			 System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
				con = Constant.db.getDbConnection();
			String bookId = map.get("id");
			resultMap.put(Constant.employeeId, bookId);
			String uri = "success";
			resultMap.put(Constant.uriPath, uri);
			
			try {
				preparedStatement = con.prepareStatement(Constant.bookEntityById);
				preparedStatement.setString(1, bookId);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) 
				{
					String bookName = resultSet.getString("book_name");
					String authorName = resultSet.getString("author_name");
					String publisherName = resultSet.getString("publisher_name");
					int noOfPages = resultSet.getInt("no_of_pages");
					double price = resultSet.getDouble("price");
					String language = resultSet.getString("language");
					String rating = resultSet.getString("rating");
					Books book=new Books(bookId, bookName, authorName, publisherName,
							noOfPages,price, language, rating);
					bookList.add(book);
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
		{try {
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
		
			resultMap.put(Constant.list, bookList);
			request.setAttribute(Constant.list, resultMap.get(Constant.list));
			return resultMap;
	}

}
