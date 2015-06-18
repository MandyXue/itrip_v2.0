<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/5/27
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.result eq 'fail1'}">
        <h2>Sorry. Your username has been used.</h2>
    </c:when>
    <c:when test="${requestScope.result eq 'fail2'}">
        <h2>Sorry. Your email has been used.</h2>
    </c:when>
    <c:otherwise>
        <h3>Hello, ${requestScope.name}</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
