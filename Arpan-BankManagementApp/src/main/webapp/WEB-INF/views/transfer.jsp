<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer</title>
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
		
		margin-left: 35%;
	}

</style>
</head>
<body>
<div>
	<div class="portal">
		<div>
			<h1>Transfer Funds Portal</h1>
		</div>
		<div class="frm">
			<form:form method="post" modelAttribute="transferRequest">
				<table>
					<tr>
						<td>Enter Sender Account ID:</td>
						<td><form:input path="fromAccId" /> &nbsp;&nbsp;&nbsp; [<form:errors
								path="fromAccId" class="error" />]</td>
					</tr>
					<tr>
						<td>Enter Receiver Account ID:</td>
						<td><form:input path="toAccId" /> &nbsp;&nbsp;&nbsp; [<form:errors
								path="toAccId" class="error" />]</td>
					</tr>
					<tr>
						<td>Enter amount to transfer:</td>
						<td><form:input path="amount" /> &nbsp;&nbsp;&nbsp; [<form:errors
								path="amount" class="error" />]</td>
					</tr>
					<tr>
						<td><button type="submit" class="button button1">
								Submit</button></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>