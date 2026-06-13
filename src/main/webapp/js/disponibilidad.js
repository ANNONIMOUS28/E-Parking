// MENSAJE

console.log("Disponibilidad cargada");


// FILTROS

const botones =
document.querySelectorAll(".btn-filtro");

const cupos =
document.querySelectorAll(".cupo");

botones.forEach(function(boton){

    boton.addEventListener("click", function(){

        let tipo =
        boton.dataset.tipo;

        cupos.forEach(function(cupo){

            if(tipo === "todos"){

                cupo.style.display = "block";

            }else if(cupo.classList.contains(tipo)){

                cupo.style.display = "block";

            }else{

                cupo.style.display = "none";
            }

        });

    });

});
// SELECCIONAR CUPO

cupos.forEach(function(cupo){

    cupo.addEventListener("click", function(){

        // VALIDAR SI ESTA OCUPADO

        if(cupo.classList.contains("ocupado")){

            alert("❌ Este cupo está ocupado");

            return;
        }

        // OBTENER NUMERO CUPO

        let numeroCupo =
        cupo.dataset.cupo;

        // GUARDAR TEMPORALMENTE

        localStorage.setItem(
            "cupoSeleccionado",
            numeroCupo
        );

        // REDIRIGIR

        window.location.href =
        "reservas.jsp";

    });

});