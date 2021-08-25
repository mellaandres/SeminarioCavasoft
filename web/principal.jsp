
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilop.css" rel="stylesheet" type="text/css"/>
        <title>Inicio</title>
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
        <h1 class="container">Bienvenido al Sistema Trabajador <strong>${txtNombre}</strong></h1>  <!-- COMENTARIO DE PRUEBA -->

        <div class="row">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">¿Cliente Nuevo?</h5>
                        <p class="card-text">Esta opción te permite agregar un nuevo cliente al sistema de CavaSoft. Recuerda seguir todos los pasos para que la información quede guardada exitosamente.</p>
                        <a href="ControladorC?accion=listar" class="btn btn-primary">Registrar nuevo Cliente</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">¿Nueva Orden de Trabajo?</h5>
                        <p class="card-text">Esta opción te permite agregar una nueva orden de trabajo al sistema de CavaSoft.  Recuerda seguir todos los pasos.</p>
                        <a href="ControladorOT?accion=listar" class="btn btn-primary">Registrar Orden de Trabajo</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">¿Nuevo Reporte?</h5>
                        <p class="card-text">Esta opción te permite agregar una nuevo Report al sistema de CavaSoft.  Recuerda seguir todos los pasos.</p>
                        <a href="ControladorR?accion=listar" class="btn btn-primary">Registra nuevo Reporte</a>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">¿Maquina Nueva?</h5>
                        <p class="card-text">Esta opción te permite agregar un nueva maquina al sistema de CavaSoft. Recuerda seguir todos los pasos para que la información quede guardada exitosamente.</p>
                        <a href="ControladorM?accion=listar" class="btn btn-primary">Registrar nueva maquina</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">¿Nueva Faena?</h5>
                        <p class="card-text">Esta opción te permite agregar una nueva faena al sistema de CavaSoft.  Recuerda seguir todos los pasos.</p>
                        <a href="ControladorF?accion=listar" class="btn btn-primary">Registrar nueva faena</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Preguntas frecuentes</h5>
                        <p class="card-text">Esta opción te permitira solucionar tus dudas con respecto al sistema CavaSoft. Si tienes una consulta no dudes en contactarnos.</p>
                        <a href="preguntas.jsp" class="btn btn-primary">Preguntas frecuentes</a>
                        
                    </div>
                </div>
            </div>
            
        </div>
        





    </body>
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script><

</html>
