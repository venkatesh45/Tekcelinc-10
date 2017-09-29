package com.tekcel.assignment.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tekcel.assignment.dao.BookDAO;
import com.tekcel.assignment.pojo.Book;

public class BookDAOImpl implements BookDAO{

	JdbcTemplate jdbcTemplate=DBConnectionDBCP.getJdbcTemplate();

	@Override
	public void createBook(Book b) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> readBook() throws SQLException {
		final String sqlStatement = "SELECT * FROM BOOK";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book b = new Book();
				b.setBookId(rs.getInt("id"));
				b.setAuthor(rs.getString("author"));
				b.setBookName(rs.getString("bookname"));
				b.setCategory(rs.getString("category"));
				return b;
			}

		});
	}

	@Override
	public Book readBook(int bid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBook(Book b) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBook(int bid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
