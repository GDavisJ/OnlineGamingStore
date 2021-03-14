<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the Online Gaming Store</title>
</head>
<body>
	<h2>Login</h2>
	<!-- Form used to verify a users credentials -->
		<form:form action="login" method="post" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="">Username: </form:label></td>
				<td><form:input path="username"/><form:errors path="username"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="">Password: </form:label></td>
				<td><form:input type="password" path="password"/><form:errors path="password"></form:errors></td>
			</tr>
		</table>
		<input type="submit" value="Submit" /><br>
	</form:form>

	Don't have an account? Register <a href="registration">here</a>!
	
</body>
</html>