const btnReservas =
document.getElementById('btn-reservas');

const btnActualizar =
document.getElementById('btn-actualizar');

const btnVolver =
document.getElementById('btn-volver');

const estadoCirculo =
document.getElementById('estado-circulo');

const numeroCupos =
document.getElementById('numero-cupos');

/* IR A RESERVAS */

btnReservas.addEventListener('click', function () {

    window.location.href = 'reservas.jsp';

});

/* VOLVER LOGIN */

btnVolver.addEventListener('click', function () {

    window.location.href = 'login.jsp';

});

/* ACTUALIZAR DISPONIBILIDAD */

btnActualizar.addEventListener('click', function () {

    let cupos =
    Math.floor(Math.random() * 31);

    numeroCupos.textContent = cupos;

    /* CAMBIO DE COLOR */

    if (cupos > 15) {

        estadoCirculo.className =
        'circulo-verde';

    }

    else if (cupos > 5) {

        estadoCirculo.className =
        'circulo-amarillo';

    }

    else {

        estadoCirculo.className =
        'circulo-rojo';
    }

});



 



