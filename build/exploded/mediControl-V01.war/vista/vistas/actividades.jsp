<%-- 
    Document   : actividades
    Created on : 8/07/2025, 3:51:48 p. m.
    Author     : Alvaro Rubiano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controlador.Conexion"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../publico/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <title>Actividades programadas</title>
    </head>
    <body>
        <%-- Header --%>
        <%@include file="../../../plantillas/header.jsp" %>
        <%-- Body --%>

        <div class="container">
            <center>
                <h4>Lista de actividades</h4>
            </center>                    
        </div>

        <%-- Cuerpo de la página --%>

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
                            <th>Paciente</th>
                            <th>Especialista</th>
                            <th>Proveedor</th>
                            <th>Clinica</th>
                            <th>Fecha</th>
                            <th>Descripción</th>
                            <th>Estado</th>                                                        
                        </tr>
                    </thead>
                    
                    <tbody id="tablaActividades" class="text-center">
                        <tr>
                        <td class="text-center"></td>
                        <td class="text-center"></td>
                        <td class="text-center"></td>
                        <td class="text-center"></td>
                        <td class="align-content-lg-center"><center>                        
                            <a href=""><img src="../../publico/iconos/documents.png" width="30" height="24"></a>                       
                            </center></td>
                    </tr>
                        
                    </tbody>                                
                </table>
            </div>                    
        </div>  


        <%-- Fin del cuerpo de la página --%>  


        <%-- Fin de Body --%>
        <%-- Footer --%>
        <%@include file="../../plantillas/footer.jsp" %>
        <script src="../../publico/js/bootstrap.js" type="text/javascript"  ></script>
        <script src="../../publico/js/jQuery_3.7.1.js" type="text/javascript"  ></script>
        <script src="../../publico/js/javascript.js" type="text/javascript"  ></script>

        <script>

            $(document).ready(function () {
                var tabla = $('#tablaActividades').DataTable({
                    ajax: {
                        method: 'POST',
                        url: '../../Actividades',
                        dataSrc: 'datos'
                    },
                    columns: [
                        {data: "identificacion"},
                        {data: "paciente"},
                        {data: "especialista"},
                        {data: "proveedor"},
                        {data: "clinica"},
                        {data: "fecha"},
                        {data: "descripcion"},
                        {data: "estado"}
                    ]
                });

                //$.fn.dataTable.ext.errMode = 'throw';

            });

        </script>


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
