<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 29/05/2025
  Time: 9:57 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title><spring:message code="register.title"/></title></head>
<style>
    .error{
        color: red;
    }
</style>
<body>
<a href="?lang=vi">Tiếng việt</a> <br>
<a href="?lang=en">English</a> <br>
<h3><spring:message code="register.title"/></h3>

<c:if test="${not empty successMessage}">
    <p style="color: green"><spring:message code="${successMessage}"/></p>
</c:if>

<form:form modelAttribute="user" method="post">
    <label><spring:message code="username.label"/></label><br/>
    <form:input path="username"/>
    <form:errors path="username" cssClass="error"/><br/>

    <label><spring:message code="password.label"/></label><br/>
    <form:password path="password"/>
    <form:errors path="password" cssClass="error"/><br/>

    <label><spring:message code="confirmPassword.label"/></label><br/>
    <form:password path="confirmPassword"/>
    <form:errors path="confirmPassword" cssClass="error"/><br/>

    <label><spring:message code="email.label"/></label><br/>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/><br/><br/>

    <input type="submit" value="<spring:message code='register.button'/>"/>
</form:form>

</body>
</html>
