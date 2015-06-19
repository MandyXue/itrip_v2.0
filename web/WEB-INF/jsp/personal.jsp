
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/6/10
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<a href=<c:url value="/personal" >
    <c:param name="type" value="1"/>
       <c:param name="s_or_f" value="spot"/>
  </c:url>>package</a>
<a href=<c:url value="/personal" >
     <c:param name="type" value="2"/>
       <c:param name="s_or_f" value="spot"/>
</c:url>>couple</a>
<a href=<c:url value="/personal" >
     <c:param name="type" value="3"/>
       <c:param name="s_or_f" value="spot"/>
</c:url>>house</a>
<a href=<c:url value="/personal" >
       <c:param name="type" value="1"/>
       <c:param name="s_or_f" value="food"/>
</c:url>>food</a>

<c:forEach var="personalSpot" items="${requestScope.personalSpot}" >
  <h3><c:out value="${personalSpot.spotname}"/></h3>
  <li><img src="<c:out value="${bp}/images/trip/${personalSpot.spotname}/1.jpg"/>" width="200" height="150"></li>
</c:forEach>
</body>
</html>
