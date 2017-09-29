<%@page import="com.tekcel.assignment.jdbc.BookDAOImplJDBC"%>
<%@page import="com.tekcel.assignment.pojo.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Book> listOfBooks = (new BookDAOImplJDBC()).readBook();
		request.setAttribute("listOfBooks", listOfBooks);
	%>
	<form action="browse.jsp" method="post">
		<table border="2">
			<tr>
				<th>bookId</th>
				<th>author</th>
				<th>bookName</th>
				<th>category</th>
				<th></th>
			</tr>
			<c:forEach items="${requestScope.listOfBooks}" var="listOfBooks">

				<tr>
					<td>${listOfBooks.bookId}</td>
					<td>${listOfBooks.getAuthor()}</td>
					<td>${listOfBooks.bookName}</td>
					<td>${listOfBooks.category}</td>
					<td><input type="checkbox" name="selectedbooks"
						value="${listOfBooks.bookId}"></td>
				</tr>


			</c:forEach>

		</table>
		<input type="submit" name="" value="select" />
	</form>

	<a href="cart.jsp"><input type="button" value="checkout" /></a>

	<a href="index.html"><input type="button" value="logout"></a>

	<%
		
		String[] selected = request.getParameterValues("selectedbooks");
		List<Book> selectedBooks = new ArrayList<Book>();
		if (selected != null && selected.length != 0) {
			for (int i = 0; i < selected.length; i++) {
				int j = Integer.parseInt(selected[i]);
				selectedBooks.add(listOfBooks.get(j - 1));
			}
		}

		session.setAttribute("selectedBooks", selectedBooks);
	%>
</body>
</html>