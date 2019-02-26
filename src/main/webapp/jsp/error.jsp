<%--
  Created by IntelliJ IDEA.
  User: igorg
  Date: 30.01.2018
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
    <link rel="shortcut icon" href="../image/emblem.png">
</head>
<body>
    Request form ${pageContext.errorData.requestURI} is failed
<br/>
Servlet name or type: ${pageContext.errorData.servletName}
<br/>
Exception: ${pageContext.errorData.throwable}
</body>
</html>
