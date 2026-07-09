<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <!-- Configuración de codificación de caracteres -->
    <meta charset="UTF-8">

    <!-- Permite una correcta visualización en dispositivos móviles -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Título mostrado en la pestaña del navegador -->
    <title>eParking - Registro</title>

    <!-- Hoja de estilos de la página de registro -->
    <link rel="stylesheet" href="css/registro.css">

</head>

<body>

    <!-- Encabezado principal -->
    <header class="header">

        <!-- Logo institucional -->
        <div class="logo">

            <img src="img/logo-eparking.jpeg" alt="Logo eParking" width="110" height="32">

        </div>

        <!-- Menú de navegación -->
        <nav>

            <!-- Botón para dirigirse al inicio de sesión -->
            <button type="button" class="btn-login" onclick="window.location.href='login.jsp'">

                Login

            </button>

        </nav>

    </header>

    <!-- Contenido principal -->
    <main>

        <!-- Contenedor del formulario de registro -->
        <section class="container-registro">

            <!-- Título principal -->
            <h1 class="registro-title">
                Registro de Usuario
            </h1>

            <!-- Imagen representativa del registro -->
            <img src="img/icono-registro.png" alt="Icono Registro" class="registro-image">

            <!-- Subtítulo informativo -->
            <h2 class="registro-subtitle">
                Completa tus datos
            </h2>

            <!-- Sección de mensajes dinámicos -->
            <% String msg = request.getParameter("msg"); %>

            <!-- Mensaje mostrado cuando el registro es exitoso -->
            <% if ("ok".equals(msg)) { %>
                <div class="mensaje-exito">✅ Registro exitoso</div>
            <% } %>

            <!-- Mensaje mostrado cuando ocurre un error en el registro -->
            <% if ("error".equals(msg)) { %>
                <div class="mensaje-error">❌ Error en registro</div>
            <% } %>

            <!-- Formulario de registro de usuario -->
            <form id="formulario-registro"
                  class="formulario"
                  action="RegistroServlet"
                  method="POST">

                <!-- Campo para ingresar el nombre completo -->
                <div class="form-campo">

                    <input type="text"
                           id="nombre"
                           name="nombre"
                           placeholder="Nombre completo">

                </div>

                <!-- Campo para ingresar la identificación -->
                <div class="form-campo">

                    <input type="text"
                           id="identificacion"
                           name="identificacion"
                           placeholder="Identificación">

                </div>

                <!-- Campo para ingresar el teléfono -->
                <div class="form-campo">

                    <input type="text"
                           id="telefono"
                           name="telefono"
                           placeholder="Teléfono">

                </div>

                <!-- Campo para ingresar el correo electrónico -->
                <div class="form-campo">

                    <input type="email"
                           id="correo"
                           name="correo"
                           placeholder="Correo electrónico">

                </div>

                <!-- Campo para ingresar la contraseña -->
                <div class="form-campo">

                    <input type="password"
                           id="password"
                           name="password"
                           placeholder="Contraseña">

                </div>

                <!-- Campo para confirmar la contraseña -->
                <div class="form-campo">

                    <input type="password"
                           id="confirmar-password"
                           name="confirmarPassword"
                           placeholder="Confirmar contraseña">

                </div>

                <!-- Botón para enviar el formulario -->
                <button type="submit"
                        class="btn-registrar"
                        id="btn-registrar">

                    Registrarse

                </button>

            </form>

            <!-- Enlace para usuarios que ya tienen cuenta -->
            <p class="texto-login">

                ¿Ya tienes cuenta?

                <a href="login.jsp">
                    Inicia sesión
                </a>

            </p>

        </section>

    </main>

    <!-- Pie de página -->
    <footer class="footer">

        <!-- Logo representativo del proyecto -->
        <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

        <!-- Información de derechos de autor -->
        <p>
            © 2026 eParking
        </p>

    </footer>

    <!-- Archivo JavaScript encargado de las validaciones del formulario -->
    <script src="js/registro.js"></script>

</body>

</html>