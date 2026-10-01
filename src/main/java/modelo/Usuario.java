package modelo;

public class Usuario {
    private int Id;
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }
     private String Nombre;
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) { 
        this.Nombre = nombre;
       }
 private  String Identificacion;
    public String getIdentificacion() {
        return Identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.Identificacion = identificacion;
    }
    private String Telefono;
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }
    private String Correo;
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        this.Correo = correo;
    }
    private String Password;
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password  = password;
    }
    private String Rol;
    public String getRol() {
        return Rol;
    }
    public void setRol(String rol) {
        this.Rol = rol;
    }
    private String FechaRegistro;
    public String getFechaRegistro() {
        return FechaRegistro;
    }
    public void setFechaRegistro(String fechaRegistro) {
        this.FechaRegistro = fechaRegistro;
    }

}
