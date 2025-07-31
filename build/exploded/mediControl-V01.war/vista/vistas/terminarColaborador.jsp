<%-- 
    Document   : terminarColaborador
    Created on : 30/07/2025, 8:18:26 a. m.
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
        <link href="../../publico/css/bootstrap.css" type="text/css" rel="stylesheet" />
        <title>Terminar contrato del colaborador</title>
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
                <h4>Módulo para finalizar contratos</h4>
            </center>                    
        </div>
        
        <%
            int identificacion = Integer.parseInt(request.getParameter("id"));
            if (identificacion > 0) {
                Conexion conexion = new Conexion();
                PreparedStatement ps = null;
                ResultSet rs = null;

                String consulta = "SELECT identificacion, nombre, correo, telefono, direccion, colaborador.rh, rh.rh, colaborador.idCiudad, ciudad.ciudad, ciudad.idDepartamento, departamento.departamento, colaborador.idCargo, cargo.cargo, nacimiento, ingreso, salida FROM colaborador, ciudad, cargo, rh, departamento WHERE colaborador.idCiudad=ciudad.idCiudad AND departamento.idDepartamento=ciudad.idDepartamento AND colaborador.idCargo = cargo.idCargo AND colaborador.rh = rh.registro AND colaborador.identificacion=" + identificacion;
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
                    <label for="inputNombre" class="form-label">Nombres y apellidos</label>
                    <input type="text" value="<%= rs.getString("nombre")%>" id="nombres" name="nombres" class="form-control" readonly="">
                </div>

                <div class="col-md-4">
                    <label for="inputCorreo" class="form-label">Correo electrónico</label>
                    <input type="text" value="<%= rs.getString("correo")%>" id="correo" name="correo" class="form-control" readonly="">
                </div>

                <div class="col-md-2">
                    <label for="inputCelular" class="form-label">Celular</label>
                    <input type="text" value="<%= rs.getString("telefono")%>" id="celular" name="celular" class="form-control" readonly="">
                </div>

                <div class="col-md-4">
                    <label for="inputDireccion" class="form-label">Dirección</label>
                    <input type="text" value="<%= rs.getString("direccion")%>" id="direccion" name="direccion" class="form-control"  title="Ingrese una dirección" readonly>
                </div>    

                <div class="col-md-2">
                    <label for="departamento" class="form-label">Departamento</label>
                    <input type="text" value="<%= rs.getString("departamento.departamento")%>" id="direccion" name="direccion" class="form-control"  title="Ingrese una dirección" readonly>
                </div>

                <div class="col-md-2">
                    <label for="ciudad" class="form-label">Ciudad</label>
                    <input type="text" value="<%= rs.getString("ciudad.ciudad")%>" id="direccion" name="direccion" class="form-control"  title="Ingrese una dirección" readonly>
                </div>                  

                <div class="col-md-2">
                    <label for="rh" class="form-label">Grupo Sanguineo</label>
                    <input type="text" value="<%= rs.getString("rh.rh")%>" id="direccion" name="direccion" class="form-control"  title="Ingrese una dirección" readonly>
                </div>        

                <div class="col-md-2">
                    <label for="inputCumpleaños" class="form-label">Fecha de Cumpleaños</label>
                    <input type="text" value="<%= rs.getDate("nacimiento")%>" id="cumpleanos" name="cumpleanos" class="form-control"  title="Seleccione la fecha de cumpleaños" readonly="">
                </div>    

                <div class="col-md-2">
                    <label for="inputIngreso" class="form-label">Fecha de Ingreso</label>
                    <input type="text" value="<%= rs.getDate("ingreso")%>" id="ingreso" name="ingreso" class="form-control"  title="Seleccione la fecha de ingreso" readonly="">
                </div>    

                <div class="col-md-2">
                    <label for="cargo" class="form-label">Cargo</label>
                    <input type="text" value="<%= rs.getString("cargo.cargo")%>" id="ingreso" name="ingreso" class="form-control"  title="Seleccione la fecha de ingreso" readonly="">
                </div>                         
                
                <div class="col-md-2">
                    <label for="inputSalida" class="form-label">Fecha de Salida</label>
                    <input type="date" value="" id="salida" name="salida" class="form-control"  title="Seleccione la fecha de finalización" required="">
                </div>
                
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button type="submit" name="btnColaborador" value="terminarColaborador" class="btn btn-primary">Finalizar</button>                                    
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
        
    </body>
</html>
