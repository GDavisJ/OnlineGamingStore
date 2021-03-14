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

<link href="<c:url value="/resources/css/application.css" />" rel="stylesheet">
<title>Welcome to the Online Gaming Store</title>
</head>
<body>
	<h2>Registration</h2>
	<!-- Form used to add/ register users to the database -->
		<form:form action="registration" method="post" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="">Username: </form:label></td>
				<td><form:input path="username"/><form:errors path="username"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="">Password: </form:label></td>
				<td><form:input type="password" path="password"/><form:errors path="password"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="">First Name: </form:label></td>
				<td><form:input path="firstname"/><form:errors path="firstname"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="">Last Name: </form:label></td>
				<td><form:input path="lastname"/><form:errors path="lastname"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="">Email: </form:label></td>
				<td><form:input path="email"/><form:errors path="email"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="">Phone #: </form:label></td>
				<td><form:input path="phonenumber"/><form:errors path="phonenumber"></form:errors></td>
			</tr>
		</table>
		<input type="submit" value="Submit" /><br>
	</form:form>

	Already have an account? Login <a href="login">here</a>!
	
</body>
</html>