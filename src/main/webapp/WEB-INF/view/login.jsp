<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 28/05/2025
  Time: 5:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Login</h3>
<form:form modelAttribute="user" action="login-submit" method="post">
  <label>Username</label>
  <form:input path="username"/> <br>
  <label>Password</label>
  <form:input path="password"/> <br>
  <input value="Login" type="submit">
</form:form>
<c:if test="${message != null}">
  <h4 style="color: red">${message}</h4>
</c:if>
</body>
</html>
