<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 29/05/2025
  Time: 8:36 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="productForm">Thêm sản phẩm mới</a>
<br/><br/>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>
                <a href="deleteProduct?id=${p.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


