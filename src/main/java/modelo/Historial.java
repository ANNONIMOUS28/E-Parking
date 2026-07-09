package modelo;

public class Historial {
    private int Id; 
    public int getId() {
        return Id;
    }
   public void setId (int id) {
    this.Id  = id;
   }
    private int  HistorialId;
    public int getHistorialId() {
        return HistorialId;

    }
public void setHistorialId (int historialId) {
    this.HistorialId = historialId;
}

private String  Fecha;
public String getFecha() {
    return Fecha;
}
public void setFecha (String fecha) {
    this.Fecha = fecha;
}
private String Vehiculo;
public String getVehiculo() {
    return Vehiculo;
}
public void setVehiculo (String vehiculo) {
    this.Vehiculo = vehiculo;
}
private String Cupo;
public String getCupo() {
    return Cupo;
}
public void setCupo (String Cupo) {
    this.Cupo = Cupo;

}
private String Estado;
public String getEstado() {
    return Estado;
}
public void setEstado (String estado){
 this.Estado =  estado;
}


}
