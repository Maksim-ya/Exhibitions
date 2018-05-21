<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link href="/css/color.css" rel="stylesheet" type="text/css">
    <title>Registration</title>
</head>
<body>
<form name="registrationForm" method="POST" action="exhibitions">
    <input type="hidden" name="command" value="registration"/>
    <h2>Registration:</h2><br/>
    Login*:<br/>
    <input type="text" name="login" value=""><br/>
    <c:if test="${requestScope.requiredFieldMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="REQUIRED_FIELD_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <c:if test="${requestScope.loginNotUniqueErrorMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="LOGIN_NOT_UNIQUE_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    Password*:<br/>
    <input type="password" name="password" value=""><br/>
    <c:if test="${requestScope.requiredFieldMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="REQUIRED_FIELD_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    Confirm Password*:<br/>
    <input type="password" name="confirmPassword" value=""><br/>
    <c:if test="${requestScope.requiredFieldMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="REQUIRED_FIELD_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <c:if test="${requestScope.passwordsDoNotMatchErrorMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="PASSWORDS_DO_NOT_MATCH_ERROR_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    FullName*:<br/>
    <input type="text" name="fullName" value=""><br/>
    <c:if test="${requestScope.requiredFieldMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="REQUIRED_FIELD_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    Email*:<br/>
    <input type="text" name="email" value="">
    <c:if test="${requestScope.invalidEmailErrorMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="INVALID_EMAIL_ERROR_MESSAGE"/>
            </error>
        </h6>
    </c:if>
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
