package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Cupos;

public class CupoDAO   {

      //Método para obtener todos los datos

    public List<Cupos> listarCupos() {

        //Lista donde se almacena los cupos
        List<Cupos> lista = new ArrayList<>();
        //Consultar en sql la tabla de cupos
        String sql = "SELECT* FROM cupos";
        //Conexión con la base de datos
        try (
        Connection conn =
         conexion.ConexionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ) {
       try
       (ResultSet  rs = ps.executeQuery()) {

      while (rs.next()) {
       Cupos c = new Cupos();
       // Leer los datos de la tabla de cupos

           //Leer los datos de la tabla cupos
      c.setId(rs.getInt("id"));
      c.setCodigo(rs.getString("codigo"));
      c.setEstado(rs.getString("estado"));

          if 
       ("Disponible".equalsIgnoreCase(c.getEstado()));
       {
          //El cupo esta disponible
       } if   
       ("Ocupado".equalsIgnoreCase(c.getEstado()));
       {
         //El cupo esta ocupado

       }

 }
}

 } catch (Exception e) {
  System.out.println("Error al consultar  la disponibilidas del cupo");
   e.printStackTrace();
  }

    return lista;

    }
  
    //Método para obtener todos los cupos con PUT
 public boolean actualizar (Cupos cupo) { 
  //Crear en sql un cupo
  String sql = "UPDATE cupos SET  codigo=?, estado=? WHERE id=?";
  
  //Conexión con la base de datos
  try (
  Connection  conn = 
  conexion.ConexionDB.getConnection();
  PreparedStatement ps = conn.prepareStatement(sql)

  ) {
          
    //Asignar los valores a  cada parametro del INSERT
    
    ps.setString(1, cupo.getCodigo());
    ps. setString(2, cupo.getEstado());
    ps.setInt(3, cupo.getId());
    
    return  ps.executeUpdate() > 0;

  }  catch (Exception e){
    System.out.println("Cupo Actualizado");
    e.printStackTrace();
        return false;
  }


 }


}





    
    

     


    

