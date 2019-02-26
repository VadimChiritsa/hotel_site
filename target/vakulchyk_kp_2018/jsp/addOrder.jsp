<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
            <li><a href><fmt:message key="main.client.account" /></a></li>
            <li  class="active"><a href="${pageContext.request.contextPath}/controller?command=openpage&page=addOrder"><fmt:message key="main.client.bookingRoom" /></a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=personorder&id=${id}"><fmt:message key="main.client.reservation" /></a></li>
            <li><a href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="main.client.exit" /></a></li>
        </ul>
    </div>
</nav>
<div class="main">

    <form name="rgistration" method="POST" action="controller">
        <input type="hidden" name="command" value="addorder"/>
        <p>
            <b><fmt:message key="room.typeApartment" /></b><span class="reqiured">*</span>
            <br>
            <Br>
            <label><input type="checkbox" name="typeApartment" value="lux"><fmt:message key="room.lux" /></label>
            <Br>
            <label><input type="checkbox" name="typeApartment" value="junior suite"><fmt:message key="room.economy" /></label>
            <Br>
            <label><input type="checkbox" name="typeApartment" value="economy"><fmt:message key="room.juniorSuite" /></label>
            <Br>
        </p>
        <p>
            <b><fmt:message key="admin.timeStay" /></b><span class="reqiured">*</span>
            <br>
            <input type="text" class="form-control" name="time" size="15"/>
        </p>
        <p>
            <b><fmt:message key="room.numberSeats" /></b><span class="reqiured">*</span>
            <br>
            <input type="text" class="form-control" name="numberSeats" size="15"/>
        </p>
        <p>
            <b><fmt:message key="admin.dataArrival" /></b><span class="reqiured">*</span>
            <br>
            <input type="date" class="form-control" name="data">
        </p>
        <br>
        <p class="info">
            <span class="reqiured">*</span> - <fmt:message key="info" />
        </p>
        <br>
        <input type="submit" value=<fmt:message key="registration"/>>
    </form>
</div>
</body>
</html>
