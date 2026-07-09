package modelo;

public class Vehiculo {
    private int Id;
    public int getId() {
        return Id;
    }
   public void setId (int id) {
    this.Id = id;
   }  
   private String Placa;
   public String getPlaca() {
    return Placa;
   }
   public void setPlaca (String placa) {
    this.Placa = placa;
   }
   private String Tipo;
   public String getTipo() {
    return Tipo;
   }
  public void setTipo (String tipo) {
    this.Tipo = tipo;
  }
  private String Color;
  public String getColor() {
    return Color;
  }
  public void setColor (String color) {
    this.Color = color;
  }
  private String Propietario;
  public String getPropietario() {
   return Propietario;
  }
  public void setPropietario (String propietario) {
   this.Propietario = propietario;
  }
  private Integer UsuarioId;
  public Integer getUsuarioId() {
    return UsuarioId;
  }
  public void setUsuarioId (Integer usuarioId) {
    this.UsuarioId = usuarioId;
  }
}
