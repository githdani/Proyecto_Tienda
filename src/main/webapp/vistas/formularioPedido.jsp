<%-- 
    Document   : formularioPedido
    Created on : 13 may. 2023, 11:59:24
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Pedidos</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/formularioCSS.css"/>
    </head>
    <body background="${pageContext.request.contextPath}/recursos/Imagenes/fondo.png">
        <h1>Formulario Pedidos</h1>
        <form:form  action="insertarPedido"  modelAttribute="elPed" >
            
            <form:input path="idPedido" hidden="true"/>
            <br/>
            Cliente:<form:select path="idUsuario.idUsuario" id="idUsuario">
                <form:option value="">Selecciona un cliente</form:option>
                <form:options items="${ListaUsu}" itemLabel="nombre" itemValue="idUsuario"/>
            </form:select>
            <br/> 
            <input type="submit" value ="Enviar datos" />
            <a href="../pedidos/listaped">Volver</a>
        </form:form>
    </body>
</html>
