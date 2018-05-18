<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>BuyPage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
</head>

<body>

<hr/>
<error>
    <fmt:message bundle="${messages}" key="PAYMENT_ERROR_MESSAGE"/>
</error>
<hr/>
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

</body>
</html>
