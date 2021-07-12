<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align ="center">
<h1>SignUp form</h1>
<form:form action="process-signUp" method="POST" modelAttribute="signupdto">
UserName:<form:input path="username"/><br/><br/>
Password:<form:input path="password"/><br/><br/>
<input type="submit" value="login">

</form:form>
</div>
</body>
</html>