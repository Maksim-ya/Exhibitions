<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07/02/2018
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form name="registrationForm" method="POST" action="application">
    <input type="hidden" name="command" value="registration"/>
    <h2>Registration:</h2><br/>
    Login:<br/>
    <input type="text" name="login" value=""><br/>
    Password:<br/>
    <input type="password" name="password" value=""><br/>
    FullName:<br/>
    <input type="text" name="fullName" value=""><br/>
    Address:<br/>
    <input type="text" name="address" value="">
    <br/>
    <input type="submit" value="Enter">
</form>
</body>
</html>
