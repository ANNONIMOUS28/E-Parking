package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import modelo.Vehiculo;

public class VehiculoDAO {

  //Método para obtener  todos los vehículos con POST
    public List<Vehiculo> listarVehiculos(){

    //Lista  donde  se almacenan  los vehículos 
 List<Vehiculo> lista = new ArrayList<>();

       //Consultar y mostrar en sql los vehículos registrados en la tabla de vehículos
     String sql = "SELECT* FROM  vehiculos";

     //Conexión con la base de datos
      try (
      Connection conn =
      conexion.ConexionDB.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql)
       ) {

       try
      (ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
      Vehiculo v = new Vehiculo();

     //Leer los datos de la tabla vehículos
     v.setId(rs.getInt("id"));
     v.setPlaca(rs.getString("placa"));
     v.setTipo(rs.getString("tipo"));
     v.setColor(rs.getString("color"));
     v.setPropietario(rs.getString("propietario"));
     v.setUsuarioId(rs.getInt("usuario_id"));
    
      lista.add(v);
 }



 }

 } catch (Exception e) {
    System.out.println("Error al consultar  los vehículos");
    e.printStackTrace();
 }
 return lista;
}
 //Método para obtener todos los vehículos con POST
 public boolean insertar (Vehiculo vehiculo) { 
  //Crear en sql un vehículo
  String sql = "INSERT INTO Vehiculos (placa, tipo, color, propietario, usuario_Id) VALUES (?,?,?,?,?)";
  
  //Conexión con la base de datos
  try (
  Connection  conn = 
  conexion.ConexionDB.getConnection();
  PreparedStatement ps = conn.prepareStatement(sql)

  ) {
          
    //Asignar los valores a  cada parametro del INSERT
    
    
    ps. setString(1, vehiculo.getPlaca());
    ps.setString(2, vehiculo.getTipo());
    ps.setString(3, vehiculo.getColor());
    ps.setString(4, vehiculo.getPropietario());
    ps.setInt(5, vehiculo.getUsuarioId());
    
       
     return  ps.executeUpdate() > 0;

  }  catch (Exception e){
    System.out.println("Vehiculo Registrado");
    e.printStackTrace();
        return false;
  }


 }


}



