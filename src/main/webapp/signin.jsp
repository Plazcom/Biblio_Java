<%--
  Created by IntelliJ IDEA.
  User: Lou
  Date: 12/27/2024
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <section id="login">
            <form method="post" class="input">
                <table>
                    <tr> <td> Nom </td>
                        <td> <input type="text" name="nom" value='<%= (unMembre != null)?unMembre.getLastname():"" %>'></td>
                    </tr>
                    <tr> <td> Prenom </td>
                        <td> <input type="text" name="prenom" value='<%= (unMembre != null)?unMembre.getFirstname():"" %>'></td>
                    </tr>
                    <tr> <td> Mail </td>
                        <td> <input type="email" name="adresse" value='<%= (unMembre != null)?unMembre.getEmail():"" %>'></td>
                    </tr>
                    <tr> <td> Telephone </td>
                        <td> <input type="tel" name="phone" value='<%= (unMembre != null)?unMembre.getPhone():"" %>'></td>
                    </tr>
                    <tr> <td> Mot de passe </td>
                        <td> <input type="password" name="mdp" value='<%= (unMembre != null)?unMembre.getPassword():"" %>'></td>
                    </tr>
                    <tr> <td> </td>
                        <td> <input type="submit" <%= (unMembre != null)? " name='Modifier' value='Modifier'" :
                        "name='Valider' value = 'Valider' "%>></td>
                    </tr>
                </table>
                <%= (unMembre != null)? "<input type='hidden' name='idmembre' value='"+ unMembre.getIdmember()+">":"" %>
                <%
                    if (request.getParameter("Valider") != null) {
                        String nom = request.getParameter("nom");
                        String prenom = request.getParameter("prenom");
                        String adresse = request.getParameter("adresse");
                        String phone = request.getParameter("phone");
                        String mdp = request.getParameter("mdp");

                        Membre unMem = new Membre(nom, prenom, adresse, mdp, phone, "none", 0, false);
                        controller.insertMembre(unMem);
                        out.print("<br> Compte créé");
                    }
                    if (request.getParameter("Modifier") != null) {
                        int credit = unMembre.getCredit();
                        String nom = request.getParameter("nom");
                        String prenom = request.getParameter("prenom");
                        String adresse = request.getParameter("adresse");
                        String phone = request.getParameter("phone");
                        String mdp = request.getParameter("mdp");
                        int idmembre = unMembre.getIdmember();

                        Membre unMem = new Membre(idmembre, nom, prenom, adresse, mdp, phone, "none", credit, false);
                        controller.updateMembre(unMembre);
                        response.sendRedirect("log_user.jsp?page=2");
                    }
                %>
            </form>
        </section>
    </center>
</body>
</html>
