<%--
  Created by IntelliJ IDEA.
  User: sohny
  Date: 2020-03-30
  Time: 오전 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false" import="java.util.*" %>
<html>
<head>
    <title>시스템 점검중입니다.</title>
</head>
<body>
    <h4><c:out value="${exception.getMessage()}"></c:out> </h4>
    <ul>
        <c:forEach items="${exception.getStackTrace()}" var="stack">
            <li><c:out value="${stack}"></c:out></li>
        </c:forEach>
    </ul>
</body>
</html>
