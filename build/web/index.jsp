<%-- 
    Document   : index
    Created on : Jul 11, 2018, 7:17:29 PM
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
        <table width='400' border='1'>
            <tr>
                <td>
                    <jsp:include page="inicio.jsp"/>
                </td>
                
            
                <td>
                    <form method = "post" action = "procesarLogin.do">
                        <center><p style="color:#182BE7"><h1>Login de usuario</h1> </p></center>
                        <center>
                            <table  border="1">
                                <tr>
                                    <td>Usuario: </td>
                                    <td><input type = "text" name = "txtUsername" style='width:300px' /></td>
                                </tr>
                                <tr>
                                    <td>Contraseña: </td>
                                    <td><input type = "password" name = "txtClave"  style='width:300px' /></td>
                                </tr>
                            </table>
                        </center>
                        <center>
                            <input type="submit" value="Login" id ="boton" style='width:300px' /><br />
                            <a href ="Registrar.jsp"><button type="button" id="boton" style='width:300px'>Registro</button></a><br />
                            <a href ="">¿Olvidaste tu contraseña?</a>
                    </form>
                </td>
            </tr>
            <tr>
                <td>
                    <jsp:include page="Mensajes.jsp"/>
                </td>
            </tr>
        
    </table>


</center>

</body>
</html>
