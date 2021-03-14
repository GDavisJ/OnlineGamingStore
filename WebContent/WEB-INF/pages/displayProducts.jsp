<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<title>Game Products</title>
<script type="text/javascript" >
	function deleteConfirmation() {
		var result = confirm("WARNING! \n This will permanentley remove this product from the database. \n Are you sure you wish to do this?");
		if (result){
			return true;
		}
		else{
			return false;
			}
		}
</script>
</head>
<body>
	<!-- Page displays a table of products from the database -->
	<table class="display" style="border: 1px solid black;">
		<tr>
			<th style="border: 1px solid black; padding: 5px;"><label>Product Name</label></th>
			<th style="border: 1px solid black; padding: 5px;"><label>Qty</label></th>
			<th style="border: 1px solid black; padding: 5px;"><label>Price</label></th>
			<th style="border: 1px solid black; padding: 5px;"><label>Description</label></th>
			<th style="border: 1px solid black; padding: 5px;"><label>Action</label></th>
		</tr>
			<c:forEach var="product" items="${products}" varStatus="status">
				<tr>
				<td style="border: 1px solid black; padding: 5px;">${product.productName}</td>
				<td style="border: 1px solid black; padding: 5px;"><label>${product.productQuantity}</label></td>
				<td style="border: 1px solid black; padding: 5px;"><label>${product.productPrice}</label></td>
				<td style="border: 1px solid black; padding: 5px;"><label>${product.productDescription}</label></td>
				<td style="border: 1px solid black; padding: 5px;">
					<c:url var="deleteProd" value="/deleteProd">
					<c:param name="prodId" value="${product.prodId}"/>
					</c:url>
					<c:url var="updateProd" value="/updateProd">
					<c:param name="prodId" value="${product.prodId}"/>
					</c:url>
					<a href="${updateProd}">Update</a>
					<a href="${deleteProd}" onclick="return deleteConfirmation()">Delete</a>
				</td>
				</tr>
			</c:forEach>
	</table>
	Add a new product? <a href="addproduct">Click here</a>!
</body>
</html>