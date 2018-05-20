
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <title>Welcome</title></head>
<body><h3>Welcome</h3>

<hr />
<c:out value="${name}, Hello!"/>
<hr />

<h1>List of Your Tickets </h1>
<table class="tg">
    <tr>
        <th width="120">Tickets</th>
    </tr>
    <c:forEach items="${listOfTickets}" var="ticket">
        <tr>
            <td>${ticket.exposition.title}</td>

            <td>

            </td>
        </tr>
    </c:forEach>
</table>

<form action="exhibitions">
    <input type="hidden" name="command" value="logout" />
    <br/>
    <input type="submit" value="Logout">
</form>
</body></html>

