<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <!-- Configuración de codificación de caracteres -->
    <meta charset="UTF-8">

    <!-- Permite una correcta visualización en dispositivos móviles -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Título mostrado en la pestaña del navegador -->
    <title>menu-principal</title>

    <!-- Hoja de estilos de la página principal -->
    <link rel="stylesheet" href="css/menu-principal.css">

</head>

<body>

    <!-- Encabezado principal -->
    <header>

        <!-- Logo institucional del sistema -->
        <div class="logo">

            <img src="img/logo-eparking.jpeg"
                 alt="logo oficial-eparking"
                 width="110"
                 height="32">

        </div>

    </header>

    <!-- Contenido principal -->
    <main>

        <!-- Contenedor principal del menú -->
        <section id="menu-principal" class="container-menu-principal">

            <!-- Sección del título principal -->
            <div class="titulo-container">

                <h1 class="menu-principal">

                    🚗 Menu Principal

                </h1>

            </div>

            <!-- Menú de navegación hacia los diferentes módulos -->
            <nav class="menu-principal">

                <!-- Acceso al módulo de vehículos -->
                <button class="btn-menu" id="btn-vehiculo"
                        onclick="window.location.href='vehiculos.jsp'">

                    <img src="img/icono-vehiculos.jpeg"
                         alt="icono de pantalla vehiculos"
                         width="30"
                         height="30">

                    <span>Vehículos</span>

                </button>

                <!-- Acceso al módulo de disponibilidad -->
                <button class="btn-menu" id="btn-ver-disponibilidad"
                        onclick="window.location.href='disponibilidad.jsp'">

                    <img src="img/icono-ver-disponibilidad.png"
                         alt="icono de pantalla disponibilidad"
                         width="30"
                         height="30">

                    <span>Disponibilidad</span>

                </button>

                <!-- Acceso al módulo de reservas -->
                <button class="btn-menu" id="btn-reservas"
                        onclick="window.location.href='reservas.jsp'">

                    <img src="img/icono-reservas.png"
                         alt="icono de pantalla reservas"
                         width="30"
                         height="30">

                    <span>Reservas</span>

                </button>

                <!-- Acceso al historial de reservas -->
                <button class="btn-menu" id="btn-historial"
                        onclick="window.location.href='historial.jsp'">

                    <img src="img/icono-historial.jpeg"
                         alt="icono de pantalla historial"
                         width="30"
                         height="30">

                    <span>Historial</span>

                </button>

                <!-- Acceso al módulo de pagos digitales -->
                <button class="btn-menu" id="btn-pagos-digitales"
                        onclick="window.location.href='pagos.jsp'">

                    <img src="img/icono-pagos-digitales.jpeg"
                         alt="icono de pantalla pagos-digitales"
                         width="30"
                         height="30">

                    <span>Pagos digitales</span>

                </button>

                <!-- Acceso al formulario de registro -->
                <button class="btn-menu" id="btn-registro"
                        onclick="window.location.href='registro.jsp'">

                    <img src="img/icono-registro.png"
                         alt="icono de pantalla registro"
                         width="30"
                         height="30">

                    <span>Registro</span>

                </button>

            </nav>

        </section>

    </main>

    <!-- Pie de página -->
    <footer class="app-footer">

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

    <!-- Archivo JavaScript encargado de las funcionalidades del menú principal -->
    <script src="js/menu-principal.js"></script>

</body>

</html>