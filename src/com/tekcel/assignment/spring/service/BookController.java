package com.tekcel.assignment.spring.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tekcel.assignment.pojo.Book;
import com.tekcel.assignment.pojo.Person;
import com.tekcel.assignment.spring.BookDAOImpl;
import com.tekcel.assignment.spring.SubmitDAOImplSpring;

@Controller
public class BookController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startUp() throws SQLException {

		return "index";

	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() throws SQLException {

		return "index";

	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(Person person, Model model) {

		String username = person.getUsername();
		String password = person.getPassword();

		System.out.println("Username:" + username + " Password:" + password);

		SubmitDAOImplSpring daoimpl = new SubmitDAOImplSpring();

		if (daoimpl.checkAuth(username, password)) {
			model.addAttribute("username", username);
			return "welcome";
		} else {
			return "index";
		}
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value="/browse", method=RequestMethod.GET)
	public String browse(Model model) throws SQLException{
		
		BookDAOImpl bookDAOImpl=new BookDAOImpl();
		
		model.addAttribute("listOfBooks", bookDAOImpl.readBook());
		
		return "browse";
	}
	
	@RequestMapping(value="/select", method=RequestMethod.POST)
	public String select(ServletRequest request,HttpSession session) throws SQLException{
		
		BookDAOImpl bookDAOImpl=new BookDAOImpl();
		List<Book> listOfBooks=bookDAOImpl.readBook();
		
		String[] selected = request.getParameterValues("selectedbooks");
		List<Book> selectedBooks = new ArrayList<Book>();
		if (selected != null && selected.length != 0) {
			for (int i = 0; i < selected.length; i++) {
				int j = Integer.parseInt(selected[i]);
				selectedBooks.add(listOfBooks.get(j - 1));
			}
		}

		session.setAttribute("selectedBooks", selectedBooks);
			
		return "browse";
	}
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String cart(){
		return "cart";
	}
}
