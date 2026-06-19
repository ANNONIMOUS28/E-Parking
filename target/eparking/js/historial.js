// MENSAJE

console.log("Historial cargado correctamente");


// BUSCAR EN HISTORIAL

document.getElementById("btnBuscar")
    .addEventListener("click", function () {

        let filtro =
            document.getElementById("inputBuscar")
                .value.toLowerCase();

        let filas =
            document.querySelectorAll("#tablaHistorial tr");

        filas.forEach(function (fila) {

            let placa =
                fila.cells[1].textContent.toLowerCase();

            if (placa.includes(filtro)) {

                fila.style.display = "";

            } else {

                fila.style.display = "none";
            }

        });

    });