<%-- 
    Document   : tienda
    Created on : 21 may. 2023, 18:17:08
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CompTore</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/tienda.css"/>
    </head>
    <body background="${pageContext.request.contextPath}/recursos/Imagenes/fondo.png">
        <header>
            <div>
                <a href="../tienda/lista" class="navbar-brand">
                    <image src="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" width="35" height="35">
                    CompTore
                </a>
            </div>
                    
            <div class="navbar-menu">
                <div class="menu-trigger">Categorias</div>
                <ul class="navbar-submenu">
                    <c:forEach var="cat" items="${listaCat}">
                        <c:url var="linkFiltrar" value="listarCate">
                            <c:param name="cate" value="${cat}"></c:param>
                        </c:url>
                        <li><a href="${linkFiltrar}">${cat}</a></li>
                    </c:forEach>
                </ul>
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

    <!--Contenido-->
    <main>
        
        <div >
            
            <div>
                <c:forEach var="pro" items="${listaPro}">
            <c:url var="linkAgregar" value="agregarCarro">
                        <c:param name="idPro" value="${pro.idProducto}"></c:param>
                    </c:url>
            <c:url var="linkDetalle" value="verDetalle">
                        <c:param name="idPro" value="${pro.idProducto}"></c:param>
                    </c:url>
                <div class="product-row">
                    
                    <div class="product-box">
                        
                        <image src="${pageContext.request.contextPath}${pro.imagen}" width="100" height="80">
                        <div>
                            <h5>${pro.nombre}</h5>
                            <p>${pro.precio}€</p>
                            <div class="button-container">
                                <div class="left-button">
                                    <a href="${linkDetalle}" >Detalles</a>
                                </div>
                                <div class="right-button">
                                    <a href="${linkAgregar}">Agregar</a>
                                </div>
                            </div>
                        </div>
                            
                    </div>
                            
                </div>
                            </c:forEach>
            </div>
        </div>
        
    </main>
    </body>
</html>
