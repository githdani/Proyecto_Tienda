<%-- 
    Document   : detallesPro
    Created on : 22 may. 2023, 17:47:25
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/tiendaDet.css"/>
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
    <main>
        <c:if test="${not empty Produc}">
            <div class="product-container">
                <img src="${pageContext.request.contextPath}${Produc.imagen}" width="300" height="280">
                <div class="product-details">
                    <h2>${Produc.nombre}</h2>
                    <h5>${Produc.descripcion}</h5>
                    <p>${Produc.precio}€</p>
                </div>
            </div>
        </c:if>
        <form action="anadirCo" method="post" class="review-form">
            <div class="form-group">
                <input type="hidden" name="idPro" value="${Produc.idProducto}">
                <label for="punto">Puntuacion:</label>
                <div class="rating-stars">
                    <input type="radio" id="star5" name="punto" value="5">
                    <label for="star5"></label>
                    <input type="radio" id="star4" name="punto" value="4">
                    <label for="star4"></label>
                    <input type="radio" id="star3" name="punto" value="3">
                    <label for="star3"></label>
                    <input type="radio" id="star2" name="punto" value="2">
                    <label for="star2"></label>
                    <input type="radio" id="star1" name="punto" value="1">
                    <label for="star1"></label>
                </div>
            </div>
            <div class="form-group">
                <label for="text">Comentario:</label>
                <textarea name="text" rows="4" cols="50" id="text"></textarea>
            </div>
            <input type="submit" value="Enviar" name="submit" class="submit-btn">
        </form>
        <c:choose>
            <c:when test="${empty Coment}">
                <div class="comment">
                    <p>No tiene nigun comentario.</p>
                </div>
            </c:when>
            <c:otherwise>
        <c:forEach var="co" items="${Coment}">
        <div class="comment">
            <div class="comment-header">
                <h3>${co.idUsuario.nombre}</h3>
                <div class="rating">
                    ${co.puntuacion}
                    <img src="${pageContext.request.contextPath}/recursos/star-yellow.png" width="18px" height="18px">
                </div>
            </div>
            <textarea rows="4" cols="50" readonly="true">${co.texto}</textarea>
        </div>
        </c:forEach>
        </c:otherwise>
        </c:choose>
    </main>
    </body>
</html>
