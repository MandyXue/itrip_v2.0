<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/5/27
  Time: 23:14
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
    <c:when test="${requestScope.result eq 'success'}">
        <h2>Welcome!!!. ${requestScope.name}</h2>
    </c:when>
    <c:when test="${requestScope.result eq 'fail'}">
        <h2>Sorry. username not exist or password is wrong.</h2>
    </c:when>
</c:choose>
</body>
</html>
