<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Login Form:
	<br>
	<form action="${pageContext.request.contextPath}/submit" method="POST">
		Username:<input type="text" name="username"><br>
		Password:<input type="password" name="password"><br> <input
			type="submit" name="Submit" value="login">
	</form>

</body>
</html>