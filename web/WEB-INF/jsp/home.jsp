<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/5/27
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>iTrip</title>
    <c:set var="bp" value="${pageContext.request.contextPath}"/>

    <!-- Bootstrap core CSS -->
    <link href="${bp}/external/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${bp}/external/dist/css/bootstrap.css" rel="stylesheet" type="text/css">
    <%--<link href="${bp}/external/bootstrap-3.3.4/fonts/glyphicons-halflings-regular.svg" rel="stylesheet" type="text/css">--%>
    <!-- Map css -->
    <link rel="stylesheet" type="text/css" href="${bp}/external/ammap/ammap.css">

    <!-- Custom styles for this template -->
    <link href="${bp}/css/home.css" rel="stylesheet" type="text/css">
    <link href="${bp}/css/sign.css" rel="stylesheet" type="text/css">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="${bp}/../../assets/js/ie8-responsive-file-warning.js" type="text/javascript"></script><![endif]-->
    <script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie-emulation-modes-warning.js"
            type="text/javascript"></script>
    <!--  Map js -->
    <script src="${bp}/external/ammap/ammap.js" type="text/javascript"></script>
    <script src="${bp}/external/ammap/maps/js/chinaLow.js" type="text/javascript"></script>
    <script src="${bp}/js/usrMap.js" type="text/javascript"></script>

</head>

<body>
<div class="back-wrapper">

    <c:out value="${bp}"></c:out>

    <div class="site-wrapper">
        <div class="site-wrapper-inner">
            <!-- navigation bar container -->
            <div class="navbar-wrapper">
                <div class="container">
                    <nav class="navbar navbar-inverse navbar-fixed-top">
                        <div class="container">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                        data-target="#navbar" aria-expanded="false" aria-controls="navbar">
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
                                    <ul class="nav navbar-nav navbar-nav-right2">
                                        <li class="dropdown">
                                            <a class="dropdown-toggle name-responsive" data-toggle="dropdown" href="#"
                                               role="button" aria-expanded="false">
                                                <c:out value="${sessionScope.get('userId')}"></c:out>
                                                <span class="caret"></span>
                                            </a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li class="text-center"><a href="personal?s_or_f=spot">Trip</a></li>
                                                <li class="text-center"><a href="personal?s_or_f=food">Food</a></li>
                                            </ul>
                                        </li>
                                        <li><a class="name-responsive" href="signout"><span
                                                class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>
                                        <!-- <li class="col-md-6"><a class="name-responsive" href="#">Administrator</a></li> -->
                                        <!-- <li class="col-md-6"><a class="name-responsive" href="#"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li> -->
                                    </ul>
                                </c:if>
                                <!-- no session -->
                                <c:if test="${sessionScope.get('userId')==null}">
                                    <ul class="nav navbar-nav navbar-nav-right">
                                        <button type="button" onclick="signup()" class="btn btn-signup navbar-btn">Sign
                                            up
                                        </button>
                                        <button type="button" onclick="signin()" class="btn btn-signin navbar-btn">Sign
                                            in
                                        </button>
                                    </ul>
                                </c:if>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
            <!-- navigation bar container -->
            <div class="cover-container">
                <div class="inner cover">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 map-bg">
                                <div class="info-text">
                                    <h1 class="cover-heading white-text">First, choose a province.</h1>
                                    <!-- <p class="lead white-text">First,choose a province.</p> -->
                                    <p class="lead white-text">
                                        <a id="goToProvince" class="btn btn-gotomap">
                                            <span class="glyphicon glyphicon-menu-down btn-text"
                                                  aria-hidden="true"></span>
                                        </a>
                                    </p>
                                </div>
                                <img id="provinceimg" src="images/transparent-back.gif" class="img-bg">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 map-bg">
                                <div class="info-text">
                                    <h1 class="cover-heading white-text">Second, view the spots name and choose
                                        one.</h1>
                                    <!-- <p class="lead white-text">First,choose a province.</p> -->
                                    <p class="lead white-text">
                                        <a id="goToSpot" class="btn btn-gotomap">
                                            <span class="glyphicon glyphicon-menu-down btn-text"
                                                  aria-hidden="true"></span>
                                        </a>
                                    </p>
                                </div>
                                <img id="spotimg" src="images/transparent-back.gif" class="img-bg">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 map-bg">
                                <div class="info-text">
                                    <h1 class="cover-heading white-text">Now you can start your own journey.</h1>
                                    <!-- <p class="lead white-text">First,choose a province.</p> -->
                                    <p class="lead white-text">
                                        <a id="goToMap" class="btn btn-gotomap">
                                            <span class="glyphicon glyphicon-menu-down btn-text"
                                                  aria-hidden="true"></span>
                                        </a>
                                    </p>
                                </div>
                                <!-- <img src="images/transparent-back.gif" class="img-bg"> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="map-wrapper">
        <div class="site-wrapper-inner">
            <div class="cover-container">
                <div class="inner cover">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 map-bg">
                                <div id="mapdiv" class="map-container"></div>
                                <img class="img-bg" src="images/map-background.png">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer class="home-footer">
        <div class="home-footer-text">
            <p>&copy; 2015 Enterprise Java Programming &middot; <a href="home">iTrip</a> &middot; All rights reserved.
                <img src="images/toparrow.png" id="backToTop"></p>
        </div>
    </footer>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- // <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js" type="text/javascript"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie10-viewport-bug-workaround.js"
        type="text/javascript"></script>
<!-- sign up, sign in js -->
<script src="${bp}/js/sign.js" type="text/javascript"></script>
<script>
    var map = AmCharts.makeChart("mapdiv", {
        type: "map",
        path: "external/ammap/",
        imagesSettings: {
            rollOverColor: "#ffffff",
            rollOverScale: 3,
            selectedScale: 3,
            selectedColor: "#ffffff",
        },
        areasSettings: {
            autoZoom: true,
            rollOverOutlineColor: "#347C01",
            selectedColor: "#347C01",
            color: "#a791b4",
            rollOverColor: "#347C01",
            rollOverOutlineThickness: 0.5
        },
        zoomControl: {
            buttonFillColor: "#a6bd7f",
            buttonRollOverColor: "#347C01"
        },
        dataProvider: provincesDataProvider,
        export: {
            enabled: true
        },
        smallMap: {}
    });
    function handleGoHome() {
        map.dataProvider = provincesDataProvider;
        map.validateNow();
    }
    function handleMapObjectClick(event) {
        if (event.mapObject.id == "backButton") {
            handleGoHome();
        }
    }
    // monitor when home icon was clicked and also go to continents map
    map.addListener("homeButtonClicked", handleGoHome);
    map.addListener("clickMapObject", handleMapObjectClick);
</script>
<!-- back to top js -->
<script>
    $(document).ready(function () {
        $('#backToTop').click(function () {
            $("html, body").animate({
                scrollTop: 0
            }, "slow");
        });
        $('#goToMap').click(function () {
            var scroll_offset = $("#mapdiv").offset();
            $("html, body").animate({
                scrollTop: scroll_offset.top
            }, "slow");
        });
        $('#goToSpot').click(function () {
            var scroll_offset = $("#spotimg").offset();
            $("html, body").animate({
                scrollTop: scroll_offset.top - 100
            }, "slow");
        });
        $('#goToProvince').click(function () {
            var scroll_offset = $("#provinceimg").offset();
            $("html, body").animate({
                scrollTop: scroll_offset.top - 100
            }, "slow");
        });
    });
</script>
</body>
</html>
