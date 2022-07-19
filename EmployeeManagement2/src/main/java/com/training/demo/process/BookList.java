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
import com.training.model.Books;

public class BookList implements Command
{
	Connection con = null;
	BasicConnectionPool bc = null;
	Map<String, Object> map2 = new HashMap<>();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	List<Books> list = new ArrayList<>();
	
	@Override
	public Map<String, Object> execute(Map<String, String> map) {
		
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			System.out.println("add====" + con);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String uri = "bookList.jsp";
		map2.put(Constant.uriPath, uri);
		String sql = "Select * from books";
		
		try {
			preparedStatement = con.prepareStatement(sql);
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
				list.add(book);
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
