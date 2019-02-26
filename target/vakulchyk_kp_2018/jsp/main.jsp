<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="text"/>
<head>
    <title>Metropol</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="../css/index.css" rel="stylesheet">

    <script type="text/javascript">
        <%@include file="../js/main.js"%>
    </script>
    <link rel="shortcut icon" href="../image/emblem.png">
</head>
<body style="height:1500px">


<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid menu">
        <div class="navbar-header">
            <a class="navbar-brand name" href="#" style="color: black">Metropol</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/jsp/main.jsp"><fmt:message key="main.main" /></a></li>
            <li ><a href="${pageContext.request.contextPath}/jsp/fotoPage.jsp"><fmt:message key="main.foto" /></a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/infoPage.jsp"><fmt:message key="main.info" /></a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=authorization"><fmt:message key="main.autorization" /></a></li>
        </ul>
    </div>
</nav>
<br/>
<div class="page-header">
    <h1> <fmt:message key="history.title" /></h1>
</div>
<div class="container" style="margin-top:50px">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            <li data-target="#carousel-example-generic" data-slide-to="3"></li>

        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <img src="http://metropol-moscow.ru/upload/iblock/137/137537b53b0068108a16315793c6cc6c.jpg" alt="..."
                     style="height:420px; width:1152px">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_0xaCuer3ULbxQWq9rSaOYah9v6Q08UIl0mAfx3Hgqd_M7659"
                     alt="..." style="height:420px; width:1152px">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img src="data:image/jpeg;base64,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"
                     alt="..." style="height:420px; width:1152px">
                <div class="carousel-caption">
                    ...
                </div>

            </div>
            <div class="item">
                <img src="http://moscowwalks.ru/wp-content/uploads/2014/01/05_metropol.jpg" alt="..."
                     style="height:420px; width:1152px">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <!-- Элементы управления -->
            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                <span class="glyphicon glyphicon-hand-left"></span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                <span class="glyphicon glyphicon-hand-right"></span>
            </a>
        </div>
    </div>

    <div class="container-fluid text-body">
        <p>
        <h1><fmt:message key="history.main" /></h1>
        <fmt:message key="history.part1" /><fmt:message key="history.part2" />
        <fmt:message key="history.part3" /> <fmt:message key="history.part4" />
        <fmt:message key="history.part5" />
        </p>
        <p>
            <fmt:message key="history.part6" /><fmt:message key="history.part7"/>
            <fmt:message key="history.part8" /><fmt:message key="history.part9"/>
            <fmt:message key="history.part10" /><fmt:message key="history.part11"/>
            <fmt:message key="history.part12" /><fmt:message key="history.part13"/>
            <fmt:message key="history.part14" /><fmt:message key="history.part15"/>
            <fmt:message key="history.part16" />
        </p>
    </div>
</div>
</body>
