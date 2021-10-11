<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resouce not found!!!</title>
<style type="text/css">
body {
	background-color: #FAEAFF;
}
h2 {
	margin: 50px 200px 20px;
	padding: 10px;
	border: 2px solid black;
	text-align: center;
	font-size: 50px;
}
div {
	text-align: center;
}
.button {
	width: auto;
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
</style>
</head>
<body>

<h2>${empUsername}, you are not authorized to access this page!</h2><br>
<div><button class="button button1" onCLick="history.back()">BACK</button></div>
<div><a href="/bma/logout"><a href="/bma/logout"><button class="button button2">Login as different Employee</button></a></div>
</body>
</html>