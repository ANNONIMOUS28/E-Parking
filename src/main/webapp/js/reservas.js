document.addEventListener("DOMContentLoaded", function () {
    const btnVolver = document.getElementById('btn-volver');
    const formularioReserva = document.getElementById('formulario-reserva');
    const alertaError = document.getElementById('alerta-error');
    const alertaExito = document.getElementById('alerta-exito');
    const tablaReservasBody = document.getElementById('tabla-reservas-body');

    function renderizarTabla() {
        const reservas = JSON.parse(localStorage.getItem('reservas')) || [];
        tablaReservasBody.innerHTML = '';

        if (reservas.length === 0) {
            const fila = document.createElement('tr');
            fila.innerHTML = '<td colspan="4" style="text-align: center; color: #64748b;">No hay reservas activas.</td>';
            tablaReservasBody.appendChild(fila);
            return;
        }

        for (let i = 0; i < reservas.length; i++) {
            const r = reservas[i];
            const fila = document.createElement('tr');
            fila.innerHTML = '<td>' + r.nombre + '</td>' +
                             '<td>' + r.placa + '</td>' +
                             '<td>' + r.fecha + '</td>' +
                             '<td>' + r.hora + '</td>';
            tablaReservasBody.appendChild(fila);
        }
    }

    renderizarTabla();

    btnVolver.addEventListener('click', function () {
        window.location.href = 'disponibilidad.jsp';
    });

    formularioReserva.addEventListener('submit', function (evento) {
        evento.preventDefault();
        
        alertaError.style.display = 'none';
        alertaExito.style.display = 'none';

        const nombre = document.getElementById('nombre').value.trim();
        const placa = document.getElementById('placa').value.trim().toUpperCase();
        const fecha = document.getElementById('fecha').value;
        const hora = document.getElementById('hora').value;

        if (nombre === '' || placa === '' || fecha === '' || hora === '') {
            alertaError.textContent = 'Por favor, completa todos los campos.';
            alertaError.style.display = 'block';
            return;
        }

        const reservas = JSON.parse(localStorage.getItem('reservas')) || [];

        reservas.push({
            nombre: nombre,
            placa: placa,
            fecha: fecha,
            hora: hora
        });

        localStorage.setItem('reservas', JSON.stringify(reservas));

        alertaExito.textContent = '¡Reserva registrada con éxito!';
        alertaExito.style.display = 'block';

        formularioReserva.reset();
        renderizarTabla();
    });
});