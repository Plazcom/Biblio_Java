<%--
  Created by IntelliJ IDEA.
  User: Lou
  Date: 12/27/2024
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <%
        ArrayList<Subscription> lesSubscriptions = controller.selectAllSubscriptions();
        String chaineSubs = "";
        chaineSubs += "<h2>Nos Offres</h2>";
        chaineSubs += "<table border = '1'>";
        chaineSubs += "<tr> <td> Nom </td> <td> Prix </td> <td> Credit/Mois </td></tr>";
        for (Subscription unSub : lesSubscriptions) {
            chaineSubs += "<tr>";
            chaineSubs += "<td>"+unSub.getName()+"</td>";
            chaineSubs += "<td>"+unSub.getPrice()+" Euros</td>";
            chaineSubs += "<td>"+unSub.getCredit()+"</td>";
            chaineSubs += "</tr>";
        }
        chaineSubs += "</table>";
        out.print(chaineSubs);
    %>
</center>
</body>
</html>
