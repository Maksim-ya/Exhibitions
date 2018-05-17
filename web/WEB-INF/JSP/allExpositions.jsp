<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>Expositions Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>

</head>
<body>
<h1>List of Expositions</h1>
<form action="application" method="get">
    <table class="tg">
        <tr>
            <th width="120"></th>
            <th width="120">Title</th>
            <th width="120">Price</th>
            <th width="200">Showroom</th>
            <th width="200">Start Date</th>
            <th width="200">Finish Date</th>
        </tr>
        <c:forEach items="${listOfExpositions}" var="exposition">
            <tr>
                <td><label><input type="checkbox" name="exposition${exposition.expositionId}" onclick="setButton"
                                  value="${exposition.expositionId}"></label></td>
                <td>${exposition.title}</td>
                <td>${exposition.price}</td>
                <td>${exposition.showroom.title}</td>
                <td>${exposition.startDate}</td>
                <td>${exposition.finishDate}</td>
                <td>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button type="Submit" name="command" value="basket"> Buy</button>
    <button type="Submit" name="command" value="loginPage">
        <fmt:message bundle="${messages}" key="ENTER"/>
    </button>
</form>
</form>
</body>
</html>

