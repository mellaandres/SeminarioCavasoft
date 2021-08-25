<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilop.css" rel="stylesheet" type="text/css"/>
        
        <title>Inicio</title>
        <!-- Estilos para que no salga las cosas en el imprimir pdf-->
        <style type="text/css" media="print">
            @media print{
                #nav1{
                    display: none;  
                }
                #a1{
                    display: none;
                }
                #a2{
                    display: none;
                }
                #a3{
                    display: none;
                }
                #a4{
                    display: none;
                }
            } 
        </style>
        
        
    </head>
    <body>
        <nav id="nav1" class="navbar navbar-expand-lg navbar-light bg-light">
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
                        <li>
                            <a class="nav-link" href="ControladorR?accion=listar">Agregar Report</a>
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
                    <h1>Impresion de Reportes</h1>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID reporte</th>
                                <th>Horometro Inicial</th>
                                <th>Horometro Final</th>
                                <th>Horas</th>
                                <th>Nombre Operador</th>
                                <th>Maquina</th>
                                <th>Folio</th>
                                <th>Faena</th>
                                <th>Fecha Diaria</th>
                                <th>Cantidad Petroleo</th>
                                <th>Observaciones</th>
                                <th id="a4">Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${impresion}">
                                <tr>
                                    <td>${car.getIDRep()}</td>
                                    <td>${car.getHorometroInicial()}</td>
                                    <td>${car.getHorometroFinal()}</td>
                                    <td>${car.getHoras()}</td>
                                    <td>${car.getNombreOperador()}</td>
                                    <td>${car.getMaquina()}</td>
                                    <td>${car.getFolio()}</td>
                                    <td>${car.getDetalle()}</td>
                                    <td>${car.getFechaDiaria()}</td>
                                    <td>${car.getCantidadPetroleo()}</td>
                                    <td>${car.getObservaciones()}</td>
                                    <td>
                                        <a id="a3" class="btn btn-info" href="ControladorR?accion=Delete&idrep=${car.getIDRep()}" id="btnDelete">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>
                    <a id="a1" class="btn btn-info" href="principal.jsp">Inicio</a>
                    <a id="a2" class="btn btn-info" onclick="print()">Imprimir</a>
                </div>
            </div>
        </span>








    </body>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="js/funciones.js" type="text/javascript"></script>
</html>
