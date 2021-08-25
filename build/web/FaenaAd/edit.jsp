<%-- 
    Document   : edit
    Created on : 10 abr. 2021, 19:48:20
    Author     : Andres
--%>


<%@page import="Modelo.OrdenTrabajo"%>
<%@page import="ModeloDAO.OrdenTrabajoDAO"%>
<%@page import="Modelo.Maquina"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.MaquinaDAO"%>
<%@page import="Modelo.Faena"%>
<%@page import="ModeloDAO.FaenaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar Faena</title>
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
        <div class="p-3 mb-2 bg-light text-dark container col-lg-6">
            <div class="col-lg-12">
                <h1>Modificar Faena</h1>
                <form action="ControladorF" class="row g-3">
                <div class="col-6">
                Orden de trabajo asociada<br>
                    <select name="txtOTaso"class="form-select" aria-label="Default select example">
                        <option selected>Seleccione Maquina</option>
                        <%
                            OrdenTrabajoDAO od = new OrdenTrabajoDAO();
                            List<OrdenTrabajo> ot = od.listar();
                            for(OrdenTrabajo o: ot){
                         %>
                        <option value=<%= o.getUbicacion()%>><%=o.getUbicacion()%></option>
                        <%}%>
                    </select><br>
                </div>
                <div class="col-6">
                <%
                    FaenaDAO dao = new FaenaDAO();
                    int IDFaena = Integer.parseInt((String) request.getAttribute("idfa"));
                    Faena f = (Faena) dao.list(IDFaena);
                %>
                    Nombre Faena<br>
                    <input class="form-control" type="text" name="txtDetalle" value="<%= f.getDetalle()%>"><br>
                </div>
                <div class="col-6">
                    Maquina
                    <select name="txtMaquina"class="form-select" aria-label="Default select example">
                        <option selected>Seleccione Maquina</option>
                        <%
                            MaquinaDAO dax = new MaquinaDAO();
                            List<Maquina> ma = dax.listar();
                            for (Maquina m : ma) {
                        %>
                        <option value=<%= m.getNombre()%>><%= m.getNombre()%></option>
                        <%}%>
                    </select><br>
                </div>
                    <div class="col-6">
                    Trabajo Realizado<br>
                    <select class="form-select" aria-label="Default select example" name="txtTrabajoRealizado">
                        <option selected>Trabajos</option>
                        <option value="Subsolado">Subsolado</option>
                        <option value="Tranques">Tranques</option>
                        <option value="ObraCivil">Obra civil</option>
                        <option value="Plataforma">Plataforma</option>
                        <option value="Vertederos">Vertederos</option>
                    </select><br>
                    </div>
                    <div class="col-6">
                    Fecha Inicial<br>
                    <input class="form-control" type="text" name="txtFechaInicial" value="<%= f.getFechaInicial()%>"><br>
                    </div>
                    <div class="col-6">
                    Fecha Final<br>
                    <input class="form-control" type="text" name="txtFechaFinal" value="<%= f.getFechaFinal()%>"><br>
                    </div>
                    <div class="col-12">
                    Observaciones<br>
                    <input class="form-control" type="text" name="txtObservaciones" value="<%= f.getObservaciones()%>"><br>
                    </div>
                    <input type="hidden" name="txtIDFaena" value="<%= f.getIDFaena()%>">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                    <a class="btn btn-primary" href="ControladorF?accion=listar">Regresar</a>
                        </div>
                </form>
            </div>
        </div>
        </span>
    </body>
      <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</html>
