<%-- 
    Document   : modificarProveedor
    Created on : 31/07/2025, 8:15:31 a. m.
    Author     : Alvaro Rubiano
--%>

<%@page import="controlador.ConsultaCiudad"%>
<%@page import="controlador.ConsultaRh"%>
<%@page import="controlador.ConsultaIndicativo"%>
<%@page import="controlador.ConsultaCargo"%>
<%@page import="controlador.ConsultaDepartamento"%>
<%@page import="controlador.Conexion"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Proveedor</title>
    </head>
    <body>
         <%-- Header --%>
        <nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="../../imagenes/Logo_MEDIINSUMOS.svg" alt="Mediinsumos" width="300">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="../almacenista.jsp">Regresar</a>
                        </li>                  
                    </ul>
                </div>
            </div>
        </nav>

        <%-- Body --%>
        <div class="container">
            <center>
                <h4>Modificar proveedores</h4>
            </center>                    
        </div>
        
        <%
            int identificacion = Integer.parseInt(request.getParameter("id"));
            if (identificacion > 0) {
                Conexion conexion = new Conexion();
                PreparedStatement ps = null;
                ResultSet rs = null;

                String consulta = "SELECT identificacion, nombre, direccion, telefono, contacto, correo, ciudad.ciudad, proveedor.idCiudad, ciudad.idDepartamento, departamento.departamento FROM proveedor, ciudad, departamento WHERE proveedor.idCiudad=ciudad.idCiudad AND ciudad.idDepartamento=departamento.idDepartamento AND proveedor.identificacion=" + identificacion;
                ps = (PreparedStatement) conexion.conectar().prepareStatement(consulta);
                rs = ps.executeQuery();
                while (rs.next()) {

        %>

        <div class="container">
            <form action="../../Colaborador" method="POST" class="row g-3">
                <div class="col-md-2">
                    <label for="inputColaborador" class="form-label">Identificación</label>
                    <input type="text" value="<%= rs.getInt("identificacion")%>" id="identificacion" name="identificacion" class="form-control" readonly="">
                </div>

                <div class="col-md-6">
                    <label for="inputNombre" class="form-label">Proveedor</label>
                    <input type="text" value="<%= rs.getString("nombre")%>" id="nombre" name="nombre" class="form-control" readonly="">
                </div>

                <div class="col-md-4">
                    <label for="inputDireccion" class="form-label">Direccion</label>
                    <input type="text" value="<%= rs.getString("direccion")%>" id="direccion" name="direccion" class="form-control" required>
                </div>

                <div class="col-md-2">
                    <label for="inputTelefono" class="form-label">Teléfono</label>
                    <input type="text" value="<%= rs.getString("telefono")%>" id="telefono" name="telefono" class="form-control" required>
                </div>

                <div class="col-md-4">
                    <label for="inputContacto" class="form-label">Contacto</label>
                    <input type="text" value="<%= rs.getString("contaccto")%>" id="contacto" name="contacto" class="form-control" required>
                </div>    
                
                <div class="col-md-4">
                    <label for="inputCorreo" class="form-label">Correo</label>
                    <input type="text" value="<%= rs.getString("correo")%>" id="correo" name="correo" class="form-control" required>
                </div>

                <div class="col-md-2">
                    <label for="departamento" class="form-label">Departamento</label>
                    <select id="departamento" name="departamento" class="form-select">
                        <option selected value="<%= rs.getInt("ciudad.idDepartamento")%>"><%= rs.getString("departamento.departamento")%></option>
                    </select>                    
                </div>

                <div class="col-md-2">
                    <label for="ciudad" class="form-label">Ciudad</label>
                    <select id="ciudad" name="ciudad" class="form-select">
                        <option selected value="<%= rs.getInt("proveedor.idCiudad")%>"><%= rs.getString("ciudad.ciudad")%></option>
                        <% ConsultaCiudad ciudad = new ConsultaCiudad();%>
                        <%= ciudad.obtenerSelectCiudad()%>
                    </select>  
                </div>                  

                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button type="submit" name="btnProveedor" value="modificarProveedor" class="btn btn-primary">Actualizar</button>                                    
                </div>
            </form>
        </div>
        <% } //Fin de while %>             
        <% } //Fin de if %>            

        <%-- Footer --%>
        <%@include file="../../plantillas/footer.jsp" %>
        <script src="../../publico/js/bootstrap.js" type="text/javascript"  ></script>
        <script src="../../publico/js/jQuery_3.7.1.js" type="text/javascript"  ></script>
        <script src="../../publico/js/javascript.js" type="text/javascript"  ></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $.ajax({
                    url: "../../DepartamentoCiudad",
                    method: "GET",
                    data: {operacion: "departamento"},
                    success: function (data, textStatus, jqXHR) {
                        //console.log(data);
                        let obj = $.parseJSON(data);
                        $.each(obj, function (key, value) {
                            $('#departamento').append('<option value="' + value.idDepartamento + '">' + value.departamento + '</option>');
                        });
                        //$('select').formSelect();
                    },
                    error: function (jqXHR, textStatus, errorThrow) {
                        $('#ciudad').append('<option>Departamentos no disponibles</option>');
                    },
                    cache: false
                });

                $('#departamento').change(function () {
                    $('#ciudad').find('option').remove();
                    $('#ciudad').append('<option>Seleccione la ciudad...</option>');

                    let cid = $('#departamento').val();
                    console.log(cid);
                    let data2 = {
                        operacion: "ciudad",
                        id: cid
                    };

                    $.ajax({
                        url: "../../DepartamentoCiudad",
                        method: "GET",
                        data: data2,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            let obj = $.parseJSON(data);
                            $.each(obj, function (key, value) {
                                $('#ciudad').append('<option value="' + value.idCiudad + '">' + value.ciudad + '</option>');
                            });
                            $('select').formSelect();
                        },
                        error: function (jqXHR, textStatus, errorThrow) {
                            $('#ciudad').append('<option>Ciudades no disponibles</option>');
                        },
                        cache: false
                    });
                });
            });
        </script>            
    </body>
</html>
