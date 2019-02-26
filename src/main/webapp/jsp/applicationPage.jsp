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
            <li ><a href><fmt:message key="main.client.account" /></a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=openpage&page=addOrder"><fmt:message key="main.client.bookingRoom" /></a></li>
            <li  class="active"><a href="${pageContext.request.contextPath}/controller?command=personorder&id=${id}"><fmt:message key="main.client.reservation" /></a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="main.client.exit" /></a></li>
        </ul>
    </div>
</nav>
<div>
    <div class="main">
        <table class="table">
            <thead>
            <tr>
                <th><fmt:message key="room.numberSeats" /></th>
                <th><fmt:message key="room.typeApartment" /></th>
                <th><fmt:message key="admin.timeStay" /></th>
                <th><fmt:message key="admin.dataArrival" /></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${personOrderList}" varStatus="status">
                <tr>
                    <td><c:out value="${order.numberSeats}" /></td>
                    <td><c:out value="${ order.typeApartment}" /></td>
                    <td><c:out value="${order.timeStay}" /></td>
                    <td><c:out value="${ order.dataArrival }" /></td>
                    <td><a href="${pageContext.request.contextPath}/controller?command=deleteorder&idOrder=${order.idOrder}">Удалить</a></td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
