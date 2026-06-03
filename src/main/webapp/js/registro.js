document.addEventListener("DOMContentLoaded", function () {
    const formulario = document.getElementById("formulario-registro");
    const alertaError = document.getElementById("alerta-error");
    const alertaExito = document.getElementById("alerta-exito");

    formulario.addEventListener("submit", function (evento) {
        evento.preventDefault();
        alertaError.style.display = "none";
        alertaExito.style.display = "none";

        const nombre = document.getElementById("nombre").value.trim();
        const identificacion = document.getElementById("identificacion").value.trim();
        const telefono = document.getElementById("telefono").value.trim();
        const correo = document.getElementById("correo").value.trim();
        const password = document.getElementById("password").value;
        const confirmarPassword = document.getElementById("confirmar-password").value;

        if (password !== confirmarPassword) {
            alertaError.textContent = "Las contraseñas no coinciden.";
            alertaError.style.display = "block";
            return;
        }

        const usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];
        usuarios.push({
            nombre: nombre,
            identificacion: identificacion,
            telefono: telefono,
            correo: correo,
            password: password
        });

        localStorage.setItem("usuarios", JSON.stringify(usuarios));

        localStorage.setItem("registroExitoso", "¡Registro exitoso! Por favor, inicia sesión con tus datos.");

        alertaExito.textContent = "¡Registro completado con éxito! Redirigiendo...";
        alertaExito.style.display = "block";

        setTimeout(function () {
            window.location.href = "login.jsp";
        }, 1000);
    });
});
