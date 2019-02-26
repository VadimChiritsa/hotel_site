<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/taglib.tld" prefix="tag"%>
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
            <li class="active"><a>Бронь</a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=resident">Заселенные номера</a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=logout">Выход</a></li>
        </ul>
    </div>
</nav>
<div class="main">
    <tag:greetings login="${loginAdmin}" />
    <table class="table">
        <thead>
        <tr>
            <th><fmt:message key="admin.idOrder" /></th>
            <th><fmt:message key="admin.numberOfSets" /></th>
            <th><fmt:message key="admin.idClient" /></th>
            <th><fmt:message key="admin.typeApartment" /></th>
            <th><fmt:message key="admin.timeStay" /></th>
            <th><fmt:message key="admin.dataArrival" /></th>
            <th><fmt:message key="admin.settle" /></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderLogic}" varStatus="status">
            <tr>
                <td><c:out value="${order.idOrder}" /></td>
                <td><c:out value="${order.numberSeats}" /></td>
                <td><a href="${pageContext.request.contextPath}/controller?command=infoClient&id=${order.idClient}"><c:out value="${order.idClient}" /></a></td>
                <td><c:out value="${ order.typeApartment}" /></td>
                <td><c:out value="${order.timeStay}" /></td>
                <td><c:out value="${ order.dataArrival }" /></td>
                <td><a href="${pageContext.request.contextPath}/controller?command=takefreeroom&id=${order.idOrder}"><fmt:message key="admin.settle" /></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
