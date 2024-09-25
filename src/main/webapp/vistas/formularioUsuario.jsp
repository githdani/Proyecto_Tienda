<%-- 
    Document   : formularioUsuario
    Created on : 12 may. 2023, 20:43:41
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion de Usuario</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/formularioCSS.css"/>
    </head>
    <body background="${pageContext.request.contextPath}/recursos/Imagenes/fondo.png">
        <h1>Formulario Usuario</h1>
        <form:form action="insertarUsuario" modelAttribute="elUsuario">
            
            <form:input path="idUsuario" hidden="true"/>
               
            <br/>
            Nombre: <form:input path="nombre"/>
            <br/>
            Email: <form:input path="email"/>
            <br/>
            Contraseña: <form:input path="contrasena"/>
            <br/>
            Dirección: <form:input path="direccion"/>
            <br/>
            Codigo Postal: <form:input path="codigoPostal"/>
            <br/>
            <form:input path="perfil" hidden="true"/>
            
            <input type="submit" value ="Enviar datos" />
            <a href="../usuarios/lista">Volver</a>
        </form:form>
    </body>
</html>
