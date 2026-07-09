<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <!-- Configuración de codificación de caracteres -->
    <meta charset="UTF-8">

    <!-- Permite una correcta visualización en dispositivos móviles -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <!-- Título mostrado en la pestaña del navegador -->
    <title>Pagos | E-Parking</title>

    <!-- Hoja de estilos de la página de pagos -->
    <link rel="stylesheet"
          href="css/pagos.css">

</head>

<body>

    <!-- Encabezado principal -->
    <header class="header">

        <!-- Logo institucional del sistema -->
        <div class="logo">

            <img src="img/logo-eparking.jpeg"
                 alt="logo"
                 width="110"
                 height="32">

        </div>

    </header>

    <!-- Contenido principal -->
    <main class="container-pagos">

        <!-- Sección de título y descripción -->
        <div class="titulo-container">

            <h1 class="titulo">

                💳 Pagos

            </h1>

            <p class="subtitulo">

                Finaliza tu reserva

            </p>

        </div>

        <!-- Botón para regresar al menú principal -->
        <div class="contenedor-volver">

            <a href="menu-principal.jsp"
               class="btn-volver">

                ← Volver al Menú

            </a>

        </div>

        <!-- Resumen de la reserva seleccionada -->
        <div class="resumen-pago">

            <h2>

                📋 Resumen de Reserva

            </h2>

            <div class="detalle">

                <!-- Información del vehículo -->
                <p>

                    <strong>Vehículo:</strong>
                    ABC123

                </p>

                <!-- Cupo asignado -->
                <p>

                    <strong>Cupo:</strong>
                    A-01

                </p>

                <!-- Fecha de la reserva -->
                <p>

                    <strong>Fecha:</strong>
                    12/05/2026

                </p>

                <!-- Hora de la reserva -->
                <p>

                    <strong>Hora:</strong>
                    3:00 PM

                </p>

                <!-- Valor total a pagar -->
                <p class="total">

                    Total: $10.000

                </p>

            </div>

        </div>

        <!-- Sección para seleccionar el método de pago -->
        <div class="metodos-pago">

            <h2>

                Selecciona Método de Pago

            </h2>

            <div class="metodos-grid">

                <!-- Opción de pago con tarjeta -->
                <div class="metodo">

                    💳 Tarjeta

                </div>

                <!-- Opción de pago con Nequi -->
                <div class="metodo">

                    📱 Nequi

                </div>

                <!-- Opción de pago con Daviplata -->
                <div class="metodo">

                    🏦 Daviplata

                </div>

                <!-- Opción de pago en efectivo -->
                <div class="metodo">

                    💵 Efectivo

                </div>

            </div>

        </div>

        <!-- Botón para confirmar el pago -->
        <button id="btnPagar"
                class="btn-pagar">

            Pagar Ahora

        </button>

        <!-- Contenedor donde se mostrarán mensajes de confirmación o error -->
        <div id="mensajePago"></div>

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

    <!-- Archivo JavaScript encargado de la lógica de pagos -->
    <script src="js/pagos.js"></script>

</body>

</html>