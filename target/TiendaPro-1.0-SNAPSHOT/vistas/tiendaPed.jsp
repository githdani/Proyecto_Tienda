<%-- 
    Document   : tiendaPed
    Created on : 23 may. 2023, 19:00:34
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/tiendaCar.css"/>
    </head>
    <body background="${pageContext.request.contextPath}/recursos/Imagenes/fondo.png">
        <header>
            <div>
                <a href="../tienda/lista" class="navbar-brand">
                    <image src="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" width="35" height="35">
                    CompTore
                </a>
            </div>
                    
            
            <div>
                <a href="../tiendaCarro/lista"><image src="${pageContext.request.contextPath}/recursos/Imagenes/carros.png" width="40" height="40"></a>
            </div>
            <div>
                <c:if test="${not empty User}">
                <ul class="user-menu">
                    <li class="user"><img src="${pageContext.request.contextPath}${User.perfil}" width="32" height="30"/>${User.nombre}
                    <ul class="user-submenu">
                        <li><a href="../tiendaPed/lista">Pedidos</a></li>
                        <li><a href="../">Cerrar Sesión</a></li>
                    </ul>
                    </li>
                </ul>
                </c:if>
            </div>
        </header>
    
        <main>
            <c:choose>
            <c:when test="${empty ListaPed}">
                <div class="container">
                <h1>No tienes ningún pedido en tu cuenta.</h1>
                </div>
            </c:when>
            <c:otherwise>
           <div class="container">
            <table class="cart-table">
            <thead>
                <tr><th>Nº PEDIDO</th>
                    <th>DIRECCION</th>
                    <th></th></tr>
            </thead>
            <tbody>
                <c:forEach  var="ped"  items="${ListaPed}" >
                    <c:url var="linkFiltrar" value="listarDetalles">
                        <c:param name="idPed" value="${ped.idPedido}"></c:param>
                    </c:url>
                    <tr> 
                        <td>${ped.idPedido} </td>
                        <td>${ped.idUsuario.direccion}</td>
                        <td>
                            <a href="${linkFiltrar}"> <input type ="button" value="Detalles" class="submit-btn">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
            </c:otherwise>
        </c:choose>
        </main>    
    </body>
</html>
