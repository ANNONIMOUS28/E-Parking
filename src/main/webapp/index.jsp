<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <!DOCTYPE html>
    <html lang="es">

    <head>

        <!-- Configuración de codificación de caracteres -->
        <meta charset="UTF-8">

        <!-- Permite una correcta adaptación a dispositivos móviles -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Título mostrado en la pestaña del navegador -->
        <title>eParking - Inicio</title>

        <!-- Hoja de estilos principal de la página de inicio -->
        <link rel="stylesheet" href="css/index.css">

    </head>

    <body>

        <!-- Encabezado principal del sitio -->
        <header class="header">

            <!-- Contenedor del logo institucional -->
            <div class="logo">

                <img src="img/logo-eparking.jpeg" alt="Logo eParking" width="120">

            </div>

            <!-- Menú de navegación -->
            <nav>

                <!-- Botón que redirige a la página de inicio de sesión -->
                <button class="btn-login" onclick="window.location.href='login.jsp'">

                    Login

                </button>

            </nav>

        </header>

        <!-- Contenido principal de la página -->
        <main class="main">

            <!-- Sección de bienvenida o presentación del sistema -->
            <section class="hero">

                <!-- Título principal -->
                <h1>
                    Bienvenido a eParking
                </h1>

                <!-- Descripción general del sistema -->
                <p>
                    Sistema para gestión
                    de parqueaderos y reservas.
                    ¡Reserva tu cupo de parqueadero de forma fácil y rápida!
                </p>

                <!-- Imagen representativa del servicio -->
                <img src="img/icono-parqueadero.png" alt="Parqueadero" class="hero-image">

                <!-- Contenedor de botones de acceso y registro -->
                <div class="contenedor-botones">

                    <!-- Botón para acceder al inicio de sesión -->
                    <button class="btn-principal" onclick="window.location.href='login.jsp'">

                        Iniciar Sesión

                    </button>

                    <!-- Botón para dirigirse al formulario de registro -->
                    <button class="btn-secundario" onclick="window.location.href='registro.jsp'">

                        Registrarse

                    </button>

                </div>

            </section>

        </main>

        <!-- Pie de página -->
        <footer class="footer">

            <!-- Logo representativo del proyecto -->
            <img src="img/Logo-software.jpeg" alt="Logo" width="50">

            <!-- Información de derechos de autor -->
            <p>
                © 2026 eParking
            </p>

        </footer>

    </body>

    </html>