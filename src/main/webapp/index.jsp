<%-- 
    Document   : index
    Created on : 17/06/2025, 1:37:47 p. m.
    Author     : Alvaro Rubiano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="publico/css/bootstrap.css" type="text/css" rel="stylesheet">
        <link href="publico/css/personalizado.css" type="text/css" rel="stylesheet">
        <title>Inicio</title>
    </head>
    <body>
        <div class="container text-center" style="margin-top: 25vw;">
            <div class="row justify-content-md-center">
                <div class="col-md-auto">
                    <form  action="Login" method="POST">
                        <div class="mb-3">
                            <div id="text" class="form-text">Nunca comparta su usuario con otras personas</div>
                            <input type="text" class="form-control" id="usuario" name="usuario" aria-describedby="usuario" placeholder="Usuario">                            
                        </div>
                        <div class="mb-3">
                            <input type="password" class="form-control" id="password" name="password"  placeholder="Contraseña">
                        </div>
                        <button type="submit" id="login" name="login" value="login" class="btn btn-primary">Ingresar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
