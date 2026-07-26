package modelo;

public class Reservas {
    private int Id;
    public int getId () {
        return Id;
    }
    public void setId (int id) {
        this.Id = id;
    }
    private int usuarioId;
    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    private int vehiculoId;
    public int getVehiculoId() {
        return vehiculoId;
    }
    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }
    private int CupoId;
    public int getCupoId(){
        return CupoId;
    }
    public void setCupoId(int cupoId) {
        this.CupoId = cupoId;
    }
    private String Estado;
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String  estado) {
        this.Estado = estado;
    } 
    private String Fecha;
    public String getFecha() {
        return Fecha;
    }
    public void setFecha(String fecha) {
        this.Fecha = fecha;
    }
    private String  Hora;
    public String getHora() {
        return Hora;
    }
    public void setHora(String hora) {
        this.Hora = hora;
    }
}
