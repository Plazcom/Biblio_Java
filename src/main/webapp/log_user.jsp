<%--
  Created by IntelliJ IDEA.
  User: Lou
  Date: 1/7/2025
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="main.css"%></style>
</head>
<body>
<center>
    <header class="main-header">
        <div class="logo">
            <img src="images/logo.png" alt="Votre Logo">
        </div>
        <nav class="main-nav">
            <ul>
                <li><a href='log_user.jsp?page=1' class="nav-link">Accueil</a></li>
                <li><a href='log_user.jsp?page=2' class="nav-link">Mes locations</a></li>
                <li><a href='log_user.jsp?page=3' class="nav-link">Profil</a></li>
                <li><a href='main.jsp?page=1' class="nav-link">Deconnexion</a></li>
            </ul>
        </nav>
</header>
</center>
</body>
</html>
