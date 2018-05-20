<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link href="/css/color.css" rel="stylesheet" type="text/css">

</head>
<c:if test="${requestScope.logoutMessage!=null}">
    <h6>
        <success>
        <fmt:message bundle="${messages}" key="SUCCESS_LOGOUT_MESSAGE"/>
        </success>
    </h6>
</c:if>
<c:if test="${requestScope.registrationMessage!=null}">
    <h6>
        <success>
            <fmt:message bundle="${messages}" key="SUCCESS_REGISTRATION_MESSAGE"/>
        </success>
    </h6>
</c:if>
<hr/>
<body><h3>Login</h3>
<form name="loginForm" method="POST" action="exhibitions">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login" ><br/>
    Password:<br/>
    <input type="password" name="password" >
    <br/>
    <c:if test="${requestScope.errorMessage!=null}">
        <h6>
            <error>
            <fmt:message bundle="${messages}" key="LOGIN_ERROR_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <input type="submit" value="Enter">
</form>
<hr/>

<form action="exhibitions" method="get" >
    <button  type="Submit" name="command" value="registrationPage" >Go To Registration Page</button>
</form>


</body>
</html>