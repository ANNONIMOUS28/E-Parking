package modelo;

public class Pago {
private int Id;
public int getId() {
    return Id;
}
public void setId (int id) {
    this.Id = id;

}
private int ReservaId;
public int getReservaId() {
    return ReservaId;
}
public void setReservaId (int reservaId) {
    this.ReservaId = reservaId;
}
private String MetodoPago;
public String getMetodoPago() {
    return MetodoPago;
}
public void setMetodoPago (String metodopago) {
    this.MetodoPago = metodopago;
}
private double Total;
public double getTotal() {
    return Total;
}
public void setTotal (double total) {
    this.Total = total;
}
private String Estado;
public String getEstado() {
    return Estado;
}
public void  setEstado (String estado){
    this.Estado = estado;
}
private String FechaPago;
public String getFechaPago() {
    return FechaPago;
}
public void setFechaPago (String fechapago) {
    this.FechaPago = fechapago;
}
}
