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
import com.training.model.Books;

public class BookList implements Command{
	@Override
	public Map<String, Object> execute(Map<String, String> map,HttpServletRequest request) 
	{
		Connection con = null;
		  try { 
			  System.out.println("ConsDb^&*(%$#^"+Constant.db.toString());
				con = Constant.db.getDbConnection();
		  System.out.println("add====" + con); 
		  } catch (SQLException e1) {
		  e1.printStackTrace(); }
		Map<String, Object> resultMap = new HashMap<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Books> booksList = new ArrayList<>();
		String uri = "success";
		resultMap.put(Constant.uriPath, uri);
		
		try {
			preparedStatement = con.prepareStatement(Constant.selectAllBooksEntity);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) 
			{
				String bookId=resultSet.getString("book_id");
				String bookName = resultSet.getString("book_name");
				String authourName=resultSet.getString("author_name");
				String publisherName = resultSet.getString("publisher_name");
				int noOfPages = resultSet.getInt("no_of_pages");
				double price = resultSet.getDouble("price");
				String language = resultSet.getString("language");
				String ratings = resultSet.getString("rating");
				Books book=new Books(bookId, bookName, authourName, publisherName,
						noOfPages, price, language, ratings);
				booksList.add(book);
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
		resultMap.put(Constant.list, booksList);
		request.setAttribute(Constant.list, resultMap.get(Constant.list));
		return resultMap;
	}
}
