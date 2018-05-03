<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 17/Apr/18
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html;
charset=Utf-8" />
<html>
<head>
    <title>BuyPage</title>
</head>
<body>
<h3>Buy now</h3>
<hr />
<c:out value="${name}, buy!"/>
<hr />
<form action="application" method="get" >
    <button  type="Submit" name="command" value="payment" >Buy now</button>
</form>
</body>
</html>
