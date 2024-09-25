<%-- 
    Document   : usuarios
    Created on : 12 may. 2023, 17:00:13
    Author     : dani1
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/cssTablas.css"/>
    </head>
    <body background="${pageContext.request.contextPath}/recursos/Imagenes/fondo.png">
        <header>
            <a href="../">Inicio</a>
            <a href="../usuarios/lista">Usuarios</a>
            <a href="../productos/lista">Productos</a>
            <a href="../pedidos/listaped">Pedidos</a>
            <a href="../lineas/lista">Lineas</a>
            <a href="../cesta/lista">Cesta</a>
            <a href="../comentario/lista">Comentarios</a>
        </header>
        <main>
        <div>
        <h1>Usuarios</h1>
        
        <table>
            <thead>
                <tr>
                    <th>ID_USUARIO</th>
                    <th>NOMBRE</th>
                    <th>EMAIL</th>
                    <th>CONTRASEÑA</th>
                    <th>DIRECCION</th>
                    <th>CODIGO_POSTAL</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usu" items="${ListaUsu}">
                    <c:url var="linkActualizar" value="formularioActualizarUsuario">
                        <c:param name="idUsu" value="${usu.idUsuario}"></c:param>
                    </c:url>

                    <!-- Definimos una url con un parámetro para eliminar --> 
                    <c:url var="linkEliminar" value="eliminarUsuario">
                        <c:param name="idUsu" value="${usu.idUsuario}"></c:param>
                    </c:url>
                    
                    <tr>
                        <td>${usu.idUsuario}</td>
                        <td>${usu.nombre}</td>
                        <td>${usu.email}</td>
                        <td>${usu.contrasena}</td>
                        <td>${usu.direccion}</td>
                        <td>${usu.codigoPostal}</td>
                        <td> <a href="${linkActualizar}"> <input type ="button" value="Modificar">
                            </a>
                             
                        <!-- Al pulsar el botón Modificar invoca la link -url- definido antes -->
                         <a href="${linkEliminar}">  <input type ="button" value="Eliminar" 
                                                                onclick="if (!(confirm('Vas a eliminar. ¿Estás seguro?')))">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="submit" value="Añadir nuevo cliente",
               onclick="window.location.href = 'formularioNuevoUsuario'; return false"/>
        </div>
        </main>
    </body>
</html>
