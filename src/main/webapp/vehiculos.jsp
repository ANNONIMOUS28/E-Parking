<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <!-- Configuración de codificación -->
    <meta charset="UTF-8">

    <!-- Adaptación a dispositivos móviles -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <!-- Título de la pestaña -->
    <title>Vehículos | E-Parking</title>

    <!-- Hoja de estilos del módulo vehículos -->
    <link rel="stylesheet"
          href="css/vehiculos.css">

</head>

<body>

    <!-- HEADER: Encabezado principal -->
    <header class="header">

        <div class="logo">

            <!-- Logo del sistema -->
            <img src="img/logo-eparking.jpeg"
                 alt="logo eparking"
                 width="110"
                 height="32">

        </div>

    </header>

    <!-- CONTENEDOR PRINCIPAL DE LA PÁGINA -->
    <main class="container-vehiculos">

        <!-- TÍTULO PRINCIPAL -->
        <div class="titulo-container">

            <h1 class="titulo">

                🚗 Gestión de Vehículos

            </h1>

            <p class="subtitulo">

                Registra y administra los vehículos del sistema

            </p>

        </div>

        <!-- BOTÓN PARA VOLVER AL MENÚ PRINCIPAL -->
        <div class="contenedor-volver">

            <a href="menu-principal.jsp"
               class="btn-volver">

                ← Volver al Menú

            </a>

        </div>

        <!-- BOTONES DE ACCIONES RÁPIDAS -->
        <div class="acciones-rapidas">

            <!-- Botón de búsqueda -->
            <button class="btn-secundario"
                    id="btnBuscar">

                🔍 Buscar Vehículo

            </button>

            <!-- Botón exportar PDF -->
            <button class="btn-secundario"
                    id="btnExportar">

                📄 Exportar PDF

            </button>

        </div>

        <!-- BARRA DE BÚSQUEDA -->
        <div class="busqueda-container">

            <input type="text"
                   id="inputBuscar"
                   placeholder="Buscar por placa...">

            <!-- Contenedor de resultados de búsqueda -->
            <div id="resultadoBusqueda"></div>

        </div>

        <!-- SECCIÓN DE ESTADÍSTICAS -->
        <div class="estadisticas">

            <!-- Vehículos registrados -->
            <div class="card-estadistica">

                <h3>2</h3>

                <p>Vehículos Registrados</p>

            </div>

            <!-- Espacios disponibles -->
            <div class="card-estadistica">

                <h3>45</h3>

                <p>Espacios Disponibles</p>

            </div>

            <!-- Reservas activas -->
            <div class="card-estadistica">

                <h3>15</h3>

                <p>Reservas Activas</p>

            </div>

        </div>

        <!-- FORMULARIO DE REGISTRO DE VEHÍCULOS -->
        <form class="formulario-vehiculos"
              action="VehiculoServlet"
              method="post">

            <!-- CAMPO PLACA -->
            <div class="grupo-input">

                <label for="placa">
                    Placa
                </label>

                <input type="text"
                       id="placa"
                       name="placa"
                       placeholder="Ejemplo: ABC123"
                       required>

            </div>

            <!-- CAMPO TIPO DE VEHÍCULO -->
            <div class="grupo-input">

                <label for="tipoVehiculo">
                    Tipo de Vehículo
                </label>

                <select id="tipoVehiculo"
                        name="tipoVehiculo"
                        required>

                    <option value="">
                        Seleccione
                    </option>

                    <option value="Carro">
                        Carro
                    </option>

                    <option value="Moto">
                        Moto
                    </option>

                    <option value="Bicicleta">
                        Bicicleta
                    </option>

                </select>

            </div>

            <!-- CAMPO COLOR -->
            <div class="grupo-input">

                <label for="color">
                    Color
                </label>

                <input type="text"
                       id="color"
                       name="color"
                       placeholder="Ejemplo: Negro"
                       required>

            </div>

            <!-- CAMPO PROPIETARIO -->
            <div class="grupo-input">

                <label for="propietario">
                    Propietario
                </label>

                <input type="text"
                       id="propietario"
                       name="propietario"
                       placeholder="Nombre del propietario"
                       required>

            </div>

            <!-- BOTÓN GUARDAR -->
            <button type="submit"
                    class="btn-guardar">

                Guardar Vehículo

            </button>

        </form>

        <!-- TABLA DE VEHÍCULOS REGISTRADOS -->
        <div class="tabla-container">

            <table>

                <thead>

                    <tr>

                        <th>Placa</th>
                        <th>Tipo</th>
                        <th>Color</th>
                        <th>Propietario</th>

                    </tr>

                </thead>

                <tbody>

                    <!-- Registro ejemplo 1 -->
                    <tr>

                        <td>ABC123</td>
                        <td>Carro</td>
                        <td>Negro</td>
                        <td>Juan Pérez</td>

                    </tr>

                    <!-- Registro ejemplo 2 -->
                    <tr>

                        <td>XYZ789</td>
                        <td>Moto</td>
                        <td>Rojo</td>
                        <td>Laura Gómez</td>

                    </tr>

                </tbody>

            </table>

        </div>

    </main>

    <!-- FOOTER: Pie de página -->
    <footer class="app-footer">

        <!-- Logo del software -->
        <img src="img/Logo-software.jpeg"
             alt="Logo software"
             width="50"
             height="45">

        <p>
            © 2026 eParking
        </p>

    </footer>

    <!-- Archivo JavaScript del módulo vehículos -->
    <script src="js/vehiculos.js"></script>

</body>

</html>