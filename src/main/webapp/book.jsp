<%@ page import="controller.controller" %><%--
  Created by IntelliJ IDEA.
  User: Lou
  Date: 1/8/2025
  Time: 1:37 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <style><%@include file="main.css"%></style>
</head>
<body>
<center>
<%
    int id_book = Integer.parseInt(request.getParameter("id"));
    Book unBook = controller.selectWhereBookWithId(id_book);
    String chaineBook = "<h2>"+unBook.getTitle()+"</h2>";
    chaineBook += "<table border = '1'> <tr> <td> Couverture </td><td> Resume </td> <td> Prix </td> </tr>";
    chaineBook += "<tr>";
    chaineBook += "<td><img class='cover_img' src='"+unBook.getImage_url()+"' alt='"+unBook.getTitle()+"'></td>";
    chaineBook += "<td>"+unBook.getFirst_sentence()+"</td>";
    chaineBook += "<td>"+unBook.getPrice()+"</td>";
    chaineBook += "</tr>";
    out.print(chaineBook);
    ArrayList<Commit> lesCommit = controller.selectWhereCommitWithBookId(id_book);
    String chaineCommit = "";
    chaineCommit += "<h3>Commentaires</h3>";
    chaineCommit += "<table border = '1'>";
    chaineCommit += "<tr> <td> Nom </td> <td> Commentaire </td></tr>";
    for (Commit unCommit : lesCommit) {
        Membre user = controller.selectWhereMembreWithId(unCommit.getIdmember());
        chaineCommit += "<tr>";
        chaineCommit += "<td>"+user.getFirstname()+" "+user.getLastname()+"</td>";
        chaineCommit += "<td>"+unCommit.getContent()+"</td>";
        chaineCommit += "</tr>";
    }
    out.print(chaineCommit);
%>
    </center>
</body>
</html>
