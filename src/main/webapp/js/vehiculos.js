// MENSAJE

console.log("Pantalla Vehículos cargada correctamente");


// BUSCAR VEHICULO

document.getElementById("btnBuscar")
.addEventListener("click", function(){

    let filtro =
    document.getElementById("inputBuscar")
    .value.toLowerCase();

    let filas =
    document.querySelectorAll("tbody tr");

    let resultado =
    document.getElementById("resultadoBusqueda");

    resultado.innerHTML = "";

    let encontrado = false;

    filas.forEach(function(fila){

        let placa =
        fila.cells[0].textContent.toLowerCase();

        if(placa.includes(filtro)){

            encontrado = true;

            let tipo = fila.cells[1].textContent;
            let color = fila.cells[2].textContent;
            let propietario = fila.cells[3].textContent;

            let tarjeta = document.createElement("div");

            tarjeta.classList.add("resultado-card");

            tarjeta.innerHTML = `

                <h4>🚗 ${placa.toUpperCase()}</h4>

                <p><strong>Tipo:</strong> ${tipo}</p>

                <p><strong>Color:</strong> ${color}</p>

                <p><strong>Propietario:</strong> ${propietario}</p>

            `;

            // CLICK TARJETA

            tarjeta.addEventListener("click", function(){

                fila.scrollIntoView({

                    behavior: "smooth",

                    block: "center"

                });

                fila.style.backgroundColor = "#bfdbfe";

                setTimeout(() => {

                    fila.style.backgroundColor = "";

                }, 2000);

            });

            resultado.appendChild(tarjeta);

        }

    });

    if(!encontrado){

        resultado.innerHTML = `

            <div class="resultado-card">

                <h4>❌ Vehículo no encontrado</h4>

            </div>

        `;
    }

});


// EXPORTAR PDF

document.getElementById("btnExportar")
.addEventListener("click", function(){

    window.print();

});