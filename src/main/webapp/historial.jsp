<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <!-- Configuración de codificación de caracteres -->
    <meta charset="UTF-8">

    <!-- Permite la correcta visualización en dispositivos móviles -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Título mostrado en la pestaña del navegador -->
    <title>Historial | E-Parking</title>

    <!-- Hoja de estilos de la página de historial -->
    <link rel="stylesheet" href="css/historial.css">

</head>

<body>

    <!-- Encabezado principal -->
    <header class="header">

        <!-- Logo institucional del sistema -->
        <div class="logo">

            <img src="img/logo-eparking.jpeg" alt="logo" width="110" height="32">

        </div>

    </header>

    <!-- Contenido principal -->
    <main class="container-historial">

        <!-- Sección de título y descripción -->
        <div class="titulo-container">

            <h1 class="titulo">

                📋 Historial de Reservas

            </h1>

            <p class="subtitulo">

                Consulta las reservas realizadas

            </p>

        </div>

        <!-- Enlace para regresar al menú principal -->
        <div class="contenedor-volver">

            <a href="menu-principal.jsp" class="btn-volver">

                ← Volver al Menú

            </a>

        </div>

        <!-- Sección de búsqueda de reservas -->
        <div class="busqueda-container">

            <!-- Campo para buscar reservas por placa -->
            <input type="text" id="inputBuscar" placeholder="Buscar por placa...">

            <!-- Botón que ejecuta la búsqueda -->
            <button id="btnBuscar" class="btn-buscar">

                Buscar

            </button>

        </div>

        <!-- Tarjetas de estadísticas del historial -->
        <div class="estadisticas">

            <!-- Total de reservas registradas -->
            <div class="card-estadistica">

                <h3>15</h3>

                <p>Reservas Totales</p>

            </div>

            <!-- Cantidad de reservas activas -->
            <div class="card-estadistica activa">

                <h3>5</h3>

                <p>Activas</p>

            </div>

            <!-- Cantidad de reservas finalizadas -->
            <div class="card-estadistica finalizada">

                <h3>10</h3>

                <p>Finalizadas</p>

            </div>

        </div>

        <!-- Contenedor de la tabla de historial -->
        <div class="tabla-container">

            <table>

                <!-- Encabezados de la tabla -->
                <thead>

                    <tr>

                        <th>Fecha</th>
                        <th>Vehículo</th>
                        <th>Espacio</th>
                        <th>Estado</th>

                    </tr>

                </thead>

                <!-- Cuerpo de la tabla con los registros -->
                <tbody id="tablaHistorial">

                    <!-- Registro de reserva activa -->
                    <tr>

                        <td>12/05/2026</td>
                        <td>ABC123</td>
                        <td>A-12</td>
                        <td class="estado-activa">

                            Activa

                        </td>

                    </tr>

                    <!-- Registro de reserva finalizada -->
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

    <!-- Pie de página -->
    <footer class="app-footer">

        <!-- Logo representativo del proyecto -->
        <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

        <!-- Información de derechos de autor -->
        <p>
            © 2026 eParking
        </p>

    </footer>

    <!-- Archivo JavaScript encargado de las búsquedas y funcionalidades del historial -->
    <script src="js/historial.js"></script>

</body>

</html>