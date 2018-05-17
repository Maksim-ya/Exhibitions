<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
</head>
<body>
<h3>Error</h3>
<c:if test="${requestScope.paymentErrorMessage!=null}">
    <h6>
        <error>
            <fmt:message bundle="${messages}" key="PAYMENT_ERROR_MESSAGE"/>
        </error>
    </h6>
    <form action="application" method="get">
        <button type="Submit" name="command" value="replenishPage">
            <fmt:message bundle="${messages}" key="REPLENISH_AN_ACCOUNT"/>
        </button>
    </form>
    <form action="application" method="get">
        <button type="Submit" name="command" value="basket">
            <fmt:message bundle="${messages}" key="BACK_TO_BASKET"/>
        </button>
    </form>
</c:if>

<c:if test="${requestScope.errorMessage!=null}">
    <h6>
    <error>
    <fmt:message bundle="${messages}" key="SERVER_ERROR_MESSAGE"/>
    </error>
    </h6>
    <form action="application" method="get">
        <button type="Submit" name="command" value="loginPage">
            <fmt:message bundle="${messages}" key="BACK_TO_PERSONAL_AREA"/>
        </button>
    </form>
</c:if>
</body>
</html>
