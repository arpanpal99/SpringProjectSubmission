<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
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
			<h1>Update Employee Portal</h1>
		</div>
		<div class="frm">
			<form:form action="addEmployee" method="post" modelAttribute="employee">
				<table>
					<tr>
						<td>Employee ID</td>
						<td>
							<form:input path="empId" readonly="true" style="background-color:lightgrey;"/>
						 	<form:errors path="empId" class="error" />
						</td>
					</tr>
					<tr>
						<td>Employee Username</td>
						<td>
							<form:input path="empUsername" readonly="true" style="background-color:lightgrey;"/>
						 	<form:errors path="empUsername" class="error" />
						</td>
					</tr>
					<tr>
						<td>Enter Employee Password</td>
						<td>
							<form:input path="empPassword"/>
						 	<form:errors path="empPassword" class="error" />
						</td>
					</tr>
					<tr>
						<td>Employee Email</td>
						<td>
							<form:input path="empEmail"/>
							<form:errors path="empEmail" class="error" />
						</td>
					</tr>
					<tr>
						<td>Enter Employee Contact</td>
						<td>
							<form:input path="empContact"/>
						 	<form:errors path="empContact" class="error" />
						 </td>
					</tr>
					<tr>
						<td>Enter Employee ROLE</td>
						<td>
							<form:input path="empRole"/>
						 	<form:errors path="empRole" class="error"/>
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