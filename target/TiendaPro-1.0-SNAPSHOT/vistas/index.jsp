<%-- 
    Document   : clientes.jsp
    Created on : 3 mar. 2023, 12:49:32
    Author     : usumaniana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CompTore</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/indexCSS.css"/>
    </head>
    <body background="${pageContext.request.contextPath}/recursos/Imagenes/fondo.png">
        <div class="container" >
            
            <h1><image src="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" width="50" height="50">
                CompTore</h1>
            
            <div class="form-container">
                <div>
                    <form  action="iniciarSesion"  method="post" >
                        <h2>Iniciar Sesión</h2>
                        <br/>
                        Usuario: <input type="text" name="usuario" id="usuario"/>
                        <br/>
                        Contraseña: <input type="password" name="passw" id="passw"/>
                        <br/>
                        <input type="submit" value="Inicio Sesion" name="submit">
                    </form>
                </div>
                <div>
                    <form  action="registrar"  method="post" > 
                        <h2>Registrarse</h2>
                        <br/>
                        Usuario: <input type="text" name="usuario" id="usuario"/>
                        <br/>
                        Email: <input type="text" name="email" id="email"/>
                        <br/>
                        Contraseña: <input type="password" name="passw" id="passw"/>
                        <br/>
                        Direccion: <input type="text" name="direccion" id="direccion"/>
                        <br/>
                        Codigo Postal: <input type="text" name="codP" id="codP"/>
                        <br/>
                        <input type="submit" value="Registrarse" name="submit">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
