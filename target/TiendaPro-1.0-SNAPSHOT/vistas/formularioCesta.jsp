<%-- 
    Document   : formularioCesta
    Created on : 15 may. 2023, 15:11:24
    Author     : dani1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Cesta</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/formularioCSS.css"/>
    </head>
    
    <body background="${pageContext.request.contextPath}/recursos/Imagenes/fondo.png">
        <h1>Formulario cesta</h1>
        <form:form  action="insertarCesta"  modelAttribute="elCes" >           
            <form:input path="idCesta" hidden="true" />
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
            Cantidad: <form:input path="cantidad"/> 
            <br/>
            Total: <form:input path="totalPrecio" readonly="true" value="${elDet.totalPrecio}" /> 
            <br/>
            <input type="submit" value ="Enviar datos" />
            <a href="../cesta/lista">Volver</a>
        </form:form>
    </body>
</html>
