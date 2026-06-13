const formulario =
document.getElementById('form-login');

const mensajeError =
document.getElementById('mensaje-error');

formulario.addEventListener('submit', function (evento) {

    mensajeError.innerHTML = "";

   const correo =
document.getElementById('correo').value.trim();

    const password =
    document.getElementById('password').value.trim();

    if (correo === "" || password === "") {

        evento.preventDefault();

        mensajeError.innerHTML =
        "⚠ Debes completar todos los campos";
    }
});