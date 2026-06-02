const btnVolver =
document.getElementById('btn-volver');

const formularioReserva =
document.getElementById('formulario-reserva');

/* VOLVER */

btnVolver.addEventListener('click', function () {

    window.location.href =
    'disponibilidad.jsp';

});

/* RESERVA */

formularioReserva.addEventListener('submit', function (evento) {

    evento.preventDefault();

    const nombre =
    document.getElementById('nombre').value;

    const placa =
    document.getElementById('placa').value;

    const fecha =
    document.getElementById('fecha').value;

    const hora =
    document.getElementById('hora').value;

    /* VALIDACIONES */

    if (
        nombre === '' ||
        placa === '' ||
        fecha === '' ||
        hora === ''
    ) {

        alert('Completa todos los campos');

        return;
    }

    /* RESERVA EXITOSA */

    alert('Reserva realizada exitosamente');

    formularioReserva.reset();

});