package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Reservas;

public class ReservaDAO {
 
     //Método para obtener todos los datos

    public List<Reservas> listarResrvas() {

        //Lista donde se almacena las reservas
        List<Reservas> lista = new ArrayList<>();
        //Consultar ens sql la tabla de reservas
        String sql = "SELECT* FROM reservas";
        //Conexión con la base de datos
        try (
        Connection conn =
         conexion.ConexionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ) {
       try
       (ResultSet  rs = ps.executeQuery()) {

      while (rs.next()) {
       Reservas r = new Reservas();
       // Leer los datos de la tabla de reservas

   r.setId(rs.getInt("Id"));
  r.setUsuarioId(rs.getInt("usuario_id"));
  r.setVehiculoId(rs.getInt("vehiculo_id"));
  r.setCupoId(rs.getInt("Cupo_id"));
  r.setEstado(rs.getString("Estado"));
  r.setFecha(rs.getString("Fecha"));
  r.setHora(rs.getString("Hora"));

  if 
  ("Disponible".equalsIgnoreCase(r.getEstado())) {
  System.out.println("El cupo esta disponible");
  } if
   ("Ocupado".equalsIgnoreCase(r.getEstado())) {
    System.out.println("El cupo esta ocupado");
   }  
   lista.add(r);
  }

   }

    }catch (Exception e) {
     System.out.println("Error al consultar la reserva");
      e.printStackTrace();
    }


     return lista;

 }

 //Método para obtener todos los vehículos con POST
 public boolean insertar (Reservas reservas) { 
  //Crear en sql una reserva
  String sql = "INSERT INTO Reservas (usuario_Id, vehiculo_Id, cupo, estado, fecha, hora) VALUES (?,?,?,?,?,?)";
  
  //Conexión con la base de datos
  try (
  Connection  conn = 
  conexion.ConexionDB.getConnection();
  PreparedStatement ps = conn.prepareStatement(sql)

  ) {
          
    //Asignar los valores a  cada parametro del INSERT
    
    
    ps. setInt(1, reservas.getUsuarioId());
    ps. setInt(2, reservas.getVehiculoId());
    ps. setInt(3, reservas.getCupoId());
    ps. setString(4, reservas.getEstado());
    ps. setString(5, reservas.getFecha());
    ps. setString(6, reservas.getHora());
    
       
     return  ps.executeUpdate() > 0;

  }  catch (Exception e){
    System.out.println("Reserva Registrada");
    e.printStackTrace();
        return false;
  }


 }


}



    


    

