<%-- 
    Document   : formularioProducto
    Created on : 13 may. 2023, 11:27:37
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Productos</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/formularioCSS.css"/>
    </head>
    <body background="${pageContext.request.contextPath}/recursos/Imagenes/fondo.png">
         <h1>Formulario productos</h1>
        <form:form  action="insertarProducto"  modelAttribute="elProd" enctype="multipart/form-data"> 
            
            <form:input path="idProducto" hidden="true"/>
            <br/>
            Nombre: <form:input path="nombre"/> 
            <br/>
            Descripción: <form:input path="descripcion"/>             
            <br/>
            Precio: <form:input path="precio"/> 
            <br/>
            Categoria: <form:input path="categoria"/> 
            <br/>
            <form:input path="imagen" hidden="true"/>
            <div class="file-input">
                <label for="file" class="file-label">Seleccionar imagen</label>
                <input type="file" name="file" id="file" class="file-input" />
             </div>
            <br/>
            <input type="submit" value ="Enviar datos" />
            <a href="../productos/lista">Volver</a>
        </form:form>
    </body>
</html>
