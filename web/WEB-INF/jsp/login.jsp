<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/5/27
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%--set base path--%>
    <c:set var="bp" value="${pageContext.request.contextPath}"/>

    <meta charset="utf-8">
    <title>sign in</title>

    <!-- CSS -->
    <link rel="stylesheet" href="${bp}/external/log/css/backslider.css">
    <link rel="stylesheet" href="${bp}/external/log/css/formstyle.css">
    <!-- Bootstrap core CSS -->
    <!-- <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"> -->
    <link href="${bp}/external/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${bp}/css/sign.css">
    <!-- bootstrap js -->
    <script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie-emulation-modes-warning.js"></script>

</head>

<body>

<div class="navbar-wrapper">
    <div class="container">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
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
                        <button type="button" onclick="signup()" class="btn btn-signup navbar-btn">Sign up</button>
                        <button type="button" class="btn btn-signin navbar-btn" disabled="disabled">Sign in</button>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </nav>
    </div>
</div>

<div class="page-container">
    <div class="container">
        <h1 class="text-center top-and-bottom">Sign In</h1>
    </div>
    <form action="login" method="post">
        <div class="form-group">
            <label for="username" class="text-left">Username</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
        </div>
        <div class="form-group">
            <label for="password" class="text-left">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-1"><input class="remember-me" type="checkbox"></div>
                <div class="col-md-8"><label class="remember-me-text">Remember me</label></div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary top-and-bottom submit">Submit</button>
    </form>
</div>
<footer class="signin-footer">
    <div class="signin-footer-text">
        <p>&copy; 2015 Enterprise Java Programming &middot; <a href="home">iTrip</a> &middot; All rights reserved.</p>
    </div>
</footer>

<!-- Javascript -->
<script src="${bp}/external/log/js/jquery-1.8.2.min.js"></script>
<script src="${bp}/external/log/js/supersized.3.2.7.min.js"></script>
<script src="${bp}/external/log/js/supersized-init.js"></script>
<script src="${bp}/external/log/js/scripts.js"></script>
<!-- sign up, sign in js -->
<script src="${bp}/js/sign.js"></script>

<%--<h1>Sign In</h1>--%>
<%--<form action="login" method="post">--%>
<%--<input type="text" name="username" class="username" placeholder="username">--%>
<%--<input type="password" name="password" class="password" placeholder="password">--%>
<%--<button type="submit">submit</button>--%>
<%--<div class="error"><span>+</span></div>--%>
<%--</form>--%>


</body>

</html>