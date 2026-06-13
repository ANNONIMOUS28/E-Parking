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
                    Registro de Usuario
                </h1>

                <img src="img/icono-registro.png" alt="Icono Registro" class="registro-image">

                <h2 class="registro-subtitle">
                    Completa tus datos
                </h2>

                <!-- MENSAJES -->
                 
                <% String msg=request.getParameter("msg"); %>

                    <% if ("ok".equals(msg)) { %>
                        <div class="mensaje-exito">✅ Registro exitoso</div>
                        <% } %>

                            <% if ("error".equals(msg)) { %>
                                <div class="mensaje-error">❌ Error en registro</div>
                                <% } %>
                                    <!-- FORMULARIO -->

                                    <form id="formulario-registro" class="formulario" action="RegistroServlet"
                                        method="POST">

                                        <!-- NOMBRE -->

                                        <div class="form-campo">

                                            <input type="text" id="nombre" name="nombre" placeholder="Nombre completo">

                                        </div>

                                        <!-- IDENTIFICACION -->

                                        <div class="form-campo">

                                            <input type="text" id="identificacion" name="identificacion"
                                                placeholder="Identificación">

                                        </div>

                                        <!-- TELEFONO -->

                                        <div class="form-campo">

                                            <input type="text" id="telefono" name="telefono" placeholder="Teléfono">

                                        </div>

                                        <!-- CORREO -->

                                        <div class="form-campo">

                                            <input type="email" id="correo" name="correo"
                                                placeholder="Correo electrónico">

                                        </div>

                                        <!-- PASSWORD -->

                                        <div class="form-campo">

                                            <input type="password" id="password" name="password"
                                                placeholder="Contraseña">

                                        </div>

                                        <!-- CONFIRMAR PASSWORD -->

                                        <div class="form-campo">

                                            <input type="password" id="confirmar-password" name="confirmarPassword"
                                                placeholder="Confirmar contraseña">

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