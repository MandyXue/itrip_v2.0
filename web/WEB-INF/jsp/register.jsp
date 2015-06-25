<%--
  Created by IntelliJ IDEA.
  User: mandyxue
  Date: 15/5/28
  Time: 上午12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>sign up</title>
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
    <script src="${bp}/external/dist/js/bootstrap.js"></script>

    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#register').submit(
                    function(event){
                        var username = $('#username').val();
                        var email = $('#email').val();
                        var password = $('#password').val();
                        var password2 = $('#password2').val();
                        var data = 'username='
                                + encodeURIComponent(username)
                                + '&email='
                                + encodeURIComponent(email)
                                + '&password='
                                + encodeURIComponent(password)
                                + '&password2='
                                + encodeURIComponent(password2);
                        if(username == '') {
                            alert("用户名不能为空");
                            return false;
                        }
                        if(email == '') {
                            alert("email不能为空");
                            return false;
                        }
                        if(password == '') {
                            alert("密码不能为空");
                            return false;
                        }
                        if(password2 == '') {
                            alert("重复输入密码不能为空");
                            return false;
                        }
                        $.ajax({
                            url : $('#register').attr("action"),
                            data : data,
                            type : "POST",
                            success : function(response) {
                                if(response=="success"){
                                    window.location.href = document.referrer;
                                }else if(response=="userExist"){
                                    $('#nameResult').replaceWith('<span id="nameResult"><span class="glyphicon glyphicon-remove" aria-hidden="true">This user has existed</span>');
                                    $('#pwd2Result').replaceWith('<span id="pwd2Result"></span>');
                                    $('#emailResult').replaceWith('<span id="emailResult"></span>');
                                }else if(response=="emailExist") {
                                    $('#emailResult').replaceWith('<span id="emailResult"><span class="glyphicon glyphicon-remove" aria-hidden="true">This email has been registered</span>');
                                    $('#nameResult').replaceWith('<span id="nameResult"></span>');
                                    $('#pwd2Result').replaceWith('<span id="pwd2Result"></span>');
                                }else if(response=="pwdWrong") {
                                    $('#pwd2Result').replaceWith('<span id="pwd2Result"><span class="glyphicon glyphicon-remove" aria-hidden="true">The two input should be the same</span>');
                                    $('#nameResult').replaceWith('<span id="nameResult"></span>');
                                    $('#emailResult').replaceWith('<span id="emailResult"></span>');
                                }else{
                                    $('#pwd2Result').replaceWith('<span id="pwd2Result"><span class="glyphicon glyphicon-remove" aria-hidden="true">Invalid input</span>');
                                    $('#nameResult').replaceWith('<span id="nameResult"></span>');
                                    $('#emailResult').replaceWith('<span id="emailResult"></span>');
                                }
                            },
                            error : function(xhr,status,error){
                                alert(xhr.responseText);
                            }
                        });
                        return false;
                    });
        });
    </script>

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
                        <button type="button" class="btn btn-signup navbar-btn" disabled="disabled">Sign up</button>
                        <button type="button" onclick="signin()" class="btn btn-signin navbar-btn">Sign in</button>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </nav>
    </div>
</div>

<div class="page-container">
    <div class="container">
        <h1 class="text-center top-and-bottom register">Start Your journey in iTrip</h1>
    </div>
    <form id="register" action="register/result" method="post">
        <div class="form-group">
            <label for="username" class="text-left">Username</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter username"/>
            <label class="invalid-input-alert">
                <span id="nameResult"></span>
            </label>
        </div>
        <div class="form-group">
            <label for="email" class="text-left">Email Address</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email"/>
                <label class="invalid-input-alert">
                <span id="emailResult"></span>
            </label>
        </div>
        <div class="form-group">
            <label for="password" class="text-left">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password"/>
            <label class="invalid-input-alert"></label>
        </div>
        <div class="form-group">
            <label for="password2" class="text-left">Confrim your password</label>
            <input type="password" class="form-control" id="password2" name="password2"
                   placeholder="Confrim your password">
            <label class="invalid-input-alert">
                <span id="pwd2Result"></span>
            </label>
        </div>
        <button type="submit" class="btn btn-primary top-and-bottom submit">Join iTrip</button>
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
<%--<script src="${bp}/external/log/js/scripts.js"></script>--%>
<!-- sign up, sign in js -->
<script src="${bp}/js/sign.js"></script>

<%--<script>--%>

    <%--jQuery(document).ready(function() {--%>

        <%--$('.page-container form').submit(function(){--%>
            <%--var username = $(this).find('.username').val();--%>
            <%--var password = $(this).find('.password').val();--%>
            <%--var email = $(this).find('.email').val();--%>
            <%--if(username == '') {--%>
                <%--$(this).find('.error').fadeOut('fast', function(){--%>
                    <%--$(this).css('top', '27px');--%>
                <%--});--%>
                <%--$(this).find('.error').fadeIn('fast', function(){--%>
                    <%--$(this).parent().find('.username').focus();--%>
                <%--});--%>
                <%--return false;--%>
            <%--}--%>
            <%--if(password == '') {--%>
                <%--$(this).find('.error').fadeOut('fast', function(){--%>
                    <%--$(this).css('top', '96px');--%>
                <%--});--%>
                <%--$(this).find('.error').fadeIn('fast', function(){--%>
                    <%--$(this).parent().find('.password').focus();--%>
                <%--});--%>
                <%--return false;--%>
            <%--}--%>
        <%--});--%>

        <%--$('.page-container form .username, .page-container form .password').keyup(function(){--%>
            <%--$(this).parent().find('.error').fadeOut('fast');--%>
        <%--});--%>

    <%--});--%>
<%--</script>--%>

<%--<div class="page-container">--%>
<%--<h1>Join Us</h1>--%>
<%--<form action="register" method="post">--%>
<%--<input type="text" name="username" class="username" placeholder="username">--%>
<%--<input type="text" name="email" class="email" placeholder="email address">--%>
<%--<input type="password" name="password" class="password" placeholder="password">--%>
<%--<input type="password" name="password2" class="password2" placeholder="confirm your password">--%>
<%--<button type="submit">submit</button>--%>
<%--<div class="error"><span>+</span></div>--%>
<%--</form>--%>
<%--</div>--%>


</body>

</html>
