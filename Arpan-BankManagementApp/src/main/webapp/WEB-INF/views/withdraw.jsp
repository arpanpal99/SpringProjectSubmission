<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw</title>
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
		<h1>Withdraw Funds Portal</h1>
		<form:form method="post" modelAttribute="withdrawRequest">
			<table>
				<tr>
					<td>Enter Account ID:</td>
					<td><form:input path="accountId" /> &nbsp;&nbsp;&nbsp; [<form:errors path="accountId" class="error" />]</td>
				</tr>
				<tr>
					<td>Enter Withdrawal Amount:</td>
					<td><form:input path="amount" /> &nbsp;&nbsp;&nbsp; [<form:errors path="amount" class="error" />]</td>
				</tr>
				<tr>
					<td><button type="submit" class="button button1">
							Submit</button></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>