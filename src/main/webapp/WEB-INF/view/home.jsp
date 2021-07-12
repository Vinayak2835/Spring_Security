<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>Hello Guys welcome</p>
<h1> UserName: ${userName} </h1>
<h1> Role of an User:${roles}</h1>
<sec:authorize access = 'hasAuthority("Trainer")'>
<a href="/SpringSecurityEvening/Trainer">Trainers DashBoard</a><br/>
</sec:authorize>

<sec:authorize access = 'hasAuthority("Coder")'>
<a href ="/SpringSecurityEvening/Coder">Coders  DashBoard</a><br/>
</sec:authorize>
<form:form action="logout" method="POST">
<input type="submit" value="logout"/>
</form:form>
</body>
</html>