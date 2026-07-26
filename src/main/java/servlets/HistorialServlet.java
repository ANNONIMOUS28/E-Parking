package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Historial;

/**
 *  Servlet encargado de mostrar el historial de reservas del usuario en el sistema E-parking 
*/
@WebServlet("/HistorialServlet")
public class HistorialServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws
    ServletException, IOException {
        //sección de busqueda de reservas por placa
        String placa =
        request.getParameter("placa");
        System.out.println("placa a consultar:" + placa);
        if (placa != null && !
          placa.isEmpty()) {
            placa = placa.trim();
            //Creamos el ArrayList dinámico para almacenar las filas de la tabla 
            List<HistorialServlet> listaHistorial =new ArrayList<>();

        // Tarjeta de estadistica del historial
      int totalReservas  = 0;
      int reservasActivas = 0;
      int reservasFinalizadas = 0;
      
      request.setAttribute("totalReservas",totalReservas);
      request.setAttribute("reservasActivas",reservasActivas);
      request.setAttribute("reservasFinalizadas",reservasFinalizadas);

      // Consulta SQL que une el historial  con el vehiculo usando INNER JOIN
       String sql =  "SELECT" + 
                     "historial.vehiculo_id," +
                    " historial.fecha," +
                     "historial.cupo," +
                     "historial.estado" +
                     "FROM historial" +
                     "INNER JOIN vehiculos ON" +
                     "historial.vehiculo = " +
                     "vehiculos.id";


        // Conexión con la base de datos
        try(
          Connection conn = 
        ConexionDB.getConnection();
        PreparedStatement ps  =conn.prepareStatement(sql)
      ) {

          ps.setString(1, placa); 
        try
        (ResultSet rs = ps. executeQuery()) {

          while (rs.next()) {
            Historial h= new Historial();
            //Extraemos los datos usando los nombres  exactos  de las columnas  de tu BD
            h.setId(rs.getInt("id"));
            h. setVehiculoId(rs.getInt("vehiculo-id"));
            h.setFecha(rs.getString("fecha"));
            h.setCupo(rs.getString("cupo"));
            h.setEstado(rs.getString("estado"));
            //Lógica  para acumular los valores  de las tarjetas estadisticas del historial
            if ("Activa".equalsIgnoreCase(h.getEstado())) {
              reservasActivas ++; 
            } else if ("Finalizada".equalsIgnoreCase(h.getEstado())) {
              reservasFinalizadas++;
              
            }
            
          }
        }

        
        
       // El total de la lista obtenida
       totalReservas = listaHistorial.size();
        

       } catch (Exception e) {
        System.out.println("Error al ejecutar la consulta con las columnas reales:" + e.getMessage());
        e.printStackTrace();
       
      }
    }
      } 
    
    }
  
  

    
  
  
    
