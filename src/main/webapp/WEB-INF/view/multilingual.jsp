<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 29/05/2025
  Time: 8:43 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Xin chào mừng</h4>
    <a href="?lang=vi">Tiếng việt</a> <br>
    <a href="?lang=en">English</a> <br>
<div>
    <fmt:message key="mess.title"/>
</div>
</body>
</html>
