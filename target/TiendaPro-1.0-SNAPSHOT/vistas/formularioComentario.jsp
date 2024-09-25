<%-- 
    Document   : formularioComentario
    Created on : 15 may. 2023, 15:40:19
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Comentarios</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/formularioCSS.css"/>
    </head>
    
    <body background="${pageContext.request.contextPath}/recursos/Imagenes/fondo.png">
        <h1>Formulario comentario</h1>
        <form:form  action="insertarCo"  modelAttribute="elCo" >           
            <form:input path="idComent" hidden="true"/>
            <br/>
            Cliente:<form:select path="idUsuario.idUsuario" id="idUsuario">
                <form:option value="">Selecciona un cliente</form:option>
                <form:options items="${listaUsu}" itemLabel="nombre" itemValue="idUsuario"/>
            </form:select>
            <br/>
            Producto: <form:select path="idProducto.idProducto" id="idProducto">
                <form:option value="">Selecciona un producto</form:option>
                <form:options items="${listaProd}" itemLabel="nombre" itemValue="idProducto"/>
            </form:select>
            <br/>
            Comentario: <form:textarea path="texto" rows="4" cols="50"/> 
            <br/>
            Puntuacion: <form:select path="puntuacion">
                <form:option value="1">1</form:option>
                <form:option value="2">2</form:option>
                <form:option value="3">3</form:option>
                <form:option value="4">4</form:option>
                <form:option value="5">5</form:option>
            </form:select> 
            <br/>
            <input type="submit" value ="Enviar datos" />
            <a href="../comentario/lista">Volver</a>
        </form:form>
    </body>
</html>
