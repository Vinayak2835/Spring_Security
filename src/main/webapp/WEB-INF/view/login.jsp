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
<h1>Login page</h1>
<c:if test ="${param.error != null} ">
<i>Invalid process</i>
</c:if>
<form:form  action ="process-login" method="POST">
UserName : <input type ="text"  placeholder ="UserName" name ="username"/><br/><br/>
Password : <input type ="text" placeholder ="Password" name ="password"></br><br/>
<input type ="submit" value ="login">
</form:form>
</div>
</body>
</html>