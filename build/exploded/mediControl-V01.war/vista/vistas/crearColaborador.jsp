<%-- 
    Document   : crearColaborador
    Created on : 17/06/2025, 2:36:47 p. m.
    Author     : kelly
--%>

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
        <link href="../../publico/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <title>Crear Colaborador</title>

    </head>
    <body>
        <%-- Header --%>
        <%@include file="../../plantillas/header_1.jsp" %>
        <%-- Body --%>

        <div class="container">
            <center>
                <h4>Lista de colaboradores</h4>
            </center>                    
        </div>
        
        <%-- Tabla --%>
        <div class="container">
            <div class="input-group w-50">                
                <input type="search" id="buscar" class="form-control" placeholder="Buscar..." aria-label="Input group example" aria-describedby="basic-addon1">
                <span class="input-group-text" id="lupa">
                    <img src="../../publico/iconos/search.svg" width="30" height="24">  
                </span>
            </div>
            <div class="table-responsive">
                <table id="tabla" class="table table-bordered table-striped table-hover" style="width:100%">
                    <thead class="text-center">
                        <tr>
                            <th>Identificación</th>
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Telefono</th>
                            <th>Dirección</th>
                            <th>RH</th>
                            <th>Ciudad</th>
                            <th>Cargo</th>                                                        
                            <th>Fecha Nacimiento</th>                                                        
                            <th>Fecha Ingreso</th>                                                        
                            <th>Fecha Salida</th>                                                        
                        </tr>
                    </thead>
                    <%  Conexion conexion = new Conexion();
                        PreparedStatement ps = null;
                        ResultSet rs = null;

                        String consulta = "SELECT identificacion, nombre, correo, telefono, direccion, rh, ciudad.ciudad, cargo.cargo, nacimiento, ingreso, salida FROM colaborador, ciudad, cargo WHERE colaborador.idCiudad=ciudad.idCiudad AND colaborador.idCargo = cargo.idCargo";
                        
                        ps = (PreparedStatement) conexion.conectar().prepareStatement(consulta);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                    %>
                    <tbody id="tablaActividades" class="text-center">
                        <tr>
                        <td class="text-center"><%= rs.getInt("identificacion")%></td>
                        <td class="text-center"><%= rs.getString("nombre")%></td>
                        <td class="text-center"><%= rs.getString("correo")%></td>
                        <td class="text-center"><%= rs.getString("telefono")%></td>
                        <td class="text-center"><%= rs.getString("direccion")%></td>
                        <td class="text-center"><%= rs.getString("rh")%></td>
                        <td class="text-center"><%= rs.getString("ciudad.ciudad")%></td>
                        <td class="text-center"><%= rs.getString("cargo.cargo")%></td>
                        <td class="text-center"><%= rs.getDate("nacimiento")%></td>
                        <td class="text-center"><%= rs.getDate("ingreso")%></td>
                        <td class="text-center"><%= rs.getDate("salida")%></td>
                        <td class="align-content-lg-center"><center>                        
                            <a href=""><img src="../../publico/iconos/documents.png" width="30" height="24"></a>                       
                            </center></td>
                    </tr>
                    <% };%>
                    </tbody>                                
                </table>
            </div>                    
        </div>
        
        <%-- Fin de la tabla --%>
        <div class="container">
            <center>
                <h4>Crear un nuevo colaborador</h4>
            </center>                    
        </div>
        <div class="container">
            <form action="../../Colaborador" method="POST" class="row g-3">
                
                <div class="col-md-2">
                    <label for="inputColaborador" class="form-label">Identificación</label>
                    <input type="text"id="identificacion" name="identificacion" class="form-control"  title="Ingrese el número de identificación" minlength="6" maxlength="10" required>
                </div>

                <div class="col-md-6">
                    <label for="inputNombre" class="form-label">Nombres y apellidos</label>
                    <input type="text"id="nombres" name="nombres" class="form-control"  title="Ingrese nombres y apellidos" required="">
                </div>

                <div class="col-md-4">
                    <label for="inputCorreo" class="form-label">Correo electrónico</label>
                    <input type="text"id="correo" name="correo" class="form-control"  title="Ingrese el correo electrónico" required="">
                </div>

                <div class="col-md-2">
                    <label for="indicativo" class="form-label">Indicativo</label>
                    <select id="indicativo" name="indicativo" class="form-select">
                        <option selected disabled value="">Seleccione...</option>
                        <% ConsultaIndicativo indicativo = new ConsultaIndicativo(); %>
                        <%= indicativo.obtenerSelectIndicativo() %>
                    </select>                    
                </div>

                <div class="col-md-2">
                    <label for="inputCelular" class="form-label">Celular</label>
                    <input type="tel"id="celular" name="celular" class="form-control"  title="Ingrese el número de celular" minlength="10" maxlength="10" required>
                </div>
                
                <div class="col-md-4">
                    <label for="inputDireccion" class="form-label">Dirección</label>
                    <input type="text"id="direccion" name="direccion" class="form-control"  title="Ingrese una dirección" required>
                </div>    
                
                <div class="col-md-2">
                    <label for="departamento" class="form-label">Departamento</label>
                    <select id="departamento" name="departamento" class="form-select">
                        <option>Seleccione un Departamento</option>
                    </select>                    
                </div>

                <div class="col-md-2">
                    <label for="ciudad" class="form-label">Ciudad</label>
                    <select id="ciudad" name="ciudad" class="form-select">
                        <option>Seleccione una ciudad</option>
                    </select>                    
                </div>
                
                <div class="col-md-2">
                    <label for="rh" class="form-label">Grupo Sanguineo</label>
                    <select id="rh" name="rh" class="form-select">
                        <option selected disabled value="">Seleccione...</option>
                        <% ConsultaRh rh = new ConsultaRh(); %>
                        <%= rh.obtenerSelectRh() %>
                    </select>                    
                </div>    
                    
                <div class="col-md-2">
                    <label for="inputCumpleaños" class="form-label">Fecha de Cumpleaños</label>
                    <input type="date"id="cumpleanos" name="cumpleanos" class="form-control"  title="Seleccione la fecha de cumpleaños" required="">
                </div>    
                
                <div class="col-md-2">
                    <label for="inputIngreso" class="form-label">Fecha de Ingreso</label>
                    <input type="date"id="ingreso" name="ingreso" class="form-control"  title="Seleccione la fecha de ingreso" required="">
                </div>    
                    
                <div class="col-md-2">
                    <label for="cargo" class="form-label">Cargo</label>
                    <select id="cargo" name="cargo" class="form-select">
                        <option selected>Seleccione...</option>
                        <% ConsultaCargo cargo = new ConsultaCargo();%>
                        <%= cargo.obtenerSelectCargo()%>
                    </select>                    
                </div>    

                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button type="submit" name="crearColaborador" value="crearColaborador" class="btn btn-primary">Crear</button>
                    <a class="btn btn-primary" href="../almacenista.jsp" role="button">Regresar</a>
                </div>
            </form>
        </div>


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
