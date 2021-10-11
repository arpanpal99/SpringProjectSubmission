<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankManagemnt</title>
<style type="text/css">
body {
	background-color: lightyellow;
}
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  text-align: center;
  width: 100%;
  margin-bottom: 100px;
}

#customers td, #customers th, #customers tr {
  border: 2px solid black;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  background-color: #04AA6D;
  color: white;
}

.button {
  width: 350px;
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
.gap {
	margin-top: 20px;
}
.float-container { margin: 0px auto; }

.float-child {
    margin-right: auto;
    width: 29%;
    float: left;
    padding: 20px;
    border: 2px solid red;
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
    <a href="../account/allAccounts"><button class="op button button1">Accounts Home Page</button></a>
    <a href="../customer/allCustomers"><button class="op button button1">Customer Home Page</button></a>
    <a href="../manager/showAllEmployees"><button class="op button button1">Employees Home Page</button></a>
    <a href="../transaction/showAllTransactions"><button class="op button button1">Transactions Home Page</button></a>
  </div>
<div class="float-container">
  	<div class="operations float-child">
	    <div class="gap">
	        <h3>Customer Operations</h3>
	    </div>
	    <div>
	        <a href="../customer/addCustomer"><button class="button button1">1. Add Customer</button></a><br/>
	        <a href="../customer/add5Customers"><button class="button button2">2. Add Five Random Customers</button></a>
	        <a href="../customer/deleteAllCustomers"><button class="button button3">3. Delete All Customers</button></a>
	    </div>
	</div>
    <div class="operations float-child">
        <div class="gap">
            <h3>Transactional Operations</h3>
        </div>
        <div>
            <a href="../transaction/transfer"><button class="button button1">1. Transfer Money</button></a><br/>
            <a href="../transaction/deposit"><button class="button button2">2. Deposit Money</button></a><br/>
            <a href="../transaction/withdraw"><button class="button button3">3. Withdraw Money</button></a><br/>
            <!-- <a href="../transaction/showAllTransactions"><button class="button button1">4. Show All Transactions</button></a><br/> -->
        </div>
    </div>
    <div class="operations float-child">
      <div class="gap">
          <h3>Employee Operations</h3>
      </div>
      <div>
          <a href="../manager/addEmployee"><button class="button button1">1. Add Employee</button></a><br/>
          <a href="../manager/add4Employees"><button class="button button2">2. Add Four Random Employees</button></a>
          <a href="../manager/deleteAllEmployees"><button class="button button3">3. Delete All Employees</button></a>
      </div>
  </div>
</div>
	<div><h2>Accounts List</h2></div>
<table id = "customers">
    <thead>
        <tr>
            <th>Account ID</th>
            <th>Account Balance</th>
            <th>Customer Name</th>
            <th>Customer Address</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${accounts}" var="account">
            <tr>
                <td>${account.accId}</td>
                <td>${account.accBalance}</td> 
                <td>${account.customer.custName}</td>
                <td>${account.customer.custAddress}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>