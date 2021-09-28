<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
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
  background-color: #4CAF50; 
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
	<h1>Add Employee Portal</h1>
	<form:form method="post" modelAttribute="employee">
	<form:hidden path="empId"/>
		<table>
			<tr>
				<td>Enter Employee Username: </td>
				<td>
					<form:input path="empUsername" />
				 	<form:errors path="empUsername" class="error" />
				</td>
			</tr>
			<tr>
				<td>Enter Employee Password: </td>
				<td>
					<form:input path="empPassword" />
				 	<form:errors path="empPassword" class="error" />
				</td>
			</tr>
			<tr>
				<td>Enter Employee E-mail ID: </td>
				<td>
					<form:input path="empEmail" />
					<form:errors path="empEmail" class="error" />
				</td>
			</tr>
			
			<tr>
				<td>Enter Employee Contact number: </td>
				<td>
					<form:input path="empContact" />
				 	<form:errors path="empContact" class="error" />
				 </td>
			</tr>
			
			<tr>
				<td>Enter Employee ROLE: </td>
				<td>
					<form:input path="empRole" />
				 	<form:errors path="empRole" class="error" />
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


