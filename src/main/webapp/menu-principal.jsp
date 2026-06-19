<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>menu-principal</title>

    <link rel="stylesheet" href="css/menu-principal.css">
</head>
<body>

<!-- HEADER -->
<header> 
    <div class="logo">
        <img src="img/logo-eparking.jpeg"
        alt="logo oficial-eparking" width="110" height="32">
    </div>
</header>

<!-- MAIN -->
<main>

    <section id="menu-principal" class="container-menu-principal">

        <!-- TITULO BONITO -->
        <div class="titulo-container">

            <h1 class="menu-principal">
                🚗 Menu Principal
            </h1>

        </div>

        <nav class="menu-principal">

            <button class="btn-menu" id="btn-vehiculo"
                onclick="window.location.href='vehiculos.jsp'">

                <img src="img/icono-vehiculos.jpeg"
                alt="icono de pantalla vehiculos"
                width="30" height="30">

                <span>Vehículos</span>

            </button>

            <button class="btn-menu" id="btn-ver-disponibilidad"
                onclick="window.location.href='disponibilidad.jsp'">

                <img src="img/icono-ver-disponibilidad.png"
                alt="icono de pantalla disponibilidad"
                width="30" height="30">

                <span>Disponibilidad</span>

            </button>

            <button class="btn-menu" id="btn-reservas"
                onclick="window.location.href='reservas.jsp'">

                <img src="img/icono-reservas.png"
                alt="icono de pantalla reservas"
                width="30" height="30">

                <span>Reservas</span>

            </button>

            <button class="btn-menu" id="btn-historial"
                onclick="window.location.href='historial.jsp'">

                <img src="img/icono-historial.jpeg"
                alt="icono de pantalla historial"
                width="30" height="30">

                <span>Historial</span>

            </button> 

            <button class="btn-menu" id="btn-pagos-digitales"
                onclick="window.location.href='pagos.jsp'">

                <img src="img/icono-pagos-digitales.jpeg"
                alt="icono de pantalla pagos-digitales"
                width="30" height="30">

                <span>Pagos digitales</span>

            </button>

            <button class="btn-menu" id="btn-registro"
                onclick="window.location.href='registro.jsp'">

                <img src="img/icono-registro.png"
                alt="icono de pantalla registro"
                width="30" height="30"> 

                <span>Registro</span>

            </button>

        </nav>

    </section>

</main>

<!-- FOOTER -->
<footer class="app-footer">

    <img src="img/Logo-software.jpeg" alt="Logo software" width="50" height="45">

            <p>
                © 2026 eParking
            </p>
</footer>

<script src="js/menu-principal.js"></script>

</body>
</html>