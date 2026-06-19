const formulario = document.getElementById('formulario-registro');

formulario.addEventListener('submit', function (evento) {

    const nombre = document.getElementById('nombre').value.trim();
    const identificacion = document.getElementById('identificacion').value.trim();
    const telefono = document.getElementById('telefono').value.trim();
    const correo = document.getElementById('correo').value.trim();
    const password = document.getElementById('password').value.trim();
    const confirmarPassword = document.getElementById('confirmar-password').value.trim();

    if (!nombre || !identificacion || !telefono || !correo || !password || !confirmarPassword) {
        evento.preventDefault();
        alert("Completa todos los campos");
        return;
    }

    if (password !== confirmarPassword) {
        evento.preventDefault();
        alert("Las contraseñas no coinciden");
        return;
    }

});