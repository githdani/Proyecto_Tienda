<%-- 
    Document   : cesta
    Created on : 15 may. 2023, 15:04:04
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cesta</title>
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
        <h1>Cesta</h1>
        <table>
            <thead>
                <tr><th>ID_CESTA</th>
                    <th>USUARIO</th>
                    <th>PRODUCTO</th>
                    <th>CANTIDAD</th>
                    <th>TOTAL</th>
                    <th></th></tr>
            </thead>
            <tbody>
                <!--  Procesamos la lista de clientes -->
                <c:forEach  var="ce"  items="${ListaCe}" >
            
                    <!-- Definimos una url con un parámetro para modificar -->   
                    <c:url var="linkActualizar" value="formularioActualizarCesta">
                        <c:param name="idCes" value="${ce.idCesta}"></c:param>
                    </c:url>

                    <!-- Definimos una url con un parámetro para eliminar --> 
                    <c:url var="linkEliminar" value="eliminarCesta">
                        <c:param name="idCes" value="${ce.idCesta}"></c:param>
                    </c:url>
                    <tr> 
                        <td>${ce.idCesta} </td>
                        <td>${ce.idUsuario.nombre}</td>
                        <td>${ce.idProducto.nombre}</td>
                        <td>${ce.cantidad}</td>
                        <td>${ce.totalPrecio}</td>

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
        <input type="submit" value="Añadir nueva Cesta",
               onclick="window.location.href = 'formularioNuevaCesta'; return false"/>
        </div>
        </main>
    </body>
</html>
