<%-- 
    Document   : formularioLinea
    Created on : 15 may. 2023, 12:59:10
    Author     : dani1
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de Detalles Pedidos</title>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/recursos/Imagenes/logo.png" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/formularioCSS.css"/>
    </head>
    
    <body background="${pageContext.request.contextPath}/recursos/Imagenes/fondo.png">
        <h1>Formulario detalles</h1>
        <form:form  action="insertarLinea"  modelAttribute="elLin" >
            
            <form:input path="idLineas" hidden="true"/>
            <br/>
            Pedido: <form:select path="idPedido.idPedido" id="idPedido">
                <form:option value="">Selecciona un pedido</form:option>
                <form:options items="${listaPed}" itemLabel="idPedido" itemValue="idPedido"/>
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
            <a href="../lineas/lista">Volver</a>
        </form:form>
    </body>
</html>
