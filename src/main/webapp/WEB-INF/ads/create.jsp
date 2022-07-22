<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Create a new Ad</h1>
    <form action="/ads/create" method="post">
        <div>
            <select name="category">
                <option value="indoor">Indoor</option>
                <option value="outdoor">Outdoor</option>
            </select>
        </div>
        <div class="form-group">
            <label for="plant_name">Plant Name</label>
            <input id="plant_name" name="plant_name" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="location">Location</label>
            <input id="location" name="location" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input id="price" name="price" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="photo">Plant Photo</label>
            <input type="file" id="photo" name="filename">
            <input type="submit" class="btn btn-block btn-primary">
        </div>
    </form>
</div>
</body>
</html>
