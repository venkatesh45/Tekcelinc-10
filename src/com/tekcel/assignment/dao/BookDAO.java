package com.tekcel.assignment.dao;

import java.sql.SQLException;
import java.util.List;

import com.tekcel.assignment.pojo.Book;

public interface BookDAO {

	public void createBook(Book b) throws SQLException;
	public List<Book> readBook() throws SQLException;
	public Book readBook(int bid) throws SQLException;
	public int updateBook(Book b) throws SQLException;
	public int deleteBook(int bid) throws SQLException;
}
