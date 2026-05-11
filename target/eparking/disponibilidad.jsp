<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>eParking - Disponibilidad</title>

    <link rel="stylesheet"
          href="css/disponibilidad.css">

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
                    class="btn-reservas"
                    id="btn-reservas">

                Reservas

            </button>

        </nav>

    </header>

    <!-- MAIN -->

    <main>

        <section class="container-disponibilidad">

            <h1 class="disponibilidad-title">

                Disponibilidad

            </h1>

            <img src="img/icono-ver-disponibilidad.png"
                 alt="Disponibilidad"
                 class="disponibilidad-image">

            <!-- ESTADO -->

            <div id="estado-circulo"
                 class="circulo-verde">

            </div>

            <p class="texto-cupos">

                Cupos disponibles:

                <span id="numero-cupos">

                    30

                </span>

            </p>

            <!-- BOTONES -->

            <div class="contenedor-botones">

                <button type="button"
                        class="btn-actualizar"
                        id="btn-actualizar">

                    Actualizar

                </button>

                <button type="button"
                        class="btn-volver"
                        id="btn-volver">

                    Volver

                </button>

            </div>

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

    <script src="js/disponibilidad.js"></script>

</body>

</html>
