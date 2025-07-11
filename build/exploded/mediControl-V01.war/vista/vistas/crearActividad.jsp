<%-- 
    Document   : crearActividad
    Created on : 9/07/2025, 3:54:23 p. m.
    Author     : Alvaro Rubiano
--%>

<%@page import="controlador.ConsultaCllinica"%>
<%@page import="controlador.ConsultaProveedor"%>
<%@page import="controlador.ConsultaEspecialista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../publico/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <title>Crear Actividad</title>
    </head>
    <body>
        <%-- Header --%>
        <%@include file="../../../plantillas/header.jsp" %>
        <%-- Body --%>
        <div class="container">
            <center>
                <h4>Crear Actividad</h4>
            </center>                    
        </div>

        <%-- Cuerpo de la página --%>
        <div class="container">
            <form action="../../Actividad?accion=actualizar" method="POST" enctype="multipart/form-data" > 

                <div class="col-md-2">
                    <label for="inputPaciente" class="form-label">Identificación</label>
                    <input type="text"id="identificacion" name="identificacion" class="form-control"  title="Ingrese el número de identificación" minlength="6" maxlength="10" required>
                </div>

                <div class="col-md-6">
                    <label for="inputNombre" class="form-label">Nombres y apellidos</label>
                    <input type="text"id="nombres" name="nombres" class="form-control"  title="Ingrese nombres y apellidos" required="">
                </div>

                <div class="col-md-2">
                    <label for="inputEspecialista" class="form-label">Especialista</label>
                    <select id="indicativo" name="indicativo" class="form-select">
                        <option selected disabled value="">Seleccione...</option>
                        <% ConsultaEspecialista especialista = new ConsultaEspecialista();%>
                        <%= especialista.obtenerSelectEspecialista()%>
                    </select>                    
                </div>

                <div class="col-md-2">
                    <label for="inputProveedor" class="form-label">Proveedor</label>
                    <select id="rh" name="rh" class="form-select">
                        <option selected disabled value="">Seleccione...</option>
                        <% ConsultaProveedor proveedor = new ConsultaProveedor();%>
                        <%= proveedor.obtenerSelectProveedor()%>
                    </select>                    
                </div>    

                <div class="col-md-2">
                    <label for="inputClinica" class="form-label">Clinica</label>
                    <select id="cargo" name="cargo" class="form-select">
                        <option selected>Seleccione...</option>
                        <% ConsultaCllinica clinica = new ConsultaCllinica();%>
                        <%= clinica.obtenerSelectClinica()%>
                    </select>                    
                </div>    

                <div class="col-md-2">
                    <label for="inputFechaProgramada" class="form-label">Fecha programada</label>
                    <input type="date"id="ingreso" name="ingreso" class="form-control"  title="Seleccione la fecha de ingreso" required="">
                </div>    

                <div class="col-12">
                    <div class="form-group">
                        <label for="inputValidaciones">Observaciones</label><br>                                                          
                        <textarea class="form-control" id="observaciones" name="observaciones" required></textarea>
                    </div>
                </div>
                
                <div class="col-md-2">
                    <label for="inputEstado" class="form-label">Estado de la actividad</label>
                    <select id="estado" name="estado" class="form-select">
                        <option selected>Seleccione...</option>
                        
                    </select>                    
                </div>

                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button type="submit" name="crearColaborador" value="crearColaborador" class="btn btn-primary">Crear</button>
                    <a class="btn btn-primary" href="../almacenista.jsp" role="button">Regresar</a>
                </div>


            </form>   
        </div>
        <%-- Fin del cuerpo de la página --%>


        <%-- Footer --%>
        <%@include file="../../plantillas/footer.jsp" %>

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
