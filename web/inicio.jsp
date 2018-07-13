<%-- 
    Document   : inicio
    Created on : Jul 12, 2018, 3:11:05 PM
    Author     : dell
--%>

<%@page import="modelo.Mensaje"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1><p style="color:#990099">Bienvenido: 
                ${sessionScope.usuario}</p></h1><br /></center>
    <center>
        <table border="0">
            <tr>
                <td>  <div style="text-align: left;"> ${sessionScope.usuario} </div></td>
            </tr>

        </table>
        <form action="procesarPublicar.do" method="get">
            <textarea cols="75" rows="4" name="txtMensaje"></textarea><br/>
            <input type="submit" value="Publicar" style="color:blue " style='width:150px'/> <br/>
        </form>
            <form action="procesarCerrarSesion.do" method="post">
            <center><input type="submit" name="btn" value="CerrarSesion"</center>
        </form>
        <%
            List<Mensaje> lista = (List<Mensaje>) request.getSession().getAttribute("lista");
            if (lista != null) {
                for (int i = lista.size() - 1; i > 0; i--) {

                    out.print("<p>" + lista.get(i).getUsuarioUsername().getCorreo() + "</p>");
                    out.print("<h6>< style='color:gray'>" + lista.get(i).getFecha() + "</h6><br/>");
                    out.println("<textarea cols='30' rows='4' disabled>" + lista.get(i).getMensaje() + "</textarea><br/>");
                }
            } else {
                out.println("<center><h3>Lo sentimos, No hay mensajes que mostrar</h3></center>");
            }
        %>
    </center>      
</center>
</body>
</html>
