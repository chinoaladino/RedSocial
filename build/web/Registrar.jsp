<%-- 
    Document   : Registrar
    Created on : Jul 11, 2018, 7:21:02 PM
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
    <head>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="procesarRegistrar.do" method="post">
            <center><h1><p style="color: #182BE7">Bienvenido Nuevo Usuario</p></h1></center>
            <center>
            <table  border="1">
                <tr>
                    <td>
                        Usuario:
                    </td>
                    <td>
                        <input type="text" name="txtNickname" style='width:300px'/><br />
                    </td>
                </tr>
                <tr>
                    <td>
                        Nombre:
                    </td>
                    <td>
                        <input type="text" name="txtNombre" style='width:300px'/><br />
                    </td>
                </tr>
                <tr>
                    <td>
                        Apellido: 
                    </td>
                    <td>
                        <input type="text" name="txtApellido" style='width:300px'/><br />
                    </td>
                </tr>
                <tr>
                    <td>
                        Contraseña:
                    </td>
                    <td>
                        <input type="password" name="txtClave" style='width:300px'/><br />
                    </td>
                </tr>
                <tr>
                    <td>
                        Correo: 
                    </td>
                    <td>
                        <input type="text" name="txtCorreo" style='width:300px'/><br />
                    </td>
                </tr>
                <tr>
                    <td>
                        Edad: 
                    </td>
                    <td>
                        <input type="text" name="txtEdad" style='width:300px'/><br />
                    </td>
                </tr>
                <tr>
                    <td>
                        Detalle Perfil: 
                    </td>
                    <td>
                        <textarea name="txtDetalle"></textarea>
                    </td>

                </tr>
                <tr>
                    <td>
                        Sexo: 
                    </td>
                    <td>
                        <label><input type="radio" name="rdSexo" value="Masculino"/> Masculino</label>
                        <label><input type="radio" name="rdSexo" value="Femenino" />Femenino</label>
                    </td>
                </tr>
            </table> </center><br/>
            <center>
                <input type="submit" value="Registrar" style='width:300px' />
            </center>
        </form>

    </head>
    <body>

</html>
