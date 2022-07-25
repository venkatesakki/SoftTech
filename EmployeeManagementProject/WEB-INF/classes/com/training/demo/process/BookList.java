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

public class BookList implements Command{
	@Override
	public String execute(Map<String, String> map,HttpServletRequest request) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Books> booksList = new ArrayList<>();
		try { 
			con = Constants.DB.getDbConnection();
			preparedStatement = con.prepareStatement(Constants.SELECT_ALL_BOOK_ENTITY);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
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
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}if(preparedStatement!=null) {
					preparedStatement.close();
				}if(con!=null) {
					Constants.DB.releaseDbConnection(con);
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		 request.setAttribute(Constants.LIST, booksList);
		 return Constants.SUCCESS;
	}
}
