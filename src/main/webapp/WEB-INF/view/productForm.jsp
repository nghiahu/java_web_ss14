<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 29/05/2025
  Time: 12:06 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
  .formProduct{
    display: flex;
    flex-direction: column;
    text-align: start;
    gap: 10px;
    width: 300px;
  }
</style>
<body>
<h3>Thêm sản phẩm</h3>
<form:form modelAttribute="product" action="product-save" method="post" cssClass="formProduct">
  <label>Mã sản phẩm</label>
  <form:input path="id"/>
  <form:errors path="id" cssStyle="color: red"/>
  <label>Tên sản phẩm</label>
  <form:input path="name"/>
  <form:errors path="id" cssStyle="color: red"/>
  <label>Giá</label>
  <form:input path="price" type="number"/>
  <form:errors path="id" cssStyle="color: red"/>
  <input value="Thêm sản phẩm" type="submit">
</form:form>
</body>
</html>
