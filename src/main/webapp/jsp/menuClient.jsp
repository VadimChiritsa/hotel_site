<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="text"/>
<html>
<head>
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
            <li class="active"><a href><fmt:message key="main.client.account" /></a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=openpage&page=addOrder"><fmt:message key="main.client.bookingRoom" /></a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=personorder&id=${id}"><fmt:message key="main.client.reservation" /></a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="main.client.exit" /></a></li>
        </ul>
    </div>
</nav>
<div class="main">
    <c:forEach var="client" items="${dataAboutClient}" varStatus="status">
        <p>
        <b>
            <fmt:message key="client.surname"/>
        </b>
        <c:out value="${ client.surname}" />
        </p>
        <p>
            <b>
                <fmt:message key="client.name"/>
            </b>
            <c:out value="${ client.name }" />
        </p>
        <p>
            <b>
                <fmt:message key="client.login"/>

            </b>
            <c:out value="${ client.login}" />
        </p>
        <p>
            <b>
                <fmt:message key="client.phone"/>
            </b>
            <c:out value="${ client.phone}" />
        </p>
        <p>
            <b>
                <fmt:message key="client.discount"/>
            </b>
            <c:out value="${client.discount}" />
        </p>
        <p>
            <b>
                <fmt:message key="client.passportNumber"/>

            </b>
            <c:out value="${ client.passportNumber }" />
        </p>


    </c:forEach>
</div>
</body>
</html>
