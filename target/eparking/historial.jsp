<%@ page contentType="text/html" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="es">

    <head>

        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Historial | E-Parking</title>

        <link rel="stylesheet" href="css/historial.css">

    </head>

    <body>

        <!-- HEADER -->

        <header class="header">

            <div class="logo">

                <img src="img/logo-eparking.jpeg" alt="logo" width="110" height="32">

            </div>

        </header>

        <!-- MAIN -->

        <main class="container-historial">

            <!-- TITULO -->

            <div class="titulo-container">

                <h1 class="titulo">

                    📋 Historial de Reservas

                </h1>

                <p class="subtitulo">

                    Consulta las reservas realizadas

                </p>

            </div>

            <!-- VOLVER -->

            <div class="contenedor-volver">

                <a href="menu-principal.jsp" class="btn-volver">

                    ← Volver al Menú

                </a>

            </div>

            <!-- BUSQUEDA -->

            <div class="busqueda-container">

                <input type="text" id="inputBuscar" placeholder="Buscar por placa...">

                <button id="btnBuscar" class="btn-buscar">

                    Buscar

                </button>

            </div>

            <!-- ESTADISTICAS -->

            <div class="estadisticas">

                <div class="card-estadistica">

                    <h3>15</h3>

                    <p>Reservas Totales</p>

                </div>

                <div class="card-estadistica activa">

                    <h3>5</h3>

                    <p>Activas</p>

                </div>

                <div class="card-estadistica finalizada">

                    <h3>10</h3>

                    <p>Finalizadas</p>

                </div>

            </div>

            <!-- TABLA -->

            <div class="tabla-container">

                <table>

                    <thead>

                        <tr>

                            <th>Fecha</th>
                            <th>Vehículo</th>
                            <th>Espacio</th>
                            <th>Estado</th>

                        </tr>

                    </thead>

                    <tbody id="tablaHistorial">

                        <tr>

                            <td>12/05/2026</td>
                            <td>ABC123</td>
                            <td>A-12</td>
                            <td class="estado-activa">

                                Activa

                            </td>

                        </tr>

                        <tr>

                            <td>10/05/2026</td>
                            <td>XYZ789</td>
                            <td>B-05</td>
                            <td class="estado-finalizada">

                                Finalizada

                            </td>

                        </tr>

                    </tbody>

                </table>

            </div>

        </main>

        <!-- FOOTER -->

        <footer class="app-footer">

            <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

            <p>
                © 2026 eParking
            </p>


        </footer>

        <script src="js/historial.js"></script>

    </body>

    </html>