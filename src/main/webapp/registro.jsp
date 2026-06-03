<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="es">

    <head>

        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>eParking - Registro</title>

        <link rel="stylesheet" href="css/registro.css">

    </head>

    <body>

        <!-- HEADER -->

        <header class="header">

            <div class="logo">

                <img src="img/logo-eparking.jpeg" alt="Logo eParking" width="110" height="32">

            </div>

            <nav>

                <button type="button" class="btn-login" onclick="window.location.href='login.jsp'">

                    Login

                </button>

            </nav>

        </header>

        <!-- MAIN -->

        <main>

            <section class="container-registro">

                <h1 class="registro-title">
                    Registro de Usuario.
                </h1>

                <img src="img/icono-registro.png" alt="Icono Registro" class="registro-image">

                <h2 class="registro-subtitle">
                    Completa tus datos
                </h2>

                <div id="alerta-error" class="alerta alerta-error" style="display: none;"></div>
                <div id="alerta-exito" class="alerta alerta-exito" style="display: none;"></div>

                <!-- FORMULARIO -->

                <form id="formulario-registro" class="formulario">

                    <!-- NOMBRE -->

                    <div class="form-campo">

                        <input type="text" id="nombre" placeholder="Nombre completo" required>

                    </div>

                    <!-- IDENTIFICACION -->

                    <div class="form-campo">

                        <input type="number" id="identificacion" placeholder="Identificación" required>

                    </div>

                    <!-- TELEFONO -->

                    <div class="form-campo">

                        <input type="number" id="telefono" placeholder="Teléfono" required>

                    </div>

                    <!-- CORREO -->

                    <div class="form-campo">

                        <input type="email" id="correo" placeholder="Correo electrónico" required>

                    </div>

                    <!-- PASSWORD -->

                    <div class="form-campo">

                        <input type="password" id="password" placeholder="Contraseña" required>

                    </div>

                    <!-- CONFIRMAR PASSWORD -->

                    <div class="form-campo">

                        <input type="password" id="confirmar-password" placeholder="Confirmar contraseña" required>

                    </div>

                    <!-- BOTON -->

                    <button type="submit" class="btn-registrar" id="btn-registrar">

                        Registrarse

                    </button>

                </form>

                <p class="texto-login">

                    ¿Ya tienes cuenta?

                    <a href="login.jsp">
                        Inicia sesión
                    </a>

                </p>

            </section>

        </main>

        <!-- FOOTER -->

        <footer class="footer">

            <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

            <p>
                © 2026 eParking
            </p>

        </footer>

        <script src="js/registro.js"></script>

    </body>

    </html>