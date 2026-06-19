<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <!-- Configuración de codificación de caracteres -->
    <meta charset="UTF-8">

    <!-- Adaptación de la interfaz a dispositivos móviles -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Título mostrado en la pestaña del navegador -->
    <title>Disponibilidad | E-Parking</title>

    <!-- Hoja de estilos de la página de disponibilidad -->
    <link rel="stylesheet" href="css/disponibilidad.css">

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
    <main class="container-disponibilidad">

        <!-- Sección del título principal -->
        <div class="titulo-container">

            <h1 class="titulo">

                🅿️ Disponibilidad de Cupos

            </h1>

            <p class="subtitulo">

                Consulta los espacios disponibles

            </p>

        </div>

        <!-- Botón para regresar al menú principal -->
        <div class="contenedor-volver">

            <a href="menu-principal.jsp" class="btn-volver">

                ← Volver al Menú

            </a>

        </div>

        <!-- Tarjetas de estadísticas de ocupación -->
        <div class="estadisticas">

            <!-- Cantidad de cupos disponibles -->
            <div class="card disponible">

                <h2>45</h2>

                <p>Disponibles</p>

            </div>

            <!-- Cantidad de cupos ocupados -->
            <div class="card ocupado">

                <h2>15</h2>

                <p>Ocupados</p>

            </div>

        </div>

        <!-- Filtros para visualizar los cupos -->
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

        <!-- Contenedor que muestra los cupos del parqueadero -->
        <div class="grid-cupos" id="gridCupos">

            <!-- Cupos disponibles -->
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

            <!-- Cupos ocupados -->
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

    <!-- Archivo JavaScript encargado de los filtros y funcionalidades de disponibilidad -->
    <script src="js/disponibilidad.js"></script>

</body>

</html>