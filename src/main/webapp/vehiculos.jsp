<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Vehículos | E-Parking</title>

    <link rel="stylesheet"
          href="css/vehiculos.css">

</head>

<body>

    <!-- HEADER -->

    <header class="header">

        <div class="logo">

            <img src="img/logo-eparking.jpeg"
                 alt="logo eparking"
                 width="110"
                 height="32">

        </div>

    </header>

    <!-- CONTENEDOR PRINCIPAL -->

    <main class="container-vehiculos">

        <!-- TITULO -->

        <div class="titulo-container">

            <h1 class="titulo">

                🚗 Gestión de Vehículos

            </h1>

            <p class="subtitulo">

                Registra y administra los vehículos del sistema

            </p>

        </div>

        <!-- BOTON VOLVER -->

        <div class="contenedor-volver">

            <a href="menu-principal.jsp"
               class="btn-volver">

                ← Volver al Menú

            </a>

        </div>

        <!-- ACCIONES -->

        <div class="acciones-rapidas">

            <button class="btn-secundario"
                    id="btnBuscar">

                🔍 Buscar Vehículo

            </button>

            <button class="btn-secundario"
                    id="btnExportar">

                📄 Exportar PDF

            </button>

        </div>

        <!-- BUSQUEDA -->

        <div class="busqueda-container">

            <input type="text"
                   id="inputBuscar"
                   placeholder="Buscar por placa...">

            <div id="resultadoBusqueda"></div>

        </div>

        <!-- ESTADISTICAS -->

        <div class="estadisticas">

            <div class="card-estadistica">

                <h3>2</h3>

                <p>Vehículos Registrados</p>

            </div>

            <div class="card-estadistica">

                <h3>45</h3>

                <p>Espacios Disponibles</p>

            </div>

            <div class="card-estadistica">

                <h3>15</h3>

                <p>Reservas Activas</p>

            </div>

        </div>

        <!-- FORMULARIO -->

        <form class="formulario-vehiculos"
              action="VehiculoServlet"
              method="post">

            <!-- PLACA -->

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

            <!-- TIPO -->

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

            <!-- COLOR -->

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

            <!-- PROPIETARIO -->

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

            <!-- BOTON -->

            <button type="submit"
                    class="btn-guardar">

                Guardar Vehículo

            </button>

        </form>

        <!-- TABLA -->

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

                    <tr>

                        <td>ABC123</td>
                        <td>Carro</td>
                        <td>Negro</td>
                        <td>Juan Pérez</td>

                    </tr>

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

    <!-- FOOTER -->

    <footer class="app-footer">

        <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

            <p>
                © 2026 eParking
            </p>


    </footer>

    <script src="js/vehiculos.js"></script>

</body>

</html>