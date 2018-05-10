<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 03/May/18
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--<fmt:requestEncoding value="UTF-8" />--%>
<fmt:setBundle basename="messages" var="messages"/>

<html>
<head>
  <title>Index JSP</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
</head>
<body>
<%--<form action="application" method="get" >--%>
  <%--<button  type="Submit" name="command" value="allExpositions" >View all Topics</button>--%>
<%--</form>--%>
<form action="application" method="get">
  <button type="Submit" name="command" value="allExpositions">
    <fmt:message bundle="${messages}" key="VIEW_ALL_TOPICS"/>
  </button>
</form>

<%--<div class="btn-group pull-right">--%>
  <%--<input type="submit" class="btn btn-default btn-sm" name="command" form="localEn" value="EN">--%>
  <%--<input type="submit" class="btn btn-default btn-sm" name="command" form="localRu" value="RU"/>--%>
<%--</div>--%>

<form action="application" method="get">
<button type="Submit" name="command" value="localRu">
    RU
  </button>
</form>
<form action="application" method="get">
  <button type="Submit" name="command" value="localEn">
    EN
  </button>
</form>
</body>
</html>
