<%-- 
    Document   : tiendaCarro
    Created on : 23 may. 2023, 12:46:12
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
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
            <c:when test="${empty ListaCe}">
                <div class="container">
                <h1>No tienes ningún artículo en tu cesta.</h1>
                </div>
            </c:when>
            <c:otherwise>
        <div class="container">
        <table class="cart-table">
            <thead>
                <tr><th>IMAGEN</th>
                    <th>PRODUCTO</th>
                    <th>CANTIDAD</th>
                    <th>TOTAL</th>
                    <th></th></tr>
            </thead>
            <tbody>
                
                
                <c:forEach  var="ce"  items="${ListaCe}" >

                    
                    <c:url var="linkEliminar" value="eliminarCesta">
                        <c:param name="idCes" value="${ce.idCesta}"></c:param>
                    </c:url>
                    <tr> 
                        <td><image src="${pageContext.request.contextPath}${ce.idProducto.imagen}" width="100" height="80"/></td>
                        <td>${ce.idProducto.nombre}</td>   
                        <td>
                            <form action="modificarCantidad" method="post">
                                <input type="hidden" name="precio" value="${ce.idProducto.precio}">    
                                <input type="hidden" name="idCes" value="${ce.idCesta}">
                                <input type="number" name="cant" value="${ce.cantidad}" min="1" >
                        </td>
                        <td>${ce.totalPrecio}€</td>
                        <!-- Al pulsar el botón Modificar invoca la link -url- definido antes -->
                        <td>
                            <input type="submit" value="Guardar" name="submit" class="submit-btn">
                        </form>
                        <!-- Al pulsar el botón Modificar invoca la link -url- definido antes -->
                         <a href="${linkEliminar}">  <input type ="button" value="Eliminar" class="submit-btn">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            <td></td>    
            <td></td>    
            <td>Precio total:</td>
                <td>${PrecioTotal}€</td>

            </tbody>
            
        </table>
                <form action="comprar" method="post" class="checkout-form">
                   <input type="submit" value="Comprar" name="submit" class="submit-btn"> 
                </form>
        </div>
            </c:otherwise>
        </c:choose>
                
                <script>
                document.addEventListener('DOMContentLoaded', function() {
                    const quantityControls = document.querySelectorAll('.quantity-control');

                    quantityControls.forEach((control) => {
                        const inputCantidad = control.querySelector('.cantidad');
                        const btnIncrementar = control.querySelector('.increment-btn');
                        const btnDecrementar = control.querySelector('.decrement-btn');

                        btnIncrementar.addEventListener('click', function() {
                            inputCantidad.stepUp();
                        });

                        btnDecrementar.addEventListener('click', function() {
                            inputCantidad.stepDown();
                        });
                    });
                });
              </script>
        </main>
    </body>
</html>
