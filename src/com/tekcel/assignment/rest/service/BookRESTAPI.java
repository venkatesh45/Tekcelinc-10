package com.tekcel.assignment.rest.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tekcel.assignment.endpoint.Endpoints;
import com.tekcel.assignment.pojo.Book;

@Controller
public class BookRESTAPI {

	@RequestMapping(value = Endpoints.INSERT, method = RequestMethod.POST)
	public @ResponseBody void createBook(@RequestBody Book b) throws SQLException {

		BookDAOImplREST restImp = new BookDAOImplREST();

		restImp.createBook(b);

	}

	@RequestMapping(value = Endpoints.GetAll, method = RequestMethod.GET)
	public @ResponseBody List<Book> readBook() throws SQLException {
		
		BookDAOImplREST restImp = new BookDAOImplREST();
		
		return restImp.readBook();
	}

	@RequestMapping(value = Endpoints.GetByID, method = RequestMethod.GET)
	public @ResponseBody Book readBook(@PathVariable("id") int bid) throws SQLException {
		
		BookDAOImplREST restImp = new BookDAOImplREST();
		
		return restImp.readBook(bid);
	}

	@RequestMapping(value = Endpoints.UpdateByID, method = RequestMethod.POST)
	public @ResponseBody int updateBook(@RequestBody Book b) throws SQLException {
		
		BookDAOImplREST restImp = new BookDAOImplREST();
		
		return restImp.updateBook(b);
	}

	@RequestMapping(value = Endpoints.DeleteByID, method = RequestMethod.GET)
	public @ResponseBody int deleteBook(@PathVariable("id") int bid) throws SQLException {
		
		BookDAOImplREST restImp = new BookDAOImplREST();
		
		return restImp.deleteBook(bid);
	}
}
