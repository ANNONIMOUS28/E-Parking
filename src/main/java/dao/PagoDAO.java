package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Pago;


public class PagoDAO {

//Método para obtener todos los datos GET
public List<Pago> listarPagos() {

 //Lista donde se almacena los pagos
  List<Pago> lista = new ArrayList<>();
 //Consultar en sql la tabla de pagos
 String sql = "SELECT* FROM pagos";
//Conexión con la base de datos
 try (
 Connection conn =
 conexion.ConexionDB.getConnection();
PreparedStatement ps = conn.prepareStatement(sql);
 ) {
try
(ResultSet  rs = ps.executeQuery()) {
 while (rs.next()) {
Pago p = new Pago();

 // Leer los datos de la tabla de Pagos

       
p.setId(rs.getInt("id"));
p.setReservaId(rs.getInt("reserva_id"));
p.setMetodoPago(rs.getString("metodo_pago"));
p.setTotal(rs.getDouble("total"));
p.setEstado(rs.getString("estado"));
p.setFechaPago(rs.getString("fecha_pago"));
 lista.add(p);
 }

 } 
} catch (Exception e) {
 System.out.println("Error al consultar los pagos"); e.printStackTrace();
}
    
       
 return lista;
} 

//Método para obtener todos los pagos con POST
 public boolean insertar (Pago pago) { 
  //Crear en sql un pago
  String sql = "INSERT INTO Pagos (reserva_Id, metodo_Pago, total, estado, fecha_Pago) VALUES (?,?,?,?,?)";
  
  //Conexión con la base de datos
  try (
  Connection  conn = 
  conexion.ConexionDB.getConnection();
  PreparedStatement ps = conn.prepareStatement(sql)

  ) {
          
    //Asignar los valores a  cada parametro del INSERT
    
    
    ps. setInt(1, pago.getReservaId());
    ps.setString(2, pago.getMetodoPago());
    ps.setDouble(3, pago.getTotal());
    ps.setString(4, pago.getEstado());
    ps.setString(5, pago.getFechaPago());
    
       
     return  ps.executeUpdate() > 0;

  }  catch (Exception e){
    System.out.println("Pago Registrado");
    e.printStackTrace();
        return false;
  }


 }


}




     

