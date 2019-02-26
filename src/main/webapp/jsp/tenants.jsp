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
            <li><a href="${pageContext.request.contextPath}/jsp/menuAdmin.jsp">Бронь</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/controller?command=resident">Заселенные номера</a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=logout">Выход</a></li>
        </ul>
    </div>
</nav>
<div class="main">
<table class="table">
    <thead>
    <tr>
        <th><fmt:message key="room.cost" /></th>
        <th><fmt:message key="admin.idOrder" /></th>
        <th><fmt:message key="room.number" /></th>
        <th><fmt:message key="admin.evict" /></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="resident" items="${resident}" varStatus="status">
        <tr>
            <td><c:out value="${resident.coast}" /></td>
            <td><c:out value="${resident.idOrder}" /></td>
            <td><c:out value="${ resident.numderRoom}" /></td>
            <td><a href="${pageContext.request.contextPath}/controller?command=deleteresident&id=${resident.idOrder}&number=${ resident.numderRoom}"><fmt:message key="admin.evict" /></a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
