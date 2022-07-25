<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container justify-content-center align-content">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h2> Your contact email is: ${sessionScope.user.email}</h2>
        <h3>Happy Selling! :)</h3>
    </div>

</body>
</html>
