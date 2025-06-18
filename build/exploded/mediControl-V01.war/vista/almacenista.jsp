<%-- 
    Document   : almacenista
    Created on : 17/06/2025, 2:25:05 p. m.
    Author     : Alvaor Rubiano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../publico/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <title>Almacenista</title>
    </head>
    <body>
        <%-- Header --%>
        <%@include file="../plantillas/header.jsp" %>
        <%-- Body --%>
        
        <h1>Almacenista</h1>
                
        <a class="btn btn-primary" href="vistas/crearColaborador.jsp" role="button">Colaborador</a>
        
        <a class="btn btn-primary" href="../../index.jsp" role="button">Salir</a>
        
        <%-- Fin de Body --%>
        <%-- Footer --%>
        <%@include file="../plantillas/footer.jsp" %>
        <script src="../../publico/js/bootstrap.js" type="text/javascript"  ></script>
    </body>
</html>
