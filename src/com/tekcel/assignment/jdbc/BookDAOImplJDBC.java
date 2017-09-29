package com.tekcel.assignment.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekcel.assignment.dao.BookDAO;
import com.tekcel.assignment.pojo.Book;

@Controller
public class BookDAOImplJDBC implements BookDAO {

	Connection conn = DBConnectionJDBC.getInstance();

	@Override
	public void createBook(Book b) throws SQLException {

		PreparedStatement ps;
		ps = conn.prepareStatement("INSERT INTO BOOK VALUES(?,?,?,?)");
		ps.setInt(1, b.getBookId());
		ps.setString(2, b.getAuthor());
		ps.setString(3, b.getBookName());
		ps.setString(4, b.getCategory());

		ps.executeUpdate();
	}

	@Override
	public List<Book> readBook() throws SQLException {

		List<Book> listOfBooks = new ArrayList<Book>();

		Statement selectBooks = conn.createStatement();
		String stmt = "SELECT * FROM BOOK";

		ResultSet rs = selectBooks.executeQuery(stmt);

		while (rs.next()) {
			listOfBooks.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		return listOfBooks;
	}

	@Override
	public Book readBook(int bid) throws SQLException {

		PreparedStatement ps = null;
		ps = conn.prepareStatement("SELECT * FROM BOOK WHERE id=?");

		ps.setInt(1, bid);

		ResultSet rs = ps.executeQuery();
		Book b = null;

		while (rs.next())
			b = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

		return b;
	}

	@Override
	public int updateBook(Book b) throws SQLException {

		PreparedStatement ps = null;

		ps = conn.prepareStatement("UPDATE BOOK SET author=?, bookname=?, category=? where id=?");

		ps.setString(1, b.getAuthor());
		ps.setString(2, b.getBookName());
		ps.setString(3, b.getCategory());
		ps.setInt(4, b.getBookId());

		return ps.executeUpdate();
	}

	@Override
	public int deleteBook(int bid) throws SQLException {

		PreparedStatement ps = null;

		ps = conn.prepareStatement("DELETE FROM BOOK WHERE id=?");

		ps.setInt(1, bid);

		return ps.executeUpdate();
	}
}
