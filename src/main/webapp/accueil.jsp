
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Title</title>
    <style><%@include file="main.css"%></style>
</head>
<body>
<center>

<%
    ArrayList<Book> lesBook = controller.selectAllBooks();
    String chaineBooks = "";
    chaineBooks += "<h2>Nos Livres</h2>";
    chaineBooks += "<table border = '1'>";
    chaineBooks += "<tr> <td> Couverture </td> <td> Titre </td> <td> Resume </td> <td> Prix </td></tr>";
    for (Book unBook : lesBook) {
        chaineBooks += "<tr>";
        chaineBooks += "<td><img class='cover_img' src='"+unBook.getImage_url()+"' alt='"+unBook.getTitle()+"'></td>";
        chaineBooks += "<td><a href='main.jsp?page=4&id="+unBook.getIdbook()+"'>"+unBook.getTitle()+"</a></td>";
        chaineBooks += "<td>"+unBook.getFirst_sentence()+"</td>";
        chaineBooks += "<td>"+unBook.getPrice()+"</td>";
        chaineBooks += "</tr>";
    }
    chaineBooks += "</table>";
    out.print(chaineBooks);
%>
</center>
</body>
</html>
