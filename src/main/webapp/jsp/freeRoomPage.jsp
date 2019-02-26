<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="text"/>

<html>
<head>
    <title>Metropol</title>
    <link rel="shortcut icon" href="../image/emblem.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <link href="../css/index.css" rel="stylesheet">
</head>
<body>
<div class="main">

    <table class="table">
        <thead>
        <tr>
            <th><fmt:message key="room.number" /></th>
            <th><fmt:message key="room.numberSeats" /></th>
            <th><fmt:message key="room.typeApartment" /></th>
            <th><fmt:message key="room.cost" /></th>
            <th><fmt:message key="admin.settle" /></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${freeRoom}" varStatus="status">
            <tr>
                <td><c:out value="${room.number}" /></td>
                <td><c:out value="${room.numberSeats}" /></td>
                <td><c:out value="${ room.typeApartment}" /></td>
                <td><c:out value="${room.cost}" /></td>
                <td><a href="${pageContext.request.contextPath}/controller?command=list&roomNum=${room.number}&id=${idOrder}"><fmt:message key="admin.settle" /></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
