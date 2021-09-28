<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction History</title>
<style>
body {
	background-color: #FAEAFF;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  padding: 6px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
#transactions {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  text-align: center !important;
  width: 95%;
  margin: 28px 28px 100px;
}

#transactions td, #transactions th, #transactions tr {
  border: 2px solid black;
  padding: 8px;
}

#transactions tr:nth-child(even){background-color: #f2f2f2;}
#transactions tr:hover {background-color: #ddd;}
#transactions th {
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
	<h1>Bank of Noida</h1>
	<div class="operations">
		<a href="../account/allAccounts"><button class="op button button1">Accounts Home Page</button></a>
		<a href="../customer/allCustomers"><button class="op button button1">Customer Home Page</button></a>
		<a href="../manager/showAllEmployees"><button class="op button button1">Employees Home Page</button></a>
		<a href="../transaction/showAllTransactions"><button class="op button button1">Transactions Home Page</button></a>
	  </div>
	  <div class="operations">
		<a href="../transaction/transfer"><button class="op button button2">TRANSFER</button></a>
		<a href="../transaction/deposit"><button class="op button button2">DEPOSIT</button></a>
		<a href="../transaction/withdraw"><button class="op button button2">WITHDRAW</button></a>
		<a href="../transaction/pendingTransaction"><button class="op button button3">Show Pending Transactions</button></a>
	</div>
	<div><h2>Transaction List</h2></div>
	<table id="transactions">
		<thead>
			<tr>
				<th>Transaction Id</th>
				<th>From account</th>
				<th>To account</th>
				<th>Amount</th>
				<th>Transaction type</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transactions}" var="transaction">
				<tr>
					<td>${transaction.txId}</td>
					<td>
						<c:if test="${transaction.txFromAccountId==null}" >
							self
						</c:if>
						<c:if test="${transaction.txFromAccountId!=null}" >
							${transaction.txFromAccountId}
						</c:if>
					</td>
					<td>
						<c:if test="${transaction.txToAccountId==null}" >
							self
						</c:if>
						<c:if test="${transaction.txToAccountId!=null}" >
							${transaction.txToAccountId}
						</c:if>
					</td>
					<td>${transaction.txAmount}</td>
					<td>${transaction.txType}</td>
					<td>${transaction.txStatus}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>