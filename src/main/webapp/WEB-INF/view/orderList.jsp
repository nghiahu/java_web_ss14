<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 29/05/2025
  Time: 9:32 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Danh sách đơn hàng</title></head>
<body>
<h3>Danh sách đơn hàng</h3>
<table border="1">
    <tr>
        <th>Mã</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.orderId}</td>
            <td>${order.productName}</td>
            <td>${order.quantity}</td>
            <td>
                <a href="editOrder?id=${order.orderId}">Sửa</a>
                <a href="deleteOrder?id=${order.orderId}" onclick="return confirm('Xóa đơn hàng?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="orderForm">Thêm đơn hàng mới</a>
</body>
</html>

