<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>my secure app home page</title>
</head>
<body>
home page<br/>
<sec:authorize access="hasAnyRole('MANAGER','ADMIN')">
<a href="mgr">mgr resource</a><br/>
</sec:authorize>

<br/>

<sec:authorize access="hasAnyRole('MANAGER')">
<a href="admin">admin resource</a><br/>
</sec:authorize>


<a href="emp">emp resource</a><br/>
</body>
</html>