<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Pagos | E-Parking</title>

    <link rel="stylesheet"
          href="css/pagos.css">

</head>

<body>

    <!-- HEADER -->

    <header class="header">

        <div class="logo">

            <img src="img/logo-eparking.jpeg"
                 alt="logo"
                 width="110"
                 height="32">

        </div>

    </header>

    <!-- MAIN -->

    <main class="container-pagos">

        <!-- TITULO -->

        <div class="titulo-container">

            <h1 class="titulo">

                💳 Pagos

            </h1>

            <p class="subtitulo">

                Finaliza tu reserva

            </p>

        </div>

        <!-- VOLVER -->

        <div class="contenedor-volver">

            <a href="menu-principal.jsp"
               class="btn-volver">

                ← Volver al Menú

            </a>

        </div>

        <!-- RESUMEN -->

        <div class="resumen-pago">

            <h2>

                📋 Resumen de Reserva

            </h2>

            <div class="detalle">

                <p>

                    <strong>Vehículo:</strong>
                    ABC123

                </p>

                <p>

                    <strong>Cupo:</strong>
                    A-01

                </p>

                <p>

                    <strong>Fecha:</strong>
                    12/05/2026

                </p>

                <p>

                    <strong>Hora:</strong>
                    3:00 PM

                </p>

                <p class="total">

                    Total: $10.000

                </p>

            </div>

        </div>

        <!-- METODOS -->

        <div class="metodos-pago">

            <h2>

                Selecciona Método de Pago

            </h2>

            <div class="metodos-grid">

                <div class="metodo">

                    💳 Tarjeta

                </div>

                <div class="metodo">

                    📱 Nequi

                </div>

                <div class="metodo">

                    🏦 Daviplata

                </div>

                <div class="metodo">

                    💵 Efectivo

                </div>

            </div>

        </div>

        <!-- BOTON PAGAR -->

        <button id="btnPagar"
                class="btn-pagar">

            Pagar Ahora

        </button>

        <!-- MENSAJE -->

        <div id="mensajePago"></div>

    </main>

    <!-- FOOTER -->

    <footer class="app-footer">

        <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

            <p>
                © 2026 eParking
            </p>


    </footer>

    <script src="js/pagos.js"></script>

</body>

</html>