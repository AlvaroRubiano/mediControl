<%-- 
    Document   : crearEspecialista
    Created on : 4/07/2025, 1:27:29 p. m.
    Author     : Alvaro Rubiano
--%>

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
        <link href="../../publico/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <title>Lista de especialistas</title>
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
                <h4>Lista de especialistas</h4>
            </center>                    
        </div>

        <%-- Tabla --%>
        <div class="container">
            <div class="input-group w-50">
                <input type="search" id="buscar" class="form-control" placeholder="Buscar..." aria-label="Input group example" aria-describedby="basic-addon1">
                <span class="input-group-text" id="lupa">
                    <img src="../../publico/iconos/search.svg" width="30" height="24">  
                </span>

                <!-- Button trigger modal -->
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar</button>                    
                </div>

            </div>


            <!-- Fin Button trigger modal -->
            <div class="table-responsive">
                <table id="tablaActividades" class="table table-bordered table-striped table-hover" style="width:100%">
                    <thead class="text-center">
                        <tr>
                            <th>Registro o Identificación</th>
                            <th>Nombre</th>
                            <th>Ciudad</th>
                        </tr>
                    </thead>
                    <%  Conexion conexion = new Conexion();
                        PreparedStatement ps = null;
                        ResultSet rs = null;

                        String consulta = "SELECT identificacion, nombre, ciudad.ciudad FROM especialista, ciudad WHERE especialista.idCiudad=ciudad.idCiudad";

                        ps = (PreparedStatement) conexion.conectar().prepareStatement(consulta);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                    %>
                    <tbody id="tabla" class="text-center">
                        <tr>
                            <td class="text-center"><%= rs.getString("identificacion")%></td>
                            <td class="text-center"><%= rs.getString("nombre")%></td>
                            <td class="text-center"><%= rs.getString("ciudad.ciudad")%></td>
                        </tr>
                        <% };%>
                    </tbody>                                
                </table>
            </div>                    
        </div>
        <!-- Fin de la tabla -->

        <!-- Modal -->
        <div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Crear un nuevo especialista</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="container">
                            <form action="../../CrearEspecialista" method="POST" class="row g-3">

                                <div class="col-md-3">
                                    <label for="inputRegistro" class="form-label">Registro o número de cédula</label>
                                    <input type="text"id="registro" name="registro" class="form-control"  title="Ingrese el registro o número de cedula" required="">
                                </div>

                                <div class="col-md-4">
                                    <label for="inputNombre" class="form-label">Nombres y apellidos</label>
                                    <input type="text"id="nombres" name="nombres" class="form-control"  title="Ingrese nombres y apellidos" required="">
                                </div>

                                <div class="col-md-2">
                                    <label for="departamento" class="form-label">Departamento</label>
                                    <select id="departamento" name="departamento" class="form-select">
                                        <option>Seleccione un Departamento</option>
                                    </select>                    
                                </div>

                                <div class="col-md-3">
                                    <label for="ciudad" class="form-label">Ciudad</label>
                                    <select id="ciudad" name="ciudad" class="form-select">
                                        <option>Seleccione una ciudad</option>
                                    </select>                    
                                </div>

                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                    <button type="submit" name="crearEspecialista" value="crearEspecialista" class="btn btn-primary">Crear</button>                                    
                                </div>
                            </form>
                        </div>
                    </div><!<!-- Final de modal body -->                    
                </div><!<!-- Fin de modal-content -->
            </div><!<!-- Fin de modal-dialog -->
        </div><!<!-- Fin del modal -->

        <%-- Fin de Body --%>
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
