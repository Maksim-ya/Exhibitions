<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07/02/2018
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link href="/css/color.css" rel="stylesheet" type="text/css">
    <title>Registration</title>
</head>
<body>
<form name="registrationForm" method="POST" action="application">
    <input type="hidden" name="command" value="registration"/>
    <h2>Registration:</h2><br/>
    Login:<br/>
    <input type="text" name="login" value=""><br/>
    <c:if test="${requestScope.loginNotUniqueErrorMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="LOGIN_NOT_UNIQUE_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    Password:<br/>
    <input type="password" name="password" value=""><br/>
    FullName:<br/>
    <input type="text" name="fullName" value=""><br/>
    Address:<br/>
    <input type="text" name="address" value="">
    <br/>
    <h6>
        <info>
            <fmt:message bundle="${messages}" key="REQUIRED_FIELD_MESSAGE"/>
        </info>
    </h6>
    <input type="submit" value="Enter">
</form>
</body>
</html>
