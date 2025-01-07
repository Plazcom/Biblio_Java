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
        <%!
        int idoffre;
    %>
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
            if (controller.selectWhereIs_subscribe(id, unSub.getIdsubscription()) == null) {
                chaineSubs += "<td> <a href= 'log_user.jsp?page=2&sub=sub&idoffre="+unSub.getIdsubscription()+"'> S'ABONNER </a> </td>";
            } else {
                chaineSubs += "<td> Vous etes deja abonne a cette offre </td>";
            }
            chaineSubs += "</tr>";
        }
        chaineSubs += "</table>";
        out.print(chaineSubs);
    %>
<% if (request.getParameter("sub") != null) {
    action = request.getParameter("sub");
    idoffre = Integer.parseInt(request.getParameter("idoffre"));
    Date date = new Date();
    int day = date.getDay();
    Is_subscribe leIs_subscribe = new Is_subscribe(id, idoffre, Integer.toString(day));
    Membre user = controller.selectWhereMembreWithId(id);
    Subscription sub = controller.selectWhereSubscriptionWithId(idoffre);
    user.setCredit((user.getCredit()) + sub.getCredit());
    controller.insertIs_subscribe(leIs_subscribe);
    controller.updateMembre(user);
    response.sendRedirect("log_user.jsp?page=2");
    }%>
</center>
</body>
</html>
