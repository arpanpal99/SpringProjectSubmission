<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
<style type="text/css">
body {
	background-color: #FAEAFF;
}
table {
	border: 2px solid red;
	margin: 10px;
	padding: 5px;
}
h1 {
	color: red;
}
.error{
	color:#EE1313;
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
form {
	margin-left: 35%;
}
.portal {
	text-align: center;
}
</style>
</head>
<body>
<div class="portal">
	<h1>Add Customer Account Portal</h1>
	<form:form method="post" modelAttribute="customer">
	<form:hidden path="custId"/>
		<table>
			<tr>
				<td>Enter Customer Name: </td>
				<td>
					<form:input path="custName" />
				 	<form:errors path="custName" class="error" />
				</td>
			</tr>
			
			<tr>
				<td>Enter Customer E-mail ID: </td>
				<td>
					<form:input path="custEmail" />
					<form:errors path="custEmail" class="error" />
				</td>
			</tr>
			
			<tr>
				<td>Enter Customer Contact number: </td>
				<td>
					<form:input path="custContact" />
				 	<form:errors path="custContact" class="error" />
				 </td>
			</tr>
			
			<tr>
				<td>Enter Customer Address: </td>
				<td>
					<form:input path="custAddress" />
				 	<form:errors path="custAddress" class="error" />
				 </td>
			</tr>

			<tr>
				<td>Enter Initial Account Balance: </td>
				<td>
					<input type="number" name="accountBalance"/> 
				 </td>
			</tr>

			<tr>
				<td><button type = "submit" class="button button1"> Submit </button></td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>