<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<h3>Error</h3>
<c:if test="${requestScope.errorMessage!=null}">
    <h6>
    <error>
    <fmt:message bundle="${messages}" key="SERVER_ERROR_MESSAGE"/>
    </error>
    </h6>
    <form action="exhibitions" method="get">
        <button type="Submit" name="command" value="loginPage">
            <fmt:message bundle="${messages}" key="BACK_TO_PERSONAL_AREA"/>
        </button>
    </form>
</c:if>
</body>
</html>
