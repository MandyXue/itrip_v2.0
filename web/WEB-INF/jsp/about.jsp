<%--
  Created by IntelliJ IDEA.
  User: mandyxue
  Date: 15/6/11
  Time: 下午1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <%--set base path--%>
    <c:set var="bp" value="${pageContext.request.contextPath}"/>

    <title>iTrip</title>

    <!-- Bootstrap core CSS -->
    <!-- <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"> -->
    <link href="${bp}/external/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- bootstrap js -->
    <script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- iTrip style-->
    <link href="${bp}/css/about.css" rel="stylesheet">
    <link href="${bp}/css/sign.css" rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
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
                        <li class="active"><a href="about">About</a></li>
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
                                </ul>
                            </li>
                            <li><a class="name-responsive" href="signout"><span class="glyphicon glyphicon-log-out"
                                                                                aria-hidden="true"></span></a></li>
                            <!-- <li class="col-md-6"><a class="name-responsive" href="#">Administrator</a></li> -->
                            <!-- <li class="col-md-6"><a class="name-responsive" href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li> -->
                        </ul>
                    </c:if>
                    <!-- no session -->
                    <c:if test="${sessionScope.get('userId')==null}">
                        <ul class="nav navbar-nav navbar-right">
                            <button type="button" onclick="signup()" class="btn btn-signup navbar-btn">Sign up</button>
                            <button type="button" onclick="signin()" class="btn btn-signin navbar-btn">Sign in</button>
                        </ul>
                    </c:if>
                </div>
                <!--/.nav-collapse -->
            </div>
        </nav>
    </div>
</div>


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->
<main class="container">
    <!-- descriptions -->

    <!-- team description -->

    <div class="container marketing">
        <div class="jumbotron team-work">
            <h1>Our team</h1>

            <p>This is our team members and the duties of each member.</p>
        </div>
        <!-- Three columns of text below the carousel -->
        <div class="row">
            <div class="col-xs-6 col-sm-3 text-center">
                <img class="img-circle" src="${bp}/images/photo/pic_daizhengcheng.png" width="140" height="140">

                <h2>Jojen Dai</h2>

                <p>Project Manager</p>

                <p>Web Back-End Engineer</p>

                <p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> Contact:</p>

                <p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> 13564039693@163.com</p>
                <!-- <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
            </div>
            <!-- /.col-lg-4 -->
            <div class="col-xs-6 col-sm-3 text-center">
                <img class="img-circle" src="${bp}/images/photo/pic_yanganqi.png" width="140" height="140">

                <h2>Angel Yang</h2>

                <p>System Architect</p>

                <p>Web Back-End Engineer</p>

                <p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> Contact:</p>

                <p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> 13564039693@163.com</p>
                <!-- <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
            </div>
            <!-- /.col-lg-4 -->
            <div class="col-xs-6 col-sm-3 text-center">
                <img class="img-circle" src="${bp}/images/photo/pic_xuemengdi.png" width="140" height="140">

                <h2>Mandy Xue</h2>

                <p>UI Designer</p>

                <p>Web Front-End Engineer</p>

                <p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> 13564039693</p>

                <p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> 13564039693@163.com</p>
                <!-- <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
            </div>
            <!-- /.col-lg-4 -->
            <div class="col-xs-6 col-sm-3 text-center">
                <img class="img-circle" src="${bp}/images/photo/pic_liwendi.png" width="140" height="140">

                <h2>Owen Lee</h2>

                <p>Software Testing Engineer</p>

                <p>Database Designer</p>

                <p><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> Contact:</p>

                <p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> 13564039693@163.com</p>
                <!-- <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p> -->
            </div>
            <!-- /.col-lg-4 -->
        </div>
        <!-- /.row -->
    </div>

    <!-- START THE FEATURETTES -->

    <hr class="featurette-divider">
    <div class="jumbotron team-work">
        <h1>Our work</h1>

        <p>This is what we have done and our hope.</p>
    </div>

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">View different spots.</h2>

            <p class="lead">Click on different provinces to view different spots.</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive center-block about-pic" src="${bp}/images/about/about-1.jpg"
                 alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
            <h2 class="featurette-heading">View details.<span class="text-muted">Amazing pictures.</span></h2>

            <p class="lead">Click on the spot, then you can see the descriptions and photos of the spot. Give a thumb up
                for what you want. You can also add your own photo to our website.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
            <img class="featurette-image img-responsive center-block about-pic" src="${bp}/images/about/about-2.jpg"
                 alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">Have a good appetite! <span class="text-muted">Delicious food.</span></h2>

            <p class="lead">On the right hand bar, you can see delicious food from the same province. </p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive center-block about-pic" src="${bp}/images/about/about-3.jpg"
                 alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">
    <!-- /END THE FEATURETTES -->
    </div>
    <!-- FOOTER -->
    <footer class="footer">
        <div class="footer-text">
            <p>&copy; 2015 Enterprise Java Programming &middot; <a href="home">iTrip</a> &middot; All rights reserved.
                <img src="images/toparrow.png" id="backToTop"></p>
        </div>
    </footer>
</main>
<!-- /.container -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/vendor/holder.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
<!-- sign up, sign in js -->
<script src="${bp}/js/sign.js"></script>
<!-- back to top js -->
<script>
    $(document).ready(function () {
        $('#backToTop').click(function () {
            $("html, body").animate({
                scrollTop: 0
            }, "slow");
        });
    });
</script>
</body>
</html>
