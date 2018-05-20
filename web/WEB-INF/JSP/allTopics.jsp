<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>Topics Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>

</head>
<body>
<h1>List of All Topics</h1>
<form action="exhibitions" method="get">

        <c:forEach items="${listOfTopics}" var="topic">
            <tr>
                    <button type="Submit" name="topic" value ="${topic}" >
                        <input  type="hidden" name="command" value="allExpositions"  /> ${topic}
                    </button>
            </tr>
        </c:forEach>
</form>
</body>
</html>
