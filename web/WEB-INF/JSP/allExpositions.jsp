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
    <title>Publications Page</title>
</head>
<body>
<h1>List of Publications</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Price</th>
        <th width="120">Type</th>
        <th width="120">Edition</th>
        <th width="60">More</th>
        <th width="60">Buy</th>
    </tr>
    <form action="application" method="get">
    <c:forEach items="${listOfPublications}" var="publication">
        <tr>
                <%--<td><a href="/employeedata/${employee.ticketId}" target="_blank">${employee.ticketId}</a></td>--%>
            <td><label><input type="checkbox" name="publication${publication.publicationId}" onclick="setButton"
                              value="${publication.publicationId}"></label></td>
                    <%--<form action="CheckBox" method="POST" target="_blank">--%>
                        <%--<input type="checkbox" name="publicationId" onclick="setButton"--%>
                                      <%--value="${publication.publicationId}"></label></td>--%>
            <%--<td> ${publication.publicationId}</td>--%>
            <td>${publication.title}</td>
            <td>${publication.price}</td>
            <td>${publication.type}</td>
            <td>${publication.edition}</td>
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

