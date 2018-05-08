<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 17/Apr/18
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="mytag"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html;
charset=Utf-8"/>
<html>
<head>
    <title>BuyPage</title>
</head>



<body>
<h3>Buy now</h3>
<hr/>
<c:out value="${name}, buy!"/>
<hr/>
<table class="tg">
    <tr>
        <%--<th width="80">ID</th>--%>
        <th width="120">Title</th>
        <th width="120">Price</th>
        <%--<th width="120">Type</th>--%>
        <th width="120">Showroom</th>
        <th width="200">Event Date</th>
        <th width="200">Number of Tickets</th>
        <%--<th width="200">Total</th>--%>
        <%--<th width="200">Finish Date</th>--%>
    </tr>
    <form action="application" method="get">

        <c:forEach items="${listOfUserExpositions}" var="exposition">
        <tr>
                <%--<td><a href="/employeedata/${employee.ticketId}" target="_blank">${employee.ticketId}</a></td>--%>
                <%--<td><input name="exposition${exposition.expositionId}"--%>
                <%--value="${exposition.expositionId}" hidden="true"  ></td>--%>
                <%--<form action="CheckBox" method="POST" target="_blank">--%>
                <%--<input type="checkbox" name="publicationId" onclick="setButton"--%>
                <%--value="${publication.publicationId}"></label></td>--%>
                <%--<td> ${publication.publicationId}</td>--%>
            <td>${exposition.title}</td>
            <td>${exposition.price}</td>
            <td>${exposition.showroom.title}</td>
            <td>
                <input type="date" name="eventDate${exposition.expositionId}" value="${today}"
                       max="${exposition.finishDate}"
                       min="${today}">
            </td>
                <%--<td><a href="<c:url value='/edit/${publication.ticketId}'/>">Edit</a></td>--%>
            <td align="center">
                <input type="text" name="numberOfPersons${exposition.expositionId}" size=2 value="1" ><br/>
                    <%--<a href="<c:url value='/main'/>">Buy</a></td>--%>
                    <%--<form action="application" method="post">--%>
                    <%--<input type="hidden" name="publicationId" value="${publication.publicationId}"/>--%>
                    <%--<button type="Submit" name="command" value="basket"> Buy</button>--%>
                    <%--</form>--%>
            </td>
            <%--<td align="center"> <jsp:include page="ttt.jsp"/> </td>--%>

        </tr>
        </c:forEach>

</table>
<%--<form action="application" method="get" >--%>
<button type="Submit" name="command" value="payment">Buy now</button>
</form>
</body>
</html>
