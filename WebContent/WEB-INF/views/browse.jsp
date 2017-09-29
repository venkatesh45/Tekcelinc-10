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

	<form action="${pageContext.request.contextPath}/select" method="post">
		<table border="2">
			<tr>
				<th>bookId</th>
				<th>author</th>
				<th>bookName</th>
				<th>category</th>
				<th></th>
			</tr>
			<c:forEach items="${listOfBooks}" var="listOfBooks">

				<tr>
					<td>${listOfBooks.getBookId()}</td>
					<td>${listOfBooks.getAuthor()}</td>
					<td>${listOfBooks.getBookName()}</td>
					<td>${listOfBooks.getCategory()}</td>
					<td><input type="checkbox" name="selectedbooks"
						value="${listOfBooks.getBookId()}"></td>
				</tr>


			</c:forEach>

		</table>
		<input type="submit" name="" value="select" />
	</form>

	<a href="${pageContext.request.contextPath}/cart"><input
		type="button" value="checkout" /></a>

	<a href="${pageContext.request.contextPath}/index"><input
		type="button" value="logout"></a>


</body>
</html>