<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 04/Feb/18
  Time: 16:53
  To change this template use File | Settings | File Templates.

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<%--<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>--%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
</head>
<c:if test="${requestScope.logoutMessage!=null}">
    <h6>
        <span class="green-text">
        <fmt:message bundle="${messages}" key="SUCCESS_LOGOUT_MESSAGE"/>
    </h6>
</c:if>
<hr/>
<body><h3>Login</h3>
<form name="loginForm" method="POST" action="application">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login" ><br/>
    Password:<br/>
    <input type="password" name="password" >
    <br/>
    <c:if test="${requestScope.errorMessage!=null}">
        <h6>
            <span class="red-text">
            <fmt:message bundle="${messages}" key="LOGIN_ERROR_MESSAGE"/>
        </h6>
    </c:if>
    <input type="submit" value="Enter">
</form>
<hr/>
<%--<form method="get" action="application">--%>
    <%--<input type="hidden" name="command" value="register">--%>
<%--</form>--%>



<%--<a href="/WEB-INF/jsp/registration.jsp">Go To Registration Page</a>--%>
<%--<a href="/Patterns201/frontcontroller/home">Home</a>--%>



<form action="application" method="get" >
    <button  type="Submit" name="command" value="redirect" >Go To Registration Page</button>
</form>


</body>
</html>