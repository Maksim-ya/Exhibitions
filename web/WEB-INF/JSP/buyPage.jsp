<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>BuyPage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<h3><fmt:message bundle="${messages}" key="SELECT_DATE_AND_NUMBER"/></h3>
<table class="tg">
    <tr>
        <th width="120"><fmt:message bundle="${messages}" key="TITLE"/></th>
        <th width="120"><fmt:message bundle="${messages}" key="PRICE"/></th>
        <th width="120"><fmt:message bundle="${messages}" key="SHOWROOM"/></th>
        <th width="200"><fmt:message bundle="${messages}" key="DATE"/></th>
        <th width="200"><fmt:message bundle="${messages}" key="NUMBER_OF_TICKETS"/></th>

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
            <td>
                <input type="text" name="numberOfPersons${exposition.expositionId}" size=2 value="1"><br/>
                <c:if test="${requestScope.numberOfPersonsErrorMessage!=null}">
                    <h6>
                        <error>
                            <fmt:message bundle="${messages}" key="NUMBER_OF_PERSONSE_ERROR_MESSAGE"/>
                        </error>
                    </h6>
                </c:if>
            </td>
        </tr>
        </c:forEach>

</table>
<button type="Submit" name="command" value="payment">
    <fmt:message bundle="${messages}" key="BUY"/>
</button>
</form>
</body>
</html>
