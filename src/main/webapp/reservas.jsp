<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>eParking - Reservas</title>

    <link rel="stylesheet"
          href="reservas.css">

</head>

<body>

    <!-- HEADER -->

    <header class="header">

        <div class="logo">

            <img src="img/logo-eparking.jpeg"
                 alt="Logo eParking"
                 width="110"
                 height="32">

        </div>

        <nav>

            <button type="button"
                    class="btn-volver"
                    id="btn-volver">

                Volver

            </button>

        </nav>

    </header>

    <!-- MAIN -->

    <main>

        <section class="container-reservas">

            <h1 class="reservas-title">

                Reservar Cupo

            </h1>

            <img src="img/icono-reservas.png"
                 alt="Reservas"
                 class="reservas-image">

            <h2 class="reservas-subtitle">

                Completa la información

            </h2>

            <!-- FORMULARIO -->

            <form id="formulario-reserva"
                  class="formulario">

                <!-- NOMBRE -->

                <div class="form-campo">

                    <input type="text"
                           id="nombre"
                           placeholder="Nombre completo"
                           required>

                </div>

                <!-- PLACA -->

                <div class="form-campo">

                    <input type="text"
                           id="placa"
                           placeholder="Placa del vehículo"
                           required>

                </div>

                <!-- FECHA -->

                <div class="form-campo">

                    <input type="date"
                           id="fecha"
                           required>

                </div>

                <!-- HORA -->

                <div class="form-campo">

                    <input type="time"
                           id="hora"
                           required>

                </div>

                <!-- BOTON -->

                <button type="submit"
                        class="btn-reservar"
                        id="btn-reservar">

                    Reservar

                </button>

            </form>

        </section>

    </main>

    <!-- FOOTER -->

    <footer class="footer">

        <img src="img/Logo-software.jpeg"
             alt="Logo software"
             width="50"
             height="45">

        <p>
            © 2026 eParking
        </p>

    </footer>

    <script src="reservas.js"></script>

</body>

</html>