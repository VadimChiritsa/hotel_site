<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}" scope="session" />
<fmt:setBundle basename="text"/>

<html>
<head>
    <title>Metropol</title>

    <link rel="stylesheet" type="text/css" href="../css/index.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="shortcut icon" href="../image/emblem.png">
</head>
<body>
<div class="header"></div>
<div class="main">
    <form name="registration" method="POST" action="controller">
        <input type="hidden" name="command" value="registration"/>
        <p>
            <b><fmt:message key="registration.surname" /></b><span class="reqiured">*</span>
            <br>
            <input type="text" class="form-control" name="surname" size="15"/>
        </p>
        <p>
            <b><fmt:message key="registration.name" /></b><span class="reqiured">*</span>
            <br>
            <input type="text" class="form-control" name="name" size="15"/>
        </p>
        <p>
            <b><fmt:message key="registration.phone" /></b><span class="reqiured">*</span>
            <br>
            <input type="text" class="form-control" name="phone" size="15"/>
        </p>
        <p>
            <b><fmt:message key="registration.passport" /></b><span class="reqiured">*</span>
            <br>
            <input type="text" class="form-control" name="passportNumber" size="15"/>
        </p>
        <p>
            <b><fmt:message key="registration.login" /></b><span class="reqiured">*</span>
            <br>
            <input type="text" class="form-control" name="login" size="15"/>
        </p>
        <p>
            <b><fmt:message key="registration.password" /></b><span class="reqiured">*</span>
            <br>
            <input type="password" class="form-control" name="password" size="15"/>
        </p>
        <p>
            <b><fmt:message key="registration.secondpassword" /></b><span class="reqiured">*</span>
            <br>
            <input type="password" class="form-control" name="secondPassword" size="15"/>
        </p>

        <br>
        <p class="info">
            <span class="reqiured">*</span> - <fmt:message key="info" />
        </p>
        <br>
        <input type="submit" value=<fmt:message key="registration"/>>
    </form>

</div>
<div class="footer centerText">
    <fmt:message key="change.language"/>
    <a href="${pageContext.request.contextPath}/controller?command=language&lang=ru_RU&page=registration">Ru</a>
    <a href="${pageContext.request.contextPath}/controller?command=language&lang=by_BY&page=registration">Be</a>
    <a href="${pageContext.request.contextPath}/controller?command=language&lang=en_EN&page=registration">Eng</a>
</div>
</body>
</html>
