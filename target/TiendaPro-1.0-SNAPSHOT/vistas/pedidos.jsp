<%-- 
    Document   : pedidos
    Created on : 13 may. 2023, 11:57:25
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
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
        <h1>Pedidos</h1>
        <table>
            <thead>
                <tr><th>ID_PED</th>
                    <th>CLIENTE</th>
                    <th></th></tr>
            </thead>
            <tbody>
                <!--  Procesamos la lista de clientes -->
                <c:forEach  var="ped"  items="${ListaPed}" >
            
                    <!-- Definimos una url con un parámetro para modificar -->   
                    <c:url var="linkActualizar" value="formularioActualizarPedido">
                        <c:param name="idPed" value="${ped.idPedido}"></c:param>
                    </c:url>

                    <!-- Definimos una url con un parámetro para eliminar --> 
                    <c:url var="linkEliminar" value="eliminarPedido">
                        <c:param name="idPed" value="${ped.idPedido}"></c:param>
                    </c:url>
                    <c:url var="linkFiltrar" value="listarDetalles">
                        <c:param name="idPed" value="${ped.idPedido}"></c:param>
                    </c:url>
                    <tr> 
                        <td>${ped.idPedido} </td>
                        <td>${ped.idUsuario.nombre}</td>

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
        <input type="submit" value="Añadir nuevo Pedido",
               onclick="window.location.href = 'formularioNuevoPedido'; return false"/>
        </div>
        </main>
    </body>
</html>
