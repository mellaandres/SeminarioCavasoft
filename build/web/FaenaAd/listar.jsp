<%-- 
    Document   : listar
    Created on : 10 abr. 2021, 19:48:26
    Author     : Andres
--%>


<%@page import="ModeloDAO.FaenaDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Faena"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Listar Faena </title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="principal.jsp">CavaSoft</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="ControladorC?accion=listar">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ControladorM?accion=listar">Maquina</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ControladorOT?accion=listar">Orden de trabajo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ControladorF?accion=listar">Faena</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ControladorR?accion=listar">Reporte</a>
                        </li>
                        <li>
                            <a class="nav-link" href="ControladorAdmin?accion=listar">Administrador</a>
                        </li>
                        <li>
                            <a class="nav-link" href="ControladorT?accion=listar">Trabajador</a>
                        </li>
                    </ul>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Cerrar Sesion
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item">${txtNombre}</a></li>
                            <li><a class="dropdown-item text-center">${txtCorreo}</a></li>
                            <div class="dropdown-divider"></div>
                            <li><a class="dropdown-item text-center" href="index.jsp">Salir</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <span class="border">
            <div class="p-3 mb-2 bg-light text-dark container col-lg-12">
                <div class="col-lg-12">  
            <h1>Faenas</h1>
            <div class="navbar">
            <a class="btn btn-info" href="ControladorF?accion=add">Agregar Faena</a> 
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>OT asociada</th>
                        <th>Nombre Faena</th>
                        <th>Maquina</th>
                        <th>Trabajo Realizado</th>
                        <th>Fecha Inicial</th>
                        <th>Fecha Final</th>
                        <th>Observaciones</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <%
                    FaenaDAO dao = new FaenaDAO();
                    List<Faena> list = dao.listar();
                    Iterator<Faena> iter = list.iterator();
                    Faena fa = null;
                    while (iter.hasNext()) {
                        fa = iter.next();


                %>
                <tbody>
                    <tr>
                        <td><%= fa.getIDFaena()%></td>
                        <td><%= fa.getOTaso()%></td>
                        <td><%= fa.getDetalle()%></td>
                        <td><%= fa.getMaquina()%></td>
                        <td><%= fa.getTrabajoRealizado()%></td>
                        <td><%= fa.getFechaInicial()%></td>
                        <td><%= fa.getFechaFinal()%></td>
                        <td><%= fa.getObservaciones()%></td>
                        <td>
                            <a class="btn btn-info" href="ControladorF?accion=editar&IDFaena=<%= fa.getIDFaena()%>">Editar</a>
                            <a class="btn btn-info" href="ControladorF?accion=eliminar&IDFaena=<%= fa.getIDFaena()%>">Eliminar</a>
                            
                        </td>
                
                
                </tr>
                <%}%>
                </tbody>

            </table>

            <a class="btn btn-info" href="principal.jsp">Inicio</a>

        </div>


            </div>
        </span>
    </body>
    
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</html>
