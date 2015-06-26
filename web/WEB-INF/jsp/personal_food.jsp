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
    <title>food</title>
    <meta name="viewport" content="width=1120,user-scalable=no" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <%--set base path--%>
    <c:set var="bp" value="${pageContext.request.contextPath}"/>
    <!-- <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400" rel="stylesheet" type="text/css" /> -->
    <!--[if lte IE 8]><script src="js/html5shiv.js"></script>-->
    <script src="${bp}/external/gallery/js/jquery.min.js"></script>
    <script src="${bp}/external/gallery/js/jquery.poptrox.min.js"></script>
    <script src="${bp}/external/gallery/js/config.js"></script>
    <script src="${bp}/external/gallery/js/skel.min.js"></script>
    <script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie-emulation-modes-warning.js"></script>
    <noscript>
        <link rel="stylesheet" href="${bp}/external/gallery/css/skel-noscript.css" />
        <link rel="stylesheet" href="${bp}/external/gallery/css/style.css" />
        <link rel="stylesheet" href="${bp}/external/gallery/css/style-desktop.css" />
        <link rel="stylesheet" href="${bp}/external/gallery/css/style-noscript.css" />
    </noscript>
    <link href="${bp}/external/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <!-- <link href="css/about.css" rel="stylesheet"> -->
    <link href="${bp}/css/sign.css" rel="stylesheet">
    <link href="${bp}/css/personal.css" rel="stylesheet">
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
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="home">Home</a></li>
                        <li><a href="about">About</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle name-responsive" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                                <c:out value="${sessionScope.get('userId')}"></c:out>
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li class="text-center"><a href="personal?s_or_f=spot">Trip</a></li>
                                <li class="text-center"><a href="personal?s_or_f=food">Food</a></li>
                                <li class="text-center"><a href="userupload">Upload</a></li>
                            </ul>
                        </li>
                        <li><a class="name-responsive" href="signout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>
                        <!-- <li class="col-md-6"><a class="name-responsive" href="#">Administrator</a></li> -->
                        <!-- <li class="col-md-6"><a class="name-responsive" href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li> -->
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
    </div>
</div>

<div id="main">
    <div id="reel">
        <!-- Header Item -->
        <div id="header" class="item" data-width="200">
            <h1 class="title-text">food</h1>
        </div>
        <!-- Thumb Items -->
        <c:forEach var="personalFood" items="${requestScope.personalFood}" >
            <article class="item thumb" data-width="282">
                <h2 class="name-text"><c:out value="${personalFood.foodname}"/></h2>
                <a href="food?foodName=${personalFood.foodname}&province=sichuan">
                    <img src="<c:out value="${bp}/images/food/${personalFood.foodname}/1.jpg"/>" width="200" height="150">
                </a>
            </article>
        </c:forEach>

    </div>
</div>

<footer class="signin-footer">
    <div class="signin-footer-text">
        <p>&copy; 2015 Enterprise Java Programming &middot; iTrip &middot; All rights reserved.</p>
    </div>
</footer>
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="${bp}/external/bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/vendor/holder.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
<!-- sign up, sign in js -->
<script src="${bp}/js/sign.js"></script>

</body>
</html>
