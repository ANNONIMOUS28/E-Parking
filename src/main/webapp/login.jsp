<%@ page contentType="text/html" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="es">

    <head>

        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>eParking - Login</title>

        <link rel="stylesheet" href="css/login.css">

    </head>

    <body>


        <header class="header">

            <div class="logo">

                <img src="img/logo-eparking.jpeg" alt="Logo eParking" width="110" height="32">

            </div>

            <nav>

                <button type="button" class="btn-volver" onclick="window.location.href='index.jsp'">

                    Inicio

                </button>

            </nav>

        </header>


        <main>

            <section class="container-login">

                <h1 class="login-title">

                    Inicio de Sesión

                </h1>

                <img src="img/icono-inicio-sesion.png" alt="Icono Login" class="login-image">

                <h2 class="login-subtitle">

                    Ingresa tus datos

                </h2>

                <div id="alerta-error" class="alerta alerta-error" style="display: none;"></div>
                <div id="alerta-exito" class="alerta alerta-exito" style="display: none;"></div>

                <form id="formulario-login" class="formulario">

                    <div class="form-campo">

                        <input type="email" id="usuario" name="usuario" placeholder="Correo" required>

                    </div>

                    <div class="form-campo">

                        <input type="password" id="password" name="password" placeholder="Contraseña" required>

                    </div>

                    <button type="submit" class="btn-ingresar">

                        Ingresar

                    </button>

                </form>

                <p class="texto-registro">

                    ¿No tienes cuenta?

                    <a href="registro.jsp">

                        Regístrate aquí

                    </a>

                </p>

            </section>

        </main>

        <footer class="footer">

            <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

            <p>
                © 2026 eParking
            </p>

        </footer>

        <script src="js/login.js"></script>

    </body>

    </html>