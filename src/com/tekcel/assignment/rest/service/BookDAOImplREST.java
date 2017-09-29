package com.tekcel.assignment.rest.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.tekcel.assignment.dao.BookDAO;
import com.tekcel.assignment.pojo.Book;
import com.tekcel.assignment.spring.DBConnectionDBCP;

@Service
public class BookDAOImplREST implements BookDAO {

	JdbcTemplate jdbcTemplate = DBConnectionDBCP.getJdbcTemplate();

	@Override
	public void createBook(Book b) throws SQLException {

		final String sqlStatement = "INSERT INTO BOOK VALUES(?,?,?,?)";

		jdbcTemplate.update(sqlStatement,
				new Object[] { b.getBookId(), b.getAuthor(), b.getBookName(), b.getCategory() });
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

		final String sqlStatement = "SELECT * FROM BOOK WHERE id=?";

		List<Book> listOfBooks = jdbcTemplate.query(sqlStatement, new Object[] { bid }, new RowMapper<Book>() {

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

		if (listOfBooks.isEmpty())
			return null;

		return listOfBooks.get(0);

	}

	@Override
	public int updateBook(Book b) throws SQLException {

		final String sqlStatement = "UPDATE BOOK SET author=?, bookname=?, category=? WHERE id=?";

		return jdbcTemplate.update(sqlStatement,
				new Object[] { b.getAuthor(), b.getBookName(), b.getCategory(), b.getBookId() });
	}

	@Override
	public int deleteBook(int bid) throws SQLException {

		String sqlStatement = "DELETE FROM BOOK WHERE id=?";

		return jdbcTemplate.update(sqlStatement, new Object[] { bid });
	}

}
