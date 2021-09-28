<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
</head>
<body>

<h1 class="text-center">Home Page</h1>

<ul  class="list-group">
		<li class="list-group-item list-group-item-success">
			<h5>
				<a href="user/showAllEmployees">Show all employees</a>
			</h5>
		</li>
		
		<li class="list-group-item list-group-item-success">
			<h5>
				<a href="user/addEmployee">Add employee</a>
			</h5>
		</li>
		
		<li class="list-group-item list-group-item-success">
			<h5>
				<a href="customer/showAllCustomer">Show all customer</a>
			</h5>
		</li>
		
		<li class="list-group-item list-group-item-success">
			<h5>
				<a href="customer/addCustomer">Add new Customer</a>
			</h5>
		</li>
		
		<li class="list-group-item list-group-item-danger">
			<h5>
				<a href="transaction/showAllTransactions">View all Transactions</a>
			</h5>	
		</li>
		
		<li class="list-group-item list-group-item-danger">
			<h5>
				<a href="transaction/pendingTransaction">View pending Transactions</a>
			</h5>	
		</li>
		
		<li class="list-group-item list-group-item-danger">
			<h5>
				<a href="transaction/withdrawMoney">Withdraw Money</a>
			</h5>
		</li>
		
		<li class="list-group-item list-group-item-danger">
			<h5>
				<a href="transaction/depositMoney">Deposit Money</a>
			</h5>
		</li>
		
		<li class="list-group-item list-group-item-danger">
			<h5>
				<a href="transaction/transferMoney">Transfer Money</a>
			</h5>
		</li>
		<li class="list-group-item list-group-item-warning">
			<h5> <a href="/bankapp/logout">Logout</a> </h5>
		</li>
	</ul>
</body>
</html>