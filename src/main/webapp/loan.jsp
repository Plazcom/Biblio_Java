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
        ArrayList<Loan> lesLoan = controller.selectWhereLoanWithMemberId(id);
        String chaineLoan = "";
        chaineLoan += "<h2>Vos Locations</h2>";
        chaineLoan += "<table border = '1'>";
        chaineLoan += "<tr> <td> Livre </td> <td> Date </td> <td> Status </td></tr>";
        for (Loan unLoan : lesLoan) {
            Book book = controller.selectWhereBookWithId(unLoan.getIdbook());
            String status = "rendu";
            if (unLoan.getIs_return() == false) {
                status = "non rendu";
            }
            chaineLoan += "<tr>";
            chaineLoan += "<td>"+book.getTitle()+"</td>";
            chaineLoan += "<td>"+unLoan.getLoan_date()+" Euros</td>";
            chaineLoan += "<td>"+status+"</td>";
            if (unLoan.getIs_return() == false) {
                chaineLoan += "<td> <a href= 'log_user.jsp?page=3&rendre=rendre&idbook="+book.getIdbook()+"'> RENDRE </a> </td>";
            }
            chaineLoan += "</tr>";
        }
        chaineLoan += "</table>";
        out.print(chaineLoan);
    %>
<% if (request.getParameter("rendre") != null) {
    action = request.getParameter("rendre");
    int id_book = Integer.parseInt(request.getParameter("idbook"));
    Loan loan = controller.selectWhereLoan(id, id_book);
    loan.setIs_return(true);
    controller.updateLoan(loan);
    response.sendRedirect("log_user.jsp?page=3");
    }%>
</center>
</body>
</html>
