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
import com.training.model.Books;
public class ViewBook implements Command
{
	@Override
	public String execute(Map<String, String> map,HttpServletRequest request) {
		Connection con = null;
		List<Books> bookList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String bookId=null;
		try {
			con = Constants.DB.getDbConnection();
			bookId = map.get("id");
			
			preparedStatement = con.prepareStatement(Constants.BOOK_ENTITY_BY_ID);
			preparedStatement.setString(1, bookId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
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
		}request.setAttribute(Constants.EMPLOYEE_ID, bookId);
		 request.setAttribute(Constants.LIST, bookList);
		 return Constants.SUCCESS;
	}
}
