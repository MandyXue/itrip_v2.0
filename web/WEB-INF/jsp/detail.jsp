<%--
  Created by IntelliJ IDEA.
  User: mandyxue
  Date: 15/5/28
  Time: 上午12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <%--set base path--%>
    <c:set var="bp" value="${pageContext.request.contextPath}"/>

    <title>iTrip-detail</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--jquery script--%>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <%--thumb up script--%>
    <script src="${bp}/js/thumbUpAjax.js" type="text/javascript"></script>
    <%--bootstrap js--%>
    <script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie-emulation-modes-warning.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="${bp}/external/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${bp}/css/administrator.css" rel="stylesheet">
    <link href="${bp}/css/sign.css" rel="stylesheet">
    <link href="${bp}/css/detail.css" rel="stylesheet">

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
                                    <li class="text-center"><a href="#">Trip</a></li>
                                    <li class="text-center"><a href="#">Food</a></li>
                                </ul>
                            </li>
                            <li><a class="name-responsive" href="#"><span class="glyphicon glyphicon-log-out"
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
            </div>
        </nav>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Trip</a></li>
                <c:forEach var="spots" items="${requestScope.spots}">
                    <li><a href="spot?spotName=${spots.name}&province=innermongolia">${spots.name}</a></li>
                </c:forEach>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Food</a></li>
                <c:forEach var="foods" items="${requestScope.foods}">
                    <li><a href="food?foodName=${foods.name}&province=innermongolia">${foods.name}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="row">
                <div class="col-md-7">
                    <h1 class="trip-header text-right">
                        <c:if test="${requestScope.type=='spot'}">
                            <c:out value="${requestScope.spotDetail.name}"/>
                        </c:if>
                        <c:if test="${requestScope.type=='food'}">
                            <c:out value="${requestScope.foodDetail.name}"/>
                        </c:if>
                    </h1>
                </div>
                <div class="col-md-5">
                    <h1 class="trip-header text-left">
                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add
                        </button>
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="exampleModalLabel">New message</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form action="upload?spotfood=${spotfood}&type=${type}" enctype="multipart/form-data" method="post">
                                            <%--<div class="form-group">--%>
                                                <%--<label for="recipient-name" class="control-label">Recipient:</label>--%>
                                                <%--<input type="text" class="form-control" id="recipient-name">--%>
                                            <%--</div>--%>
                                            <div class="form-group">
                                                <label for="message-text" class="control-label">Upload your picture:</label>
                                                <input type="file" name="file1" id="file1"><br/><br/>
                                                <label for="message-text" class="control-label">Description:</label>
                                                <textarea class="form-control" id="message-text"name="description" rows="10" cols="30">
                                                    ${requestScope.description}
                                                </textarea>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary" name="upload" value="上传">Upload</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </h1>
                </div>
            </div>
            <div class="blog-post">
                <div class="carousel-container">
                    <div id="carousel" class="carousel slide" data-ride="carousel">
                        <!-- indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel" data-slide-to="1"></li>
                            <li data-target="#carousel" data-slide-to="2"></li>
                            <li data-target="#carousel" data-slide-to="3"></li>
                            <li data-target="#carousel" data-slide-to="4"></li>
                        </ol>
                        <!-- wrapper for slides -->
                        <c:if test="${type=='spot'}">
                            <div class="carousel-inner" role="listbox">
                                <div class="item active">
                                    <img src="<c:out value="${bp}/images/trip/${spotDetail.name}/1.jpg"/>" alt="pic-1">

                                    <div class="carousel-caption"></div>
                                </div>
                                <div class="item">
                                    <img src="<c:out value="${bp}/images/trip/${spotDetail.name}/2.jpg"/>" alt="pic-2">

                                    <div class="carousel-caption"></div>
                                </div>
                                <div class="item">
                                    <img src="<c:out value="${bp}/images/trip/${spotDetail.name}/3.jpg"/>" alt="pic-3">

                                    <div class="carousel-caption"></div>
                                </div>
                                <div class="item">
                                    <img src="<c:out value="${bp}/images/trip/${spotDetail.name}/4.jpg"/>" alt="pic-4">

                                    <div class="carousel-caption"></div>
                                </div>
                                <div class="item">
                                    <img src="<c:out value="${bp}/images/trip/${spotDetail.name}/5.jpg"/>" alt="pic-5">

                                    <div class="carousel-caption"></div>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${type=='food'}">
                            <div class="carousel-inner" role="listbox">
                                <div class="item active">
                                    <img src="<c:out value="${bp}/images/food/${foodDetail.name}/1.jpg"/>" alt="pic-1">

                                    <div class="carousel-caption"></div>
                                </div>
                                <div class="item">
                                    <img src="<c:out value="${bp}/images/food/${foodDetail.name}/2.jpg"/>" alt="pic-2">

                                    <div class="carousel-caption"></div>
                                </div>
                                <div class="item">
                                    <img src="<c:out value="${bp}/images/food/${foodDetail.name}/3.jpg"/>" alt="pic-3">

                                    <div class="carousel-caption"></div>
                                </div>
                                <div class="item">
                                    <img src="<c:out value="${bp}/images/food/${foodDetail.name}/4.jpg"/>" alt="pic-4">

                                    <div class="carousel-caption"></div>
                                </div>
                                <div class="item">
                                    <img src="<c:out value="${bp}/images/food/${foodDetail.name}/5.jpg"/>" alt="pic-5">

                                    <div class="carousel-caption"></div>
                                </div>
                            </div>
                        </c:if>
                        <!-- controls -->
                        <a href="#carousel" class="left carousel-control" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" area-hidden="true"></span>
                            <span class="sr-only">previous</span>
                        </a>
                        <a href="#carousel" class="right carousel-control" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" area-hidden="true"></span>
                            <span class="sr-only">next</span>
                        </a>
                    </div>
                </div>
            </div>
            <c:if test="${type=='spot'}">
                <div class="container">
                    <div class="row text-center">
                        <div class="col-md-4 text-center">
                            <a href="#" id="package">
                                <img class="img-circle thumb-up-img selected" src="${bp}/images/package-trip.png">
                            </a>

                            <div class="thumb-up-text">
                                <span id="package_number">${spotDetail.packageThumbs}</span>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <a href="#" id="couple">
                                <img class="img-circle thumb-up-img" src="${bp}/images/lover-trip.png">
                            </a>

                            <div class="thumb-up-text">
                                <span id="couple_number">${spotDetail.coupleThumbs}</span>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <a href="#" id="family">
                                <img class="img-circle thumb-up-img" src="${bp}/images/family-trip.png">
                            </a>

                            <div class="thumb-up-text">
                                <span id="family_number">${spotDetail.familyThumbs}</span>
                            </div>
                        </div>
                    </div>
                </div>
                <p>
                    <c:out value="${spotDetail.description}"/>
                </p>
            </c:if>
            <c:if test="${type=='food'}">
                <div class="container">
                    <div class="row text-center">
                        <div class="col-md-12 text-center">
                            <a href="#" id="thumbs">
                                <img class="img-circle thumb-up-img selected" src="${bp}/images/food_thumb.png">
                            </a>

                            <div class="thumb-up-text">
                                <span id="number">${foodDetail.thumbs}</span>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Thumbs--%>
                <%--<a href="#" id="thumbs">Thumbs</a>--%>
                <%--<span id="number">${foodDetail.thumbs}</span>--%>
                <p>
                    <c:out value="${foodDetail.description}"/>
                </p>
            </c:if>

            <footer class="footer">
                <div class="footer-text">
                    <hr class="featurette-divider">
                    <p>&copy; 2015 Enterprise Java Programming &middot; <a href="home">iTrip</a> &middot; All rights
                        reserved.</p>
                </div>
            </footer>
        </div>
    </div>
</div>

<!-- up button -->
<script src="${bp}/js/jquery.min.js"></script>
<script src="${bp}/js/hoverIntent.js"></script>
<script src="${bp}/js/superfish.js"></script>
<!-- bootstrap js -->
<script src="${bp}/external/bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/vendor/holder.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${bp}/external/bootstrap-3.3.4/docs/assets/js/ie10-viewport-bug-workaround.js"></script>
<script src="${bp}/js/slider/jquery.flexslider.js"></script>
<!-- sign up, sign in js -->
<script src="${bp}/js/sign.js" type="text/javascript"></script>
<script>
    Modernizr.load({
        test: Modernizr.placeholder,
        nope: '${bp}/js/placeholder.min.js'
    });
    function goToNewPagjgjje() {
        if (document.getElementById('target').value) {
            window.location.href = document.getElementById('target').value;
        }
    }
</script>
<script>
    $(document).ready(function () {
        $('ul.sf-menu').superfish({
            animation: {
                height: 'show'
            },
            delay: 400
        });
        $("img.scrollToTop").click(function () {
            $("html, body").animate({
                scrollTop: 0
            }, "slow");
        });
        $('.flexslider').flexslider();
        $('.flexcar').flexslider();
    });
</script>
</body>
</html>
