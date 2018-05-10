<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 09/Apr/18
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expositions Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>

</head>
<body>
<h1>List of Expositions</h1>

<table class="tg">
    <tr>
        <%--<th width="80">ID</th>--%>
        <th width="120">Title</th>
        <th width="120">Price</th>
        <%--<th width="120">Type</th>--%>
        <th width="120">Showroom</th>
        <th width="200">Start Date</th>
        <th width="200">Finish Date</th>
    </tr>
    <form action="application" method="get">
    <c:forEach items="${listOfExpositions}" var="exposition">
        <tr>
                <%--<td><a href="/employeedata/${employee.ticketId}" target="_blank">${employee.ticketId}</a></td>--%>
            <td><label><input type="checkbox" name="exposition${exposition.expositionId}" onclick="setButton"
                              value="${exposition.expositionId}"></label></td>
                    <%--<form action="CheckBox" method="POST" target="_blank">--%>
                        <%--<input type="checkbox" name="publicationId" onclick="setButton"--%>
                                      <%--value="${publication.publicationId}"></label></td>--%>
            <%--<td> ${publication.publicationId}</td>--%>
            <td>${exposition.title}</td>
            <td>${exposition.price}</td>
            <td>${exposition.showroom.title}</td>
            <td>${exposition.startDate}</td>
            <td>${exposition.finishDate}</td>
                <%--<td><a href="<c:url value='/edit/${publication.ticketId}'/>">Edit</a></td>--%>
            <td>
                    <%--<a href="<c:url value='/main'/>">Buy</a></td>--%>
                <%--<form action="application" method="post">--%>
                    <%--<input type="hidden" name="publicationId" value="${publication.publicationId}"/>--%>
                    <%--<button type="Submit" name="command" value="basket"> Buy</button>--%>
                <%--</form>--%>
            </td>
        </tr>
    </c:forEach>
</table>
<%--<form action="application" method="post">--%>
    <%--<input type="hidden" name="publicationId" value="${publication.publicationId}"/>--%>
    <button type="Submit" name="command" value="basket"> Buy</button>
</form>
<%--</c:if>--%>
<%--</form>--%>

</body>
</html>

