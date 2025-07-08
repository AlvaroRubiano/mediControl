<%-- 
    Document   : crearProveedor
    Created on : 7/07/2025, 8:54:26 a. m.
    Author     : Alvaro Rubiano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../publico/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <title>Crear Proveedor</title>
    </head>
    <body>
        <%-- Header --%>
        <%@include file="../../../plantillas/header.jsp" %>
        <%-- Body --%>

        <div class="container">
            <center>
                <h4>Crear nuevo proveedor</h4>
            </center>                    
        </div>

        <div class="container">
            <form action="../../Proveedor" method="POST" class="row g-3">
                
                <div class="col-md-1">
                    <label for="inputNit" class="form-label">NIT</label>
                    <input type="text"id="nit" name="nit" class="form-control"  title="Ingrese el número de NIT" required="">
                </div>
                
                <div class="col-md-3">
                    <label for="inputNombre" class="form-label">Nombre del Proveedor</label>
                    <input type="text"id="nombres" name="nombres" class="form-control"  title="Ingrese nombre del proveedor" required="">
                </div>
                
                <div class="col-md-3">
                    <label for="inputDireccion" class="form-label">Dirección</label>
                    <input type="text"id="direccion" name="direccion" class="form-control"  title="Ingrese la dirección" required="">
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
                    <button type="submit" name="crearProveedor" value="crearProveedor" class="btn btn-primary">Crear</button>
                    <a class="btn btn-primary" href="../almacenista.jsp" role="button">Regresar</a>
                </div>
            </form>
        </div>


        <%-- Fin de Body --%>
        <%-- Footer --%>
        <%@include file="../../plantillas/footer.jsp" %>
        <script src="../../publico/js/bootstrap.js" type="text/javascript"  ></script>
        <script src="../../publico/js/jQuery_3.7.1.js" type="text/javascript"  ></script>
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
