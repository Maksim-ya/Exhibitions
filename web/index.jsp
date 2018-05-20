
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>

<html>
<head>
  <title>Index JSP</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
</head>
<body>

<form action="exhibitions" method="get">
  <button type="Submit" name="command" value="allTopics">
    <fmt:message bundle="${messages}" key="VIEW_ALL_TOPICS"/>
  </button>
</form>

<form action="exhibitions" method="get">
<button type="Submit" name="command" value="localRu">
    RU
  </button>
</form>
<form action="exhibitions" method="get">
  <button type="Submit" name="command" value="localEn">
    EN
  </button>
</form>
</body>
</html>
