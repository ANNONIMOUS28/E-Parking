<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>eParking - Inicio</title>

    <link rel="stylesheet"
          href="css/index.css">

</head>

<body>

    <!-- HEADER -->

    <header class="header">

        <div class="logo">

            <img src="img/logo-eparking.jpeg"
                 alt="Logo eParking"
                 width="120">

        </div>

        <nav>

            <button class="btn-login"
                    onclick="window.location.href='login.jsp'">

                Login

            </button>

        </nav>

    </header>

    <!-- MAIN -->

    <main class="main">

        <section class="hero">

            <h1>
                Bienvenido a eParking
            </h1>

            <p>
                Sistema para gestión
                de parqueaderos y reservas. 
                ¡Reserva tu cupo de parqueadero de forma fácil y rápida!
            </p>

            <img src="img/icono-parqueadero.png"
                 alt="Parqueadero"
                 class="hero-image">

            <div class="contenedor-botones">

                <button class="btn-principal"
                        onclick="window.location.href='login.jsp'">

                    Iniciar Sesión

                </button>

                <button class="btn-secundario"
                        onclick="window.location.href='registro.jsp'">

                    Registrarse

                </button>

            </div>

        </section>

    </main>

    <!-- FOOTER -->

    <footer class="footer">

        <img src="img/Logo-software.jpeg"
             alt="Logo"
             width="50">

        <p>
            © 2026 eParking
        </p>

    </footer>

</body>

</html>