<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="controller.*" %>

<%Membre unMembre = null;%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Biblio Java</title>
    <style><%@include file="main.css"%></style>
</head>
    <body>
        <header class="main-header">
            <div class="logo">
                <img src="images/logo.png" alt="Votre Logo">
            </div>
            <nav class="main-nav">
                <ul>
                    <li><a href="main.jsp?page=0" class="nav-link">Accueil</a></li>
                    <li><a href="main.jsp?page=1" class="nav-link">Nos Offres</a></li>
                    <ul class="bis-nav">
                        <li><a href='main.jsp?page=2' class="inscription-link">S'inscrire</a></li>
                        <li><a href='main.jsp?page=3' class="secondary-link">Se connecter</a></li>
                    </ul>
                </ul>
            </nav>
        </header>
        <div class="hero_wrapper">
            <%
                if (request.getParameter("page") != null) {
                    switch(Integer.parseInt(request.getParameter("page"))) {
                        case 0 : %> <%@ include file="accueil.jsp" %> <% break;
                        case 1 : %> <%@ include file="offres.jsp" %> <% break;
                        case 2 : %> <%@ include file="signin.jsp" %> <% break;
                        case 3 : %> <%@ include file="login.jsp" %> <% break;
                    }
                } else {
                    %> <%@ include file="accueil.jsp" %> <%
                }
            %>
        </div>
    </body>
</html>