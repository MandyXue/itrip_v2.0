<%--
  Created by IntelliJ IDEA.
  User: mandyxue
  Date: 15/6/19
  Time: 下午11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>personal food</title>
    <%--set base path--%>
    <c:set var="bp" value="${pageContext.request.contextPath}"/>
</head>
<body>

aaa?
<c:forEach var="personalFood" items="${requestScope.personalFood}" >
    <h3><c:out value="${personalFood.foodname}"/></h3>
    <li><img src="<c:out value="${bp}/images/food/${personalFood.foodname}/1.jpg"/>" width="200" height="150"></li>
</c:forEach>
</body>
</html>
