<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>Replenish An Account Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<h4>Enter number of replenishment</h4>
<form action="exhibitions" method="post">
    <td align="center">
        <input type="text" name="valueOfReplenish" value=""><br/>
    </td>
    <button type="Submit" name="command" value="replenish">Replenish</button>

</form>
</body>
</html>
