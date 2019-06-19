package com.tdd.tutorial.tdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tdd.tutorial.app.dao.BookDAO;
import com.tdd.tutorial.app.domain.BookDTO;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookDAOTest {
	@Mock
	private Connection connection;
	
	@Mock
	private ResultSet resultSet;
	
	@Mock
	private PreparedStatement preparedStatement;
	
	@InjectMocks
	private BookDAO bookDAO;
	
	private static BookDAOTestHelper DAOHelper;

	@BeforeAll
	public static void setUpClass() {
		DAOHelper = new BookDAOTestHelper();
	}

	@BeforeEach
	public void setUpMocks() throws Exception {
		this.initializeMockSearchBookWithId1();
	}

	@Test
	@Disabled
	public void searchBookWithId1() throws SQLException {
		List<BookDTO> bookInstance = null;
		
		
		bookInstance = this.bookDAO.searchBooks(connection, DAOHelper.getBookWithId1());
		assertTrue(bookInstance != null);
		assertTrue(bookInstance.size() == 1);
	};

	private void initializeMockSearchBookWithId1() throws Exception {
	StringBuilder selectSql = new StringBuilder();
	selectSql.append("SELECT book.id,book.title,book.author FROM book WHERE (1=1) AND(book.id = ?)");
	
	/**Mocking preparedStatement*/
	when(this.connection.prepareStatement(selectSql.toString()))
	.thenReturn(this.preparedStatement);
	
	/** Mocking the executionQuery
	*/
	when(this.preparedStatement.executeQuery())
	.thenReturn(this.resultSet);
	
	/** Mocking the resultSet Iterator
	*/
	when(this.resultSet.next())
	.thenReturn(true)
	.thenReturn(false);
	
	/** Mocking the resultSet parameters
	*/
	when(this.resultSet.getInt("id"))
	.thenReturn(DAOHelper.getBookWithId1().id);
	}
}
