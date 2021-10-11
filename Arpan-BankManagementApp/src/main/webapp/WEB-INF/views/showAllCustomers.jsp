<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Customer List</title>
<style>
body {
	background-color: #FAEAFF;
}

#customers {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	text-align: center !important;
	width: 95%;
	margin: 28px 28px 100px;
}

#customers td, #customers th, #customers tr {
	border: 2px solid black;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	background-color: #008CBA;
	color: white;
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

.button2 {
	background-color: white;
	color: black;
	border: 2px solid #008CBA;
}

.button2:hover {
	background-color: #008CBA;
	color: white;
}

.button3 {
	background-color: white;
	color: black;
	border: 2px solid #f44336;
}

.button3:hover {
	background-color: #f44336;
	color: white;
}

h1 {
	margin: 50px 400px 20px;
	padding: 10px;
	border: 2px solid black;
	text-align: center;
	font-size: 50px;
}

h2 {
	text-align: center;
}

.operations {
	margin: 30px auto;
	text-align: center;
}

.op {
	width: auto;
}
</style>
</head>
<body>
	<header class="button3" style="font-size:20px; text-align: center; text-decoration:none; margin-left: 94%;">
		<a href="/bma/logout">Logout</a>
	</header>
	<h1>Bank of Noida</h1>
	<div class="operations">
		<a href="../account/allAccounts"><button class="op button button1">Accounts
				Home Page</button></a> <a href="../customer/allCustomers"><button
				class="op button button1">Customer Home Page</button></a> <a
			href="../manager/showAllEmployees"><button
				class="op button button1">Employees Home Page</button></a> <a
			href="../transaction/showAllTransactions"><button
				class="op button button1">Transactions Home Page</button></a>
	</div>
	<div class="operations">
		<a href="addCustomer"><button class="op button button2">Add
				New Customer</button></a> <a href="add5Customers"><button
				class="op button button2">Add Five Random Customers</button></a> <a
			href="deleteAllCustomers"><button class="op button button3">Delete
				All Customers</button></a>
	</div>
	<div>
		<h2>Customers List</h2>
	</div>
	<table id="customers">
		<thead>
			<tr>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Customer Email</th>
				<th>Customer Mobile</th>
				<th>Customer Address</th>
				<th>Update Customer</th>
				<th>Delete Customer</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr class="table-success">
					<td>${customer.custId}</td>
					<td>${customer.custName}</td>
					<td>${customer.custEmail}</td>
					<td>${customer.custContact}</td>
					<td>${customer.custAddress}</td>
					<td><a href="updateCustomer/${customer.custId}"><button
								class="op button button1">Update</button></a></td>
					<td><a href="deleteCustomer/${customer.custId}"><button
								class="op button button3">Delete</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>