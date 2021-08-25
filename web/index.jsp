
<%-- 
    Document   : principal
    Created on : 2 jun. 2021, 15:19:45
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <div class="container col-lg-3">
            <form action="ControladorT">
                <div class="form-group text-center">
                <img src="img/cavasal.png" alt=""/>
                <p><strong>Bienvenido a CavaSoft</strong></p>
                </div>
                <div class="form-group">
                    <label>Nombre</label>
                    <input class="form-control" type="text" name="txtNombre" placeholder="Ingrese nombre">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input class="form-control" type="email" name="txtCorreo" placeholder="ejemplo@gmail.com">
                </div>
                <br>
                <input class="btn btn-danger" type="submit" name="accion" value="Ingresar">
            </form>
        </div>
    </body>
</html>

