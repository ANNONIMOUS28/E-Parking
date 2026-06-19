// MENSAJE

console.log("Pagos cargado");


// METODO SELECCIONADO

const metodos =
document.querySelectorAll(".metodo");

let metodoSeleccionado = "";

metodos.forEach(function(metodo){

    metodo.addEventListener("click", function(){

        metodos.forEach(function(m){

            m.style.border =
            "2px solid #bfdbfe";

        });

        metodo.style.border =
        "3px solid #16a34a";

        metodoSeleccionado =
        metodo.textContent.trim();

    });

});


// PAGAR

document.getElementById("btnPagar")
.addEventListener("click", function(){

    const mensaje =
    document.getElementById("mensajePago");

    if(metodoSeleccionado === ""){

        alert("Selecciona un método de pago");

        return;
    }

    mensaje.innerHTML = `

        <div class="alerta-exito">

            ✅ Pago realizado correctamente
            con ${metodoSeleccionado}

        </div>

    `;

});