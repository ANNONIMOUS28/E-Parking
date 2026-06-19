<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <!-- Configuración de codificación de caracteres -->
    <meta charset="UTF-8">

    <!-- Permite una correcta visualización en dispositivos móviles -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <!-- Título mostrado en la pestaña del navegador -->
    <title>eParking - Reservas</title>

    <!-- Hoja de estilos de la página de reservas -->
    <link rel="stylesheet"
          href="css/reservas.css">

</head>

<body>

    <!-- Encabezado principal -->
    <header class="header">

        <!-- Logo institucional del sistema -->
        <div class="logo">

            <img src="img/logo-eparking.jpeg"
                 alt="Logo eParking"
                 width="110"
                 height="32">

        </div>

        <!-- Contenedor donde se mostrará el cupo seleccionado -->
        <div class="cupo-seleccionado"
             id="cupoSeleccionado">

        </div>

        <!-- Menú de navegación -->
        <nav>

            <!-- Botón para regresar a la pantalla anterior -->
            <button type="button"
                    class="btn-volver"
                    id="btn-volver">

                Volver

            </button>

        </nav>

    </header>

    <!-- Contenido principal -->
    <main>

        <!-- Contenedor principal del formulario de reservas -->
        <section class="container-reservas">

            <!-- Título de la sección -->
            <h1 class="reservas-title">

                Reservar Cupo

            </h1>

            <!-- Imagen representativa del módulo de reservas -->
            <img src="img/icono-reservas.png"
                 alt="Reservas"
                 class="reservas-image">

            <!-- Subtítulo informativo -->
            <h2 class="reservas-subtitle">

                Completa la información

            </h2>

            <!-- Formulario para registrar la reserva -->
            <form id="formulario-reserva"
                  class="formulario">

                <!-- Campo para ingresar el nombre completo -->
                <div class="form-campo">

                    <input type="text"
                           id="nombre"
                           placeholder="Nombre completo"
                           required>

                </div>

                <!-- Campo para ingresar la placa del vehículo -->
                <div class="form-campo">

                    <input type="text"
                           id="placa"
                           placeholder="Placa del vehículo"
                           required>

                </div>

                <!-- Campo para seleccionar la fecha de reserva -->
                <div class="form-campo">

                    <input type="date"
                           id="fecha"
                           required>

                </div>

                <!-- Campo para seleccionar la hora de reserva -->
                <div class="form-campo">

                    <input type="time"
                           id="hora"
                           required>

                </div>

                <!-- Botón para confirmar la reserva -->
                <button type="submit"
                        class="btn-reservar"
                        id="btn-reservar">

                    Reservar

                </button>

            </form>

        </section>

    </main>

    <!-- Pie de página -->
    <footer class="footer">

        <!-- Logo representativo del proyecto -->
        <img src="img/Logo-software.jpeg"
             alt="Logo software"
             width="50"
             height="45">

        <!-- Información de derechos de autor -->
        <p>
            © 2026 eParking
        </p>

    </footer>

    <!-- Archivo JavaScript encargado de la lógica y validaciones de reservas -->
    <script src="js/reservas.js"></script>

</body>

</html>