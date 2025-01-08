<%--
  Created by IntelliJ IDEA.
  User: Lou
  Date: 1/7/2025
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="controller.*" %>
<%@ page import="java.util.*" %>

<%Membre unMembre = null;%>
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
                <li><a href='log_user.jsp?page=2' class="nav-link">Nos Offres</a></li>
                <li><a href='log_user.jsp?page=3' class="nav-link">Mes locations</a></li>
                <li><a href='log_user.jsp?page=4' class="nav-link">Profil</a></li>
                <li><a href='main.jsp?page=1' class="nav-link">Deconnexion</a></li>
            </ul>
        </nav>
    </header>
    <%!
        int unePage;
        int id;
        int idbook;
        String action = "";
    %>
    <%
        if (request.getParameter("page") != null) {
            unePage = Integer.parseInt(request.getParameter("page"));
        } else {
            unePage = 1;
            id = Integer.parseInt(request.getParameter("id"));
            unMembre = controller.selectWhereMembreWithId(id);
        }
    %>
    <%
        if (unePage == 1) {
        ArrayList<Book> lesBook = controller.selectAllBooks();
        String chaineBooks = "";
        chaineBooks += "<h2>Nos Livres</h2>";
        chaineBooks += "<table border = '1'>";
        chaineBooks += "<tr> <td> Couverture </td> <td> Titre </td> <td> Resume </td> <td> Prix </td></tr>";
        for (Book unBook : lesBook) {
            chaineBooks += "<tr>";
            chaineBooks += "<td><img class='cover_img' src='"+unBook.getImage_url()+"' alt='"+unBook.getTitle()+"'></td>";
            chaineBooks += "<td>"+unBook.getTitle()+"</td>";
            chaineBooks += "<td>"+unBook.getFirst_sentence()+"</td>";
            chaineBooks += "<td>"+unBook.getPrice()+"</td>";
            if (controller.selectWhereLoan(id, unBook.getIdbook()) == null) {
                chaineBooks += "<td> <a href= 'log_user.jsp?page=1&action=emprunter&idbook="+unBook.getIdbook()+"'> EMPRUNTER </a> </td>";
            } else if (controller.selectWhereLoan(id, unBook.getIdbook()) != null && (controller.selectWhereLoan(id, unBook.getIdbook())).getIs_return()) {
                chaineBooks += "<td> <a href= 'log_user.jsp?page=1&action=emprunter&idbook="+unBook.getIdbook()+"'> EMPRUNTER </a> </td>";
            }  else {
                chaineBooks += "<td> Vous avez emprunte ce livre </td>";
            }
            chaineBooks += "</tr>";
        }
        chaineBooks += "</table>";
        out.print(chaineBooks);
    } else if (unePage == 2) {
        %> <%@ include file="offres_log.jsp" %> <%
    } else if (unePage == 3) {
%> <%@ include file="loan.jsp" %> <%
    } else if (unePage == 4) {
    %> <%@ include file="profil.jsp" %> <%
    }
    %>
    <% if (request.getParameter("action") != null) {
        action = request.getParameter("action");
        idbook = Integer.parseInt(request.getParameter("idbook"));
        Date date = new Date();
        Loan leLoan = new Loan(id, idbook, date.toString());
        Membre user = controller.selectWhereMembreWithId(id);
        Book book = controller.selectWhereBookWithId(idbook);
        if (book.getPrice() > user.getCredit()) {
            out.print("Vous n'avez pas assez de credit pour emprunter ce livre !");
        } else {
            user.setCredit((user.getCredit()) - book.getPrice());
            controller.insertLoan(leLoan);
            controller.updateMembre(user);
            response.sendRedirect("log_user.jsp?page=1");
        }
    }
%>
</center>
</body>
</html>
