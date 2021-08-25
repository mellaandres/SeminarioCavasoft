<%-- 
    Document   : edit
    Created on : 10 abr. 2021, 21:30:35
    Author     : Andres
--%>

<%@page import="Modelo.Maquina"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.MaquinaDAO"%>
<%@page import="ModeloDAO.ReporteDAO"%>
<%@page import="Modelo.Reporte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Editar Reporte</title>
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
                <h1>Modificar Reporte</h1>

                <%
                    ReporteDAO dao = new ReporteDAO();
                    int IDRep = Integer.parseInt((String) request.getAttribute("idrep"));
                    Reporte r = (Reporte) dao.list(IDRep);
                %>
                <form action="ControladorR" class="row g-3">
                    <div class="col-6">
                    Horometro Inicial<br>  
                    <input class="form-control" type="text" name="txtHorometroInicial" value="<%= r.getHorometroInicial()%>"><br>
                    </div>
                    <div class="col-6">
                    Horometro Final<br>
                    <input class="form-control" type="text" name="txtHorometroFinal" value="<%= r.getHorometroFinal()%>"><br>
                    </div>
                    <div class="col-6">
                    Nombre Operador<br>
                    <input class="form-control" type="text" name="txtNombreOperador" value="<%= r.getNombreOperador()%>"><br>
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
                    </select>
                    </div>
                    <div class="col-6">
                    Folio
                    <input class="form-control" type="text" name="txtFolio" value="<%= r.getFolio()%>"><br>
                    </div>
                    <div class="col-6">
                    Detalle<br>
                    <input class="form-control" type="text" name="txtDetalle" value="<%= r.getDetalle()%>"><br>
                    </div>
                    <div class="col-6">
                    Fecha Diaria<br>
                    <input class="form-control" type="text" name="txtFechaDiaria" value="<%= r.getFechaDiaria()%>"><br>
                    </div>
                    <div class="col-6">
                    Cantidad Petroleo<br>
                    <input class="form-control" type="text" name="txtCantidadPetroleo" value="<%= r.getCantidadPetroleo()%>"><br>
                    </div>
                    <div class="col-12">
                    Observaciones<br>
                    <input class="form-control" type="text" name="txtObservaciones" value="<%= r.getObservaciones()%>"><br>
                    </div>
                    <input type="hidden" name="txtIDRep" value="<%= r.getIDRep()%>">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                        <a class="btn btn-primary" href="ControladorR?accion=listar">Regresar</a>
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
