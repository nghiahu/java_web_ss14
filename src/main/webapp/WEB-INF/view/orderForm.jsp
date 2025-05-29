<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 29/05/2025
  Time: 9:32 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Đơn hàng</title></head>
<body>
<h3>Thêm / Cập nhật đơn hàng</h3>
<form:form modelAttribute="order" method="post" action="${order.orderId != null ? 'updateOrder' : 'addOrder'}">
    <label>Mã đơn hàng:</label>
    <form:input path="orderId" readonly="${order.orderId != null}" /><br/>
    <label>Tên sản phẩm:</label>
    <form:input path="productName" /><br/>
    <label>Số lượng:</label>
    <form:input path="quantity" type="number" /><br/>
    <input type="submit" value="${order.orderId != null ? 'Cập nhật' : 'Thêm'}" />
</form:form>
<a href="orderList">Quay lại danh sách</a>
</body>
</html>
