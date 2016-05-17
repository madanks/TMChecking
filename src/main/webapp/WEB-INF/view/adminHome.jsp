<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Admin Home</h1>
	<a href="<c:url value='/j_spring_security_logout'/>">Logout</a>
	 
    <form action="/j_spring_security_check" method="post">
        <input type="text" name="j_username" value=""    />
        <input type="password" name="j_password"   />
        
        <input type="submit" value="Let me in." class="btn btn-primary btn-block btn-large">
    </form>
</body>
</html>