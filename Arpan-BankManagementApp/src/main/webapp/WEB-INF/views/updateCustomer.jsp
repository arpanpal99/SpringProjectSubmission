<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Customer</title>
<style type="text/css">
	body {
		background-color: #BBFF96;
	}
	
	table {
		border: 2px solid red;
		margin: 10px;
		padding: 5px;
	}
	
	h1 {
		color: red;
	}
	
	.error {
		color: #EE1313;
	}
	
	.button {
		width: 150px;
		background-color: #4CAF50; /* Green */
		border: none;
		color: white;
		padding: 16px 32px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 4px 2px;
		transition-duration: 0.4s;
		cursor: pointer;
	}
	
	.button1 {
		background-color: white;
		color: black;
		border: 2px solid #4CAF50;
	}
	
	.button1:hover {
		background-color: #4CAF50;
		color: white;
	}
	
	.portal {
		position: relative;
		text-align: center;
	}
	.frm {
		
		margin-left: 36%;
	}

</style>
</head>
<body>
	<div class="portal">
		<div>
			<h1>Update Customer Address Portal</h1>
		</div>
		<div class="frm">
			<form:form action="addCustomer" method="post" modelAttribute="customer">
				<table>
					<tr>
						<td>Customer ID</td>
						<td>
							<form:input path="custId" readonly="true" style="background-color:lightgrey;"/>
						 	<form:errors path="custId" class="error" />
						</td>
					</tr>
					<tr>
						<td>Customer name</td>
						<td>
							<form:input path="custName" readonly="true" style="background-color:lightgrey;"/>
						 	<form:errors path="custName" class="error" />
						</td>
					</tr>
					<tr>
						<td>Customer email</td>
						<td>
							<form:input path="custEmail" readonly="true" style="background-color:lightgrey;"/>
							<form:errors path="custEmail" class="error" />
						</td>
					</tr>
					<tr>
						<td>Customer phone number</td>
						<td>
							<form:input path="custContact" readonly="true" style="background-color:lightgrey;"/>
						 	<form:errors path="custContact" class="error" />
						 </td>
					</tr>
					<tr>
						<td>Enter customer address</td>
						<td>
							<form:input path="custAddress"/>
						 	<form:errors path="custAddress" class="error"/>
						 </td>
					</tr>
					<tr>
						<td><button type="submit" class="button button1">Submit</button></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>