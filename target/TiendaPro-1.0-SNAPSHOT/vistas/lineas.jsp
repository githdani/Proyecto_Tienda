<%-- 
    Document   : LineasPedido
    Created on : 15 may. 2023, 12:51:29
    Author     : dani1
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Detalles de Pedidos</title>
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
        <h1>Detalles de Pedidos</h1>
        <table>
            <thead>
                <tr><th>ID_LINEA</th>
                    <th>ID_PEDIDO</th>
                    <th>PRODUCTO</th>
                    <th>CANTIDAD</th>
                    <th>TOTAL</th>
                    <th></th></tr>
            </thead>
            <tbody>
                <!--  Procesamos la lista de clientes -->
                <c:forEach  var="li"  items="${ListaLi}" >
            
                    <!-- Definimos una url con un parámetro para modificar -->   
                    <c:url var="linkActualizar" value="formularioActualizarLinea">
                        <c:param name="idLin" value="${li.idLineas}"></c:param>
                    </c:url>

                    <!-- Definimos una url con un parámetro para eliminar --> 
                    <c:url var="linkEliminar" value="eliminarLinea">
                        <c:param name="idLin" value="${li.idLineas}"></c:param>
                    </c:url>
                    <tr> 
                        <td>${li.idLineas} </td>
                        <td>${li.idPedido.idPedido}</td>
                        <td>${li.idProducto.nombre}</td>
                        <td>${li.cantidad}</td>
                        <td>${li.totalPrecio}</td>

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
        <input type="submit" value="Añadir nueva Linea",
               onclick="window.location.href = 'formularioNuevaLinea'; return false"/>
        </div>
        </main>
    </body>
</html>
