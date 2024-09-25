<%-- 
    Document   : tiendaDet
    Created on : 28 may. 2023, 15:13:24
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles</title>
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
            <div class="container">
            <table class="cart-table">
            <thead>
                <tr><th>IMAGEN</th>
                    <th>PRODUCTO</th>
                    <th>CANTIDAD</th>
                    <th>TOTAL</th>
                    </tr>
            </thead>
            <tbody>
                <c:forEach  var="lin"  items="${laLista}" >
                    <tr> 
                        <td><image src="${pageContext.request.contextPath}${lin.idProducto.imagen}" width="100" height="80"/> </td>
                        <td>${lin.idProducto.nombre}</td>
                        <td>${lin.cantidad}</td>
                        <td>${lin.totalPrecio}€</td>
                        
                    </tr>
                </c:forEach>
                    
                    <td></td>    
                    <td></td>    
                    <td>Precio total:</td>
                    <td>${TotalPrecio}€</td>
            </tbody>
        </table>
        </div>
        </main>
    </body>
</html>
