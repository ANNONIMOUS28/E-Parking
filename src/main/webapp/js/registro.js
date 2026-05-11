const btnRegistro =
document.getElementById('btn-registrar');
btnRegistro.addEventListener('click', function (evento) {
    evento.preventDefault();
 const nombreCompleto = 
document.getElementById('nombre-completo').Value;
    const identificacion =
document.getElementById('identificacion').value;
    const teléfono =
document.getElementById('telefono').value;
    const correo =
document.getElementById('correo').value;
    const contraseña =
document.getElementById('contraseña').value;
    const  confirmarContraseña =
document.getElementById('confirmar-contraseña').value;
   
if (nombreCompleto === '' ||
    identificacion ===  ''  ||
    telefono ===  '' ||
    correo  ===  '' ||
    contraseña === '' ||
    confirmarContraseña ===  '' )
    {
        alert('completa todos los campos');
    } else {
        alert('registro exitoso');
       window.location.href = 'index.html'; 
    }
})  
    

     
    