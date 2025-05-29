<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 29/05/2025
  Time: 10:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Đăng nhập</title></head>
<body>
<h2>Đăng nhập</h2>

<form:form method="POST" modelAttribute="user" action="login-save">
    <p>Tên đăng nhập: <form:input path="username" /></p>
    <p>Mật khẩu: <form:password path="password" /></p>
    <p>
        <label><input type="checkbox" name="remember" /> Ghi nhớ tôi</label>
    </p>
    <p><input type="submit" value="Đăng nhập" /></p>
</form:form>

<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>
</body>
</html>
