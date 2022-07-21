<%--
  Created by IntelliJ IDEA.
  User: alexrios
  Date: 7/21/22
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Details" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Look at the details on this plant!</h1>


        <div class="col-md-6">
            <h2><c:out value="${ads.plant_name}"></c:out></h2>
            <p><c:out value="${ads.description}"></c:out></p>
            <p><c:out value="${ads.category}"></c:out></p>

        </div>
</div>