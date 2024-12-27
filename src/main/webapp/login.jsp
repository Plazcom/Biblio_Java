<%--
  Created by IntelliJ IDEA.
  User: Lou
  Date: 12/27/2024
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <section id="login">
            <form method="post" class="input">
                <tr> <td> Mail </td>
                    <td> <input type="email" name="email" value='<%= (unMembre != null)?unMembre.getAddress():"" %>'></td>
                </tr>
                <tr> <td> Mot de passe </td>
                    <td> <input type="password" name="mdp" value='<%= (unMembre != null)?unMembre.getMdp():"" %>'></td>
                </tr>
                <tr> <td> </td>
                    <td> <input type="submit" name='SeConnecter' value = 'Soumettre'></td>
                </tr>
                </table>
                <%
                    if (request.getParameter("SeConnecter") != null) {
                        String email = request.getParameter("email");
                        String mdp = request.getParameter("mdp");
                        Membre unMem = controller.selectWhereMember(email, mdp);
                        if (unMem != null) {
                            out.print("<br> Bienvenue "+unMem.getNom()+"<br> <a href='log_user.jsp?id="+unMem.getIdmembre()+"'>Se connecter</a>");
                            session.setAttribute("email", unMem.getAddress());
                            session.setAttribute("nom", unMem.getNom());
                        } else {
                            out.print("<br> Veuillez vérifier vos identifiants.");
                        }
                    }
                %>
            </form>
        </section>
    </body>
</html>
