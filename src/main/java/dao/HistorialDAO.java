package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Historial;



public class HistorialDAO {     
 //Método para obtener todos los datos

public List<Historial> listaHistorial() {

     //Lista donde se almacena el historial
    List<Historial> listaHistorial = new ArrayList<>();
    
    //Consultar en sql la tabla de historial
     String sql = "SELECT* FROM historial";
    //Conexión con la base de datos
        try (
        Connection conn =
         conexion.ConexionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ) {
       try
       (ResultSet  rs = ps.executeQuery()) {

      while (rs.next()) {
       Historial h = new Historial();
       // Leer los datos de la tabla de historial
     
       h.setId(rs.getInt("id"));
       h. setHistorialId(rs.getInt("historial_id"));
       h.setFecha(rs.getString("fecha"));
       h.setVehiculo(rs.getString("vehiculo"));
       h.setCupo(rs.getString("Cupo"));
       h.setEstado(rs.getString("estado"));
       
       listaHistorial.add(h);
            }
     
         }

        
      

    } catch (Exception e) {
     System.out.println("Error al ejecutar la consola");
      e.printStackTrace();
    }

     return listaHistorial;   

     } 
       
      }
      
      
    
      
    
    
  
  

    
  
  
    


