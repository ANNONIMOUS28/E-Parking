<%@ page contentType="text/html" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="es">

    <head>

        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Disponibilidad | E-Parking</title>

        <link rel="stylesheet" href="css/disponibilidad.css">

    </head>

    <body>

        <!-- HEADER -->

        <header class="header">

            <div class="logo">

                <img src="img/logo-eparking.jpeg" alt="logo" width="110" height="32">

            </div>

        </header>

        <!-- MAIN -->

        <main class="container-disponibilidad">

            <!-- TITULO -->

            <div class="titulo-container">

                <h1 class="titulo">

                    🅿️ Disponibilidad de Cupos

                </h1>

                <p class="subtitulo">

                    Consulta los espacios disponibles

                </p>

            </div>

            <!-- VOLVER -->

            <div class="contenedor-volver">

                <a href="menu-principal.jsp" class="btn-volver">

                    ← Volver al Menú

                </a>

            </div>

            <!-- ESTADISTICAS -->

            <div class="estadisticas">

                <div class="card disponible">

                    <h2>45</h2>

                    <p>Disponibles</p>

                </div>

                <div class="card ocupado">

                    <h2>15</h2>

                    <p>Ocupados</p>

                </div>

            </div>

            <!-- FILTROS -->

            <div class="filtros">

                <button class="btn-filtro" data-tipo="todos">

                    Todos

                </button>

                <button class="btn-filtro" data-tipo="disponible">

                    Disponibles

                </button>

                <button class="btn-filtro" data-tipo="ocupado">

                    Ocupados

                </button>

            </div>

            <!-- GRID CUPOS -->

            <div class="grid-cupos" id="gridCupos">

                <div class="cupo disponible" data-cupo="A-01">

                    A-01

                </div>
                <div class="cupo disponible" data-cupo="A-02">

                    A-02

                </div>
                <div class="cupo disponible" data-cupo="A-03">

                    A-03

                </div>
                <div class="cupo disponible" data-cupo="A-04">

                    A-04

                </div>

                <div class="cupo ocupado" data-cupo="B-01">

                    B-01

                </div>
<div class="cupo ocupado" data-cupo="B-02">

                    B-02

                </div>
                <div class="cupo ocupado" data-cupo="B-03">

                    B-03

                </div>
                <div class="cupo ocupado" data-cupo="B-04">

                    B-04

                </div>
        </main>

        <!-- FOOTER -->

        <footer class="app-footer">

            <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

            <p>
                © 2026 eParking
            </p>

        </footer>

        <script src="js/disponibilidad.js"></script>

    </body>

    </html>