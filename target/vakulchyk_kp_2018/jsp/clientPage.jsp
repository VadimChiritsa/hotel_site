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
<div class="container-fluid ballet-body">
    <div class="jumbotron">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <c:forEach var="client" items="${clientList}" varStatus="status">

                    <p>
                        <b>
                            <fmt:message key="client.surname"/>
                        </b>
                        <c:out value="${ client.surname}"/>
                    </p>
                    <p>
                        <b>
                            <fmt:message key="client.name"/>
                        </b>
                        <c:out value="${ client.name }"/>
                    </p>
                    <p>
                        <b>
                            <fmt:message key="client.phone"/>
                        </b>
                        <c:out value="${ client.phone}"/>
                    </p>
                    <p>
                        <b>
                            <fmt:message key="client.discount"/>
                        </b>
                        <c:out value="${client.discount}"/>
                    </p>
                    <p>
                        <b>
                            <fmt:message key="client.passportNumber"/>
                        </b>
                        <c:out value="${ client.passportNumber }"/>
                    </p>

                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
