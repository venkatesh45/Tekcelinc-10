<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>
		Welcome
	
		<%= request.getAttribute("username")
		%>
	</h3>
	<a href="${pageContext.request.contextPath}/browse"><input type="button" value="browse" /></a>
	
	<a href="${pageContext.request.contextPath}/index"><input type="button" value="logout"></a>
	
</body>
</html>