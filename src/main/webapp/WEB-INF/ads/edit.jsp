<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit a Ad"/>
    </jsp:include>
</head>
<body>

<div class="container">
    <h1>Update Your Plant</h1>
    <form action="/ads/details/edit" method="post">
        <div>
            <select name="category">
                <option value="indoor">Indoor</option>
                <option value="outdoor">Outdoor</option>
            </select>
        </div>
        <div class="form-group">
            <label for="plant_name">Plant Name</label>
            <input id="plant_name" name="plant_name" class="form-control" type="text" value="<c:out value="${ads.plant_name}"></c:out>">
        </div>

        <div class="form-group">
            <label for="location">Location</label>
            <input id="location" name="location" class="form-control" type="text" value="<c:out value="${ads.location}"></c:out>">
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input id="price" name="price" class="form-control" type="text" value="<c:out value="${ads.price}"></c:out>">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" ><c:out value="${ads.description}"></c:out></textarea>
        </div>
        <div class="form-group">
            <label for="photo">Plant Photo</label>
            <input type="file" id="photo" name="filename">
            <input type="submit" class="btn btn-block btn-primary">
        </div>

        <input type="hidden" name="id" id="id" value="${ads.id}">
    </form>
</div>
</body>
</html>
