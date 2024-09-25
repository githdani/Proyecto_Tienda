<%-- 
    Document   : comentario
    Created on : 15 may. 2023, 15:28:34
    Author     : dani1
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comentarios</title>
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
        <h1>Comentarios</h1>
        <table>
            <thead>
                <tr><th>ID_COMENTARIO</th>
                    <th>USUARIO</th>
                    <th>PRODUCTO</th>
                    <th>TEXTO</th>
                    <th>PUNTUACION</th>
                    <th></th></tr>
            </thead>
            <tbody>
                <!--  Procesamos la lista de clientes -->
                <c:forEach  var="co"  items="${ListaCo}" >
            
                    <!-- Definimos una url con un parámetro para modificar -->   
                    <c:url var="linkActualizar" value="formularioActualizarCo">
                        <c:param name="idCo" value="${co.idComent}"></c:param>
                    </c:url>

                    <!-- Definimos una url con un parámetro para eliminar --> 
                    <c:url var="linkEliminar" value="eliminarCo">
                        <c:param name="idCo" value="${co.idComent}"></c:param>
                    </c:url>
                    <tr> 
                        <td>${co.idComent} </td>
                        <td>${co.idUsuario.nombre}</td>
                        <td>${co.idProducto.nombre}</td>
                        <td>${co.texto}</td>
                        <td>${co.puntuacion}</td>

                        <!-- Al pulsar el botón Modificar invoca la link -url- definido antes -->
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
        <input type="submit" value="Añadir nuevo Comentario",
               onclick="window.location.href = 'formularioNuevoCo'; return false"/>
        </div>
        </main>
    </body>
</html>
