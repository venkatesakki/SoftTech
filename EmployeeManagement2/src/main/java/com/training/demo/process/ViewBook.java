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
import com.training.model.Books;
import com.training.model.Employee;
public class ViewBook implements Command
{
	Connection con = null;
	BasicConnectionPool bc = null;
	Employee emp = null;
	Map<String, Object> map2 = new HashMap<>();
	List<Books> list = new ArrayList<>();
	
	@Override
	public Map<String, Object> execute(Map<String, String> map) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			bc = BasicConnectionPool.create("jdbc:postgresql://localhost:5432/vastpro", "postgres", "postgres");
			con = bc.getConnection();
			String bookId = map.get("id");
			map2.put(Constant.employeeId, bookId);
			String uri = "book.jsp";
			map2.put(Constant.uriPath, uri);
			
			
			String sql = "Select * from books where book_id=?";
			
			try {
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, bookId);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) 
				{
					//String Id = resultSet.getString("book_id");
					String bookName = resultSet.getString("book_name");
					String authorName = resultSet.getString("author_name");
					String publisherName = resultSet.getString("publisher_name");
					int noOfPages = resultSet.getInt("no_of_pages");
					double price = resultSet.getDouble("price");
					String language = resultSet.getString("language");
					String rating = resultSet.getString("rating");
					Books book=new Books(bookId, bookName, authorName, publisherName,
							noOfPages,price, language, rating);
					list.add(book);
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
