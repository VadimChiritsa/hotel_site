<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="text"/>
<head>
    <meta charset="UTF-8">
    <title>Metropol</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <link href="../css/index.css" rel="stylesheet">
    <link rel="shortcut icon" href="../image/emblem.png">
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid menu">
        <div class="navbar-header">
            <a class="navbar-brand name" href="#" style="color: black">Metropol</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/jsp/main.jsp"><fmt:message key="main.main" /></a></li>
            <li ><a href="${pageContext.request.contextPath}/jsp/fotoPage.jsp"><fmt:message key="main.foto" /></a></li>
            <li><a href="${pageContext.request.contextPath}/jsp/infoPage.jsp"><fmt:message key="main.info" /></a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/controller?command=authorization"><fmt:message key="main.autorization" /></a></li>
        </ul>
    </div>
</nav>
<div class="header">
    <fmt:message key="login.autorization" />
</div>
<div class="container-fluid ballet-body">
    <div class="jumbotron">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form name="LoginForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="LOGIN"/>
                    <div class="form-group ">
                        <p>
                            <b>
                                <fmt:message key="login" />
                            </b><span class="reqiured">*</span>
                            <br>
                            <input type="text" class="form-control" name="login" size="15"/>
                        </p>
                        <p>
                            <b>
                                <fmt:message key="password" />
                            </b><span class="reqiured">*</span>
                            <br>
                            <input type="password" class="form-control" name="password" size="15"/>
                        </p>
                    </div>
                    <br>
                    <p class="info">
                        <span class="reqiured">*</span> - <fmt:message key="info" />
                    </p>
                    <br>
                    <a href="${pageContext.request.contextPath}/controller?command=openpage&page=registration"><fmt:message key="registration"/></a>
                    <br>
                    <input type="submit" value=<fmt:message key="entry"/>>
                    <br/>
                    ${errorLoginPassMessage}
                    <br/>
                    ${wrongAction}
                    <br/>
                    ${nullPage}
                    <br/>
                </form>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
</div>
<div class="footer centerText">
    <fmt:message key="change.language"/>
    <a href="${pageContext.request.contextPath}/controller?command=language&lang=ru_RU&page=login">Ru</a>
    <a href="${pageContext.request.contextPath}/controller?command=language&lang=by_BY&page=login">Be</a>
    <a href="${pageContext.request.contextPath}/controller?command=language&lang=en_EN&page=login">Eng</a>
   </div>

</body>
