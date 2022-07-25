<%@page import="com.codeup.adlister.models.User" %>
<% User user = null;
    if (session != null) {
        user = (User) session.getAttribute("user");
    }
    if (user != null) {
        request.setAttribute("navbar", "<li><a href=\"/\">HOME</a></li>" + "<li><a href=\"/ads\">ADS</a></li>" + "<li><a href=\"/ads/create\">CREATE AD</a></li>\n" + "<li><a href=\"/profile\">PROFILE</a></li>" + "<li><a href=\"/logout\">LOGOUT</a></li>");
    } else {
        request.setAttribute("navbar", "<li><a href=\"/\">HOME</a></li>" + "<li><a href=\"/ads\">ADS</a></li>" + "<li><a href=\"/login\">LOGIN</a></li>");
    }
%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads"> Plant Lovers Sell</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            ${navbar}
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
