package modelo;

public class Historial {
    private int Id; 
    public int getId() {
        return Id;
    }
   public void setId (int id) {
    this.Id  = id;
   }
    private int  VehiculoId;
    public int getVehiculoId() {
        return VehiculoId;

    }
public void setVehiculoId (int vehiculoId) {
    this.VehiculoId = vehiculoId;
}

private String  Fecha;
public String getFecha() {
    return Fecha;
}
public void setFecha (String fecha) {
    this.Fecha = fecha;
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
