<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 29/05/2025
  Time: 9:24 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Giỏ hàng</title>
</head>
<body>
<h2>Thêm sản phẩm vào giỏ hàng</h2>
<form:form modelAttribute="cartItem" action="/cart/add" method="post">
  <label>Tên sản phẩm:</label>
  <form:input path="name"/><br>
  <label>Số lượng:</label>
  <form:input path="quantity" type="number"/><br>
  <input type="submit" value="Thêm vào giỏ hàng"/>
</form:form>

<h3>Sản phẩm đã thêm:</h3>
<ul>
  <c:forEach var="name" items="${cookieProducts}">
    <li>${name}</li>
  </c:forEach>
</ul>

<h3>Giỏ hàng:</h3>
<table border="1">
  <tr>
    <th>Tên</th>
    <th>Số lượng</th>
    <th>Hành động</th>
  </tr>
  <c:forEach var="item" items="${cart}">
    <tr>
      <td>${item.name}</td>
      <td>${item.quantity}</td>
      <td>
        <a href="/cart/delete?name=${item.name}">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

