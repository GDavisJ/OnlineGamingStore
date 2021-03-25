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
<title>All Users</title>
</head>
<body>
	<script>
	function getUsers(){
		$.ajax({
					type: "GET",
					//url: "/OnlineGamingStore/service/users",
					url: "https://onlinegamingstore.azurewebsites.net/service/users",
					dataType: "json",
					success: function(data){
						// Display users in the jQuery Data Table
						$('#users').dataTable({"data": data,"columns": [{ "data": "username" },{ "data": "firstname" },{ "data": "lastname" },{ "data": "email" },{ "data": "phonenumber" }]});},
					error: function (xhr, ajaxOptions, thrownError){
						alert(xhr.status);
						alert(thrownError);
					}
				})
	}
	$(document).ready(getUsers)
	
	</script>
	<table class="display" style="border: 1px solid black; width:50%" id="users">
		<thead>
		<tr>
			<th style="width: 25%;"><label>Username</label></th>
			<th style="width: 25%;"><label>First Name</label></th>
			<th style="width: 25%;"><label>Last Name</label></th>
			<th style="width: 25%;"><label>Email</label></th>
			<th style="width: 25%;"><label>Phone Number</label></th>
		</tr>
		 </thead>
		 <tbody></tbody>
	</table>
</body>
</html>