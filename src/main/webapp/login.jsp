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
        <section id="login">
            <form method="post" class="input">
                <tr> <td> Mail </td>
                    <td> <input type="email" name="email" value='<%= (unMembre != null)?unMembre.getEmail():"" %>'></td>
                </tr>
                <tr> <td> Mot de passe </td>
                    <td> <input type="password" name="mdp" value='<%= (unMembre != null)?unMembre.getPassword():"" %>'></td>
                </tr>
                <tr> <td> </td>
                    <td> <input type="submit" name='SeConnecter' value = 'Soumettre'></td>
                </tr>
                </table>
                <%
                    if (request.getParameter("SeConnecter") != null) {
                        String email = request.getParameter("email");
                        String mdp = request.getParameter("mdp");
                        Membre unMem = controller.selectWhereMembre(email, mdp);
                        if (unMem != null) {
                            out.print("<br> Bienvenue "+unMem.getFirstname()+"<br> <a href='log_user.jsp?id="+unMem.getIdmember()+"'>Se connecter</a>");
                            session.setAttribute("email", unMem.getEmail());
                            session.setAttribute("nom", unMem.getFirstname());
                        } else {
                            out.print("<br> Veuillez vérifier vos identifiants.");
                        }
                    }
                %>
            </form>
        </section>
    </body>
</html>
