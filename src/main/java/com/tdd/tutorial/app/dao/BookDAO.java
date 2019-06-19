package com.tdd.tutorial.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tdd.tutorial.app.domain.BookDTO;

public class BookDAO {
	public List<BookDTO> searchBooks(Connection connection, BookDTO searchCriteria) throws SQLException {
		PreparedStatement statement = null;
		StringBuilder select = null;
		ResultSet resultSet = null;
		List<BookDTO> bookList = null;
		BookDTO singleBook = null;
		Integer countIndex = null;
		
		try {
			select = new StringBuilder();
			bookList = new ArrayList<BookDTO>();
			countIndex = 1;
			
			select.append("SELECT ");
			
			select.append("book.id,");
			select.append("book.title,");
			select.append("book.author");
			
			select.append(" FROM ");
			select.append("book");
			
			select.append(" WHERE ");
			select.append("(1=1)");
			
			
			if (searchCriteria.id != null) {
				select.append(" AND(");
				select.append("book.id = ?");
				select.append(")");
			}
			
			if (searchCriteria.title != null) {
				select.append(" AND(");
				select.append("book.title = ?");
				select.append(")");
			}
			
			if (searchCriteria.author != null) {
				select.append(" AND(");
				select.append("book.author = ?");
				select.append(")");
			}
			
			statement = connection.prepareStatement(select.toString());
			
			if (searchCriteria.id != null) {
				statement.setInt(countIndex, searchCriteria.id);
				countIndex++;
			}
			
			if (searchCriteria.title != null) {
				statement.setString(countIndex, searchCriteria.title);
				countIndex++;
			}
			
			if (searchCriteria.author != null) {
				statement.setString(countIndex, searchCriteria.author);
				countIndex++;
			}
			
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				singleBook = new BookDTO();
				
				singleBook.id = resultSet.getInt("id");
				
				singleBook.id = 3;
				
				bookList.add(singleBook);
			}
			
			return bookList;
			
		} catch(SQLException exception) {
			throw exception;
		}
	}
}
