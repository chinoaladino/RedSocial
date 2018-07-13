<%-- 
    Document   : Mensajes
    Created on : Jul 12, 2018, 8:17:52 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="procesarMostrarMensajes.do" method="post">
            <input type="submit" value="Mostrar"/>
            <textarea disabled>${sessionScope.lista}</textarea><br/>
            
        </form>
    </body>
</html>
