<%-- 
    Document   : productos
    Created on : 13 may. 2023, 11:18:56
    Author     : dani1
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
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
         <h1>Productos</h1>
         
        <table>
            <thead>
                <tr><th>ID_PROD</th>
                    <th>NOMBRE</th>
                    <th>DECRIPCION</th>
                    <th>PRECIO</th>
                    <th>CATEGORIA</th>
                    <th>IMAGEN</th>
                    <th></th></tr>
            </thead>
            <tbody>
                <c:forEach  var="pro"  items="${ListaProd}" >
            
                    <!-- Definimos una url con un parámetro para modificar -->   
                    <c:url var="linkActualizar" value="formularioActualizarProducto">
                        <c:param name="idPro" value="${pro.idProducto}"></c:param>
                    </c:url>

                    <!-- Definimos una url con un parámetro para eliminar --> 
                    <c:url var="linkEliminar" value="eliminarProducto">
                        <c:param name="idPro" value="${pro.idProducto}"></c:param>
                    </c:url>
                    <tr> 
                        <td>${pro.idProducto} </td>
                        <td>${pro.nombre}</td>
                        <td>${pro.descripcion}</td>
                        <td>${pro.precio}</td>
                        <td>${pro.categoria}</td>
                        <td><image src="${pageContext.request.contextPath}${pro.imagen}" width="100" height="80"></td>

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
        <input type="submit" value="Añadir nuevo Producto",
               onclick="window.location.href = 'formularioNuevoProducto'; return false"/>
        </div>
        </main>
    </body>
</html>
