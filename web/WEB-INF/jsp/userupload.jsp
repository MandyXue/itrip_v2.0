<%--
  Created by IntelliJ IDEA.
  User: mandyxue
  Date: 15/6/18
  Time: 下午8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>administrator</title>
    <%--set base path--%>
    <c:set var="bp" value="${pageContext.request.contextPath}"/>

    <!-- Bootstrap core CSS -->
    <link href="${bp}/external/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${bp}/css/administrator.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie-emulation-modes-warning.js"></script>
    <link href="${bp}/css/sign.css" rel="stylesheet">
    <link href="${bp}/css/administrator.css" rel="stylesheet">

</head>

<body>

<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">iTrip</a>
                </div>
                <div id="navbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="home">Home</a></li>
                        <li><a href="about">About</a></li>
                    </ul>
                    <!-- get session -->
                    <c:if test="${sessionScope.get('userId')!=null}">

                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a class="dropdown-toggle name-responsive" data-toggle="dropdown" href="#" role="button"
                                   aria-expanded="false">
                                    <c:out value="${sessionScope.get('userId')}"></c:out>
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu" role="menu">
                                    <li class="text-center"><a href="personal?s_or_f=spot">Trip</a></li>
                                    <li class="text-center"><a href="personal?s_or_f=food">Food</a></li>
                                    <li class="text-center"><a href="userupload">Upload</a></li>
                                </ul>
                            </li>
                            <li><a class="name-responsive" href="signout"><span class="glyphicon glyphicon-log-out"
                                                                                aria-hidden="true"></span></a></li>
                        </ul>
                    </c:if>
                    <!-- no session -->
                    <%--<c:if test="${sessionScope.get('userId')==null}">--%>
                        <%--<ul class="nav navbar-nav navbar-right">--%>
                            <%--<button type="button" onclick="signup()" class="btn btn-signup navbar-btn">Sign up</button>--%>
                            <%--<button type="button" onclick="signin()" class="btn btn-signin navbar-btn">Sign in</button>--%>
                        <%--</ul>--%>
                    <%--</c:if>--%>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container">
    <div class="row">
        <%--<div class="col-sm-12 col-sm-offset-3 col-md-10 col-md-offset-2 main">--%>
            <h1 class="page-header">Administrator</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Spot/Food</th>
                        <th>Picture</th>
                        <th>Y/N</th>
                        <th>Description</th>
                        <th>Y/N</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="userupload" items="${requestScope.userUpload}">
                        <tr>
                            <td>${userupload.spotfood}</td>
                            <td>
                                <%--<a href="#" class="link">${uploadEntities.pictures}</a>--%>
                                <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#picture" data-whatever="@mdo">
                                    View the picture
                                </button>
                                <div class="modal fade" id="picture" tabindex="-1" role="dialog" aria-labelledby="pictureLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="pictureLabel">${userupload.spotfood}</h4>
                                            </div>
                                            <div class="modal-body">
                                                <img class="img-responsive" src="${bp}/${userupload.pictures}">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <%--<td><a href="valid?userName=${uploadEntities.username}&spotfood=${uploadEntities.spotfood}&type=pictures">${uploadEntities.pvalid}</a></td>--%>
                            <td>
                                <c:choose>
                                    <c:when test="${userupload.pvalid==-1}">
                                        not passed
                                    </c:when>
                                    <c:when test="${userupload.pvalid==1}">
                                        passed
                                    </c:when>
                                    <c:otherwise>
                                        not verified
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <%--<a href="#" class="link">Description</a>--%>
                                <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#description" data-whatever="@mdo">
                                    View the description
                                </button>
                                <div class="modal fade" id="description" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                <h4 class="modal-title" id="exampleModalLabel">${userupload.spotfood}</h4>
                                            </div>
                                            <div class="modal-body">
                                                <p>${userupload.description}</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <%--<td><a href="valid?userName=${uploadEntities.username}&spotfood=${uploadEntities.spotfood}&type=description">${uploadEntities.dvalid}</a></td>--%>
                            <td>
                                <c:choose>
                                    <c:when test="${userupload.dvalid==-1}">
                                        not passed
                                    </c:when>
                                    <c:when test="${userupload.dvalid==1}">
                                        passed
                                    </c:when>
                                    <c:otherwise>
                                        not verified
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        <%--</div>--%>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="${bp}/external/dist/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/vendor/holder.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

<%--TODO:ajax 对／错 button ＝》替换成一个button--%>