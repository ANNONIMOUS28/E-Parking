document.addEventListener("DOMContentLoaded", function () {
    const btnReservas = document.getElementById('btn-reservas');
    const btnActualizar = document.getElementById('btn-actualizar');
    const btnVolver = document.getElementById('btn-volver');
    const estadoCirculo = document.getElementById('estado-circulo');
    const numeroCupos = document.getElementById('numero-cupos');

    function actualizarCupos() {
        const reservas = JSON.parse(localStorage.getItem('reservas')) || [];
        const totalCupos = 30;
        const cupos = Math.max(0, totalCupos - reservas.length);

        numeroCupos.textContent = cupos;

        if (cupos > 15) {
            estadoCirculo.className = 'circulo-verde';
        } else if (cupos > 5) {
            estadoCirculo.className = 'circulo-amarillo';
        } else {
            estadoCirculo.className = 'circulo-rojo';
        }
    }

    actualizarCupos();

    btnReservas.addEventListener('click', function () {
        window.location.href = 'reservas.jsp';
    });

    btnVolver.addEventListener('click', function () {
        localStorage.removeItem('usuarioLogueado');
        window.location.href = 'login.jsp';
    });

    btnActualizar.addEventListener('click', function () {
        actualizarCupos();
    });
});
