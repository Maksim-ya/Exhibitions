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
<h3>Buy now</h3>
<hr/>
<c:out value="${name}, buy!"/>
<hr/>
<table class="tg">
    <tr>
        <th width="120">Title</th>
        <th width="120">Price</th>
        <th width="120">Showroom</th>
        <th width="200">Event Date</th>
        <th width="200">Number of Tickets</th>

    </tr>
    <form action="exhibitions" method="post">

        <c:forEach items="${listOfUserExpositions}" var="exposition">
        <tr>
            <td>${exposition.title}</td>
            <td>${exposition.price}</td>
            <td>${exposition.showroom.title}</td>
            <td>
                <input type="date" name="eventDate${exposition.expositionId}" value="${today}"
                       max="${exposition.finishDate}"
                       min="${today}">
            </td>
            <td align="center">
                <input type="text" name="numberOfPersons${exposition.expositionId}" size=2 value="1" ><br/>

            </td>
        </tr>
        </c:forEach>

</table>
<c:if test="${requestScope.paymentErrorMessage!=null}">
    <h6>
        <error>
            <fmt:message bundle="${messages}" key="PAYMENT_ERROR_MESSAGE"/>
        </error>
    </h6>
    <form action="exhibitions" method="get">
        <button type="Submit" name="command" value="replenish an account">
            <fmt:message bundle="${messages}" key="REPLENISH_AN_ACCOUNT"/>
        </button>
    </form>
    <form action="exhibitions" method="get">
        <button type="Submit" name="command" value="basket">
            <fmt:message bundle="${messages}" key="BACK_TO_BASKET"/>
        </button>
    </form>
</c:if>
<button type="Submit" name="command" value="payment">Buy now</button>
</form>
</body>
</html>
