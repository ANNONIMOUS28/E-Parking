document.addEventListener("DOMContentLoaded", function () {
    const formulario = document.getElementById("formulario-login");
    const alertaError = document.getElementById("alerta-error");
    const alertaExito = document.getElementById("alerta-exito");

    const registroExitoso = localStorage.getItem("registroExitoso");
    if (registroExitoso) {
        alertaExito.textContent = registroExitoso;
        alertaExito.style.display = "block";
        localStorage.removeItem("registroExitoso");
    }

    const sesionRequerida = localStorage.getItem("sesionRequerida");
    if (sesionRequerida) {
        alertaError.textContent = sesionRequerida;
        alertaError.style.display = "block";
        localStorage.removeItem("sesionRequerida");
    }

    formulario.addEventListener("submit", function (evento) {
        evento.preventDefault();
        alertaError.style.display = "none";
        alertaExito.style.display = "none";

        const usuario = document.getElementById("usuario").value.trim();
        const password = document.getElementById("password").value;

        if (usuario === "admin@eparking.com" && password === "12345") {
            localStorage.setItem("usuarioLogueado", "admin");
            alertaExito.textContent = "¡Inicio de sesión correcto (Administrador)! Redirigiendo...";
            alertaExito.style.display = "block";
            setTimeout(() => {
                window.location.href = "disponibilidad.jsp";
            }, 1000);
            return;
        }

        const usuariosLocales = JSON.parse(localStorage.getItem("usuarios")) || [];
        const usuarioEncontrado = usuariosLocales.find(u =>
            (u.correo.toLowerCase() === usuario.toLowerCase() || u.nombre.toLowerCase() === usuario.toLowerCase())
            && u.password === password
        );

        if (usuarioEncontrado) {
            localStorage.setItem("usuarioLogueado", usuarioEncontrado.nombre);
            alertaExito.textContent = "¡Inicio de sesión correcto! Redirigiendo...";
            alertaExito.style.display = "block";
            setTimeout(() => {
                window.location.href = "disponibilidad.jsp";
            }, 1000);
            return;
        }

        alertaError.textContent = "Usuario o contraseña incorrectos.";
        alertaError.style.display = "block";
    });
});
