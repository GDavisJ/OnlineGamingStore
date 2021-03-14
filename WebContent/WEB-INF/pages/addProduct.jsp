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
<title>Welcome to Space-sta</title>
</head>
<body>
	<!-- Form used to submit products to the database -->
	<h2>Product Form</h2>
		<form:form action="addproduct" method="post" modelAttribute="product">
		<form:hidden path="prodId"/>
		<table>
			<tr>
				<td><form:label path="">Product Name: </form:label></td>
				<td><form:input path="productName"/><form:errors path="productName"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="">Product Description: </form:label></td>
				<td><form:input  path="productDescription"/><form:errors path="productDescription"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="">Product Quantity: </form:label></td>
				<td><form:input path="productQuantity"/><form:errors path="productQuantity"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="">Product Price: </form:label></td>
				<td><form:input path="productPrice"/><form:errors path="productPrice"></form:errors></td>
		</table>
		<input type="submit" value="Submit" /><br>
	</form:form>
	
</body>
</html>