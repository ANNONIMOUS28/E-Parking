<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="es">

    <head>

        <meta charset="UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>eParking - Reservas</title>

        <link rel="stylesheet" href="css/reservas.css">

        <script>
            if (!localStorage.getItem('usuarioLogueado')) {
                localStorage.setItem('sesionRequerida', 'Por favor, inicia sesión para acceder.');
                window.location.href = 'login.jsp';
            }
        </script>

    </head>

    <body>

        <!-- HEADER -->

        <header class="header">

            <div class="logo">

                <img src="img/logo-eparking.jpeg" alt="Logo eParking" width="110" height="32">

            </div>

            <nav>

                <button type="button" class="btn-volver" id="btn-volver">

                    Volver

                </button>

            </nav>

        </header>

        <!-- MAIN -->

        <main>

            <div class="reservas-layout">

                <section class="container-reservas">

                    <h1 class="reservas-title">

                        Reservar Cupo

                    </h1>

                    <img src="img/icono-ver-disponibilidad.png" alt="Reservas" class="reservas-image">

                    <h2 class="reservas-subtitle">

                        Completa la información

                    </h2>

                    <div id="alerta-error" class="alerta alerta-error" style="display: none;"></div>
                    <div id="alerta-exito" class="alerta alerta-exito" style="display: none;"></div>

                    <!-- FORMULARIO -->

                    <form id="formulario-reserva" class="formulario">

                        <!-- NOMBRE -->

                        <div class="form-campo">

                            <input type="text" id="nombre" placeholder="Nombre completo" required pattern="^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\s]+$" title="El nombre completo solo debe contener letras y espacios.">

                        </div>

                        <!-- PLACA -->

                        <div class="form-campo">

                            <input type="text" id="placa" placeholder="Placa del vehículo" required pattern="^[a-zA-Z]{3}[0-9]{2}[0-9a-zA-Z]$" title="Formato requerido: 3 letras y 3 números (carros) o 3 letras, 2 números y 1 letra (motos). Ejemplo: ABC123 o ABC12A">

                        </div>

                        <!-- FECHA -->

                        <div class="form-campo">

                            <input type="date" id="fecha" required>

                        </div>

                        <!-- HORA -->

                        <div class="form-campo">

                            <input type="time" id="hora" required>

                        </div>

                        <!-- BOTON -->

                        <button type="submit" class="btn-reservar" id="btn-reservar">

                            Reservar

                        </button>

                    </form>

                </section>

                <section class="container-listado">

                    <h2 class="listado-title">Reservas Activas</h2>

                    <div class="tabla-contenedor">

                        <table class="tabla-reservas">

                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Placa</th>
                                    <th>Fecha</th>
                                    <th>Hora</th>
                                </tr>
                            </thead>

                            <tbody id="tabla-reservas-body">
                                <!-- Se llena dinámicamente con JS -->
                            </tbody>

                        </table>

                    </div>

                </section>

            </div>

        </main>

        <!-- FOOTER -->

        <footer class="footer">

            <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

            <p>
                © 2026 eParking
            </p>

        </footer>

        <script src="js/reservas.js"></script>

    </body>

    </html>