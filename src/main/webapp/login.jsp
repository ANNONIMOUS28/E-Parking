<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <!-- Configuración de codificación de caracteres -->
    <meta charset="UTF-8">

    <!-- Permite una correcta visualización en dispositivos móviles -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Título mostrado en la pestaña del navegador -->
    <title>eParking - Login</title>

    <!-- Enlace a la hoja de estilos de la página de inicio de sesión -->
    <link rel="stylesheet" href="css/login.css">

</head>

<body>

    <!-- Encabezado principal de la página -->
    <header class="header">

        <!-- Contenedor del logo institucional -->
        <div class="logo">

            <img src="img/logo-eparking.jpeg" alt="Logo eParking" width="110" height="32">

        </div>

        <!-- Menú de navegación -->
        <nav>

            <!-- Botón para regresar a la página principal -->
            <button type="button" class="btn-volver" onclick="window.location.href='index.jsp'">

                Inicio

            </button>

        </nav>

    </header>

    <!-- Contenido principal de la página -->
    <main>

        <!-- Sección que contiene el formulario de inicio de sesión -->
        <section class="container-login">

            <!-- Título principal -->
            <h1 class="login-title">

                Inicio de Sesión

            </h1>

            <!-- Imagen representativa del inicio de sesión -->
            <img src="img/icono-inicio-sesion.png" alt="Icono Login" class="login-image">

            <!-- Subtítulo informativo -->
            <h2 class="login-subtitle">

                Ingresa tus datos

            </h2>

            <!-- Formulario que envía los datos al LoginServlet -->
            <form action="LoginServlet" method="POST" class="formulario" id="form-login">

                <!-- Contenedor para mostrar mensajes de error -->
                <div id="mensaje-error" class="mensaje-error">
                </div>

                <!-- Campo para ingresar el correo electrónico -->
                <div class="form-campo">

                    <input type="email" id="correo" name="correo" placeholder="Correo electrónico">

                </div>

                <!-- Campo para ingresar la contraseña -->
                <div class="form-campo">

                    <input type="password" id="password" name="password" placeholder="Contraseña">

                </div>

                <!-- Botón para enviar el formulario -->
                <button type="submit" class="btn-ingresar">

                    Ingresar

                </button>

            </form>

            <!-- Enlace para dirigir al usuario al registro -->
            <p class="texto-registro">

                ¿No tienes cuenta?

                <a href="registro.jsp">

                    Regístrate aquí

                </a>

            </p>

        </section>

    </main>

    <!-- Pie de página -->
    <footer class="footer">

        <!-- Logo del software -->
        <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

        <p>
            © 2026 eParking
        </p>

    </footer>

    <!-- Archivo JavaScript encargado de las validaciones y funcionalidades del login -->
    <script src="js/login.js"></script>

</body>

</html>