package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Cupos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de mostrar la disponibilidad de espacios de parqueadero
 */
@WebServlet("/DisponibilidadServlet")
public class DisponibilidadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Tipo de contenido que se enviará al navegador
        response.setContentType("text/html");

      
        // Simulación de espacios disponibles (dato estático por ahora)
        int cuposDisponibles = 30;
        int cuposOcupados = 15;
         request.setAttribute("CuposDisponibles",cuposDisponibles);
         request.setAttribute("CuposOcupados",cuposOcupados);
        // Enviar el valor de disponibilidad como respuesta al cliente
        response.getWriter().println("disponibles");

        // Consultar  la tabla cupos en Sql
        String sql = "SELECT* FROM cupos";
 
        // Conexión con la base de datos
       try(
       Connection conn  =
        conexion.ConexionDB.getConnection();
        PreparedStatement  ps =conn.prepareStatement(sql)
       ) {
        
       try
     (ResultSet rs = ps. executeQuery()) {
        
        while (rs.next()) {
           Cupos c= new Cupos();
          c.setId(rs.getInt("id")); 
          c.setCodigo(rs.getString("codigo"));
          c.setEstado(rs.getString("estado"));
          if 
       ("Disponible".equalsIgnoreCase(c.getEstado())); {
        cuposDisponibles ++;
          //El cupo esta disponible
       } if   
       ("Ocupado".equalsIgnoreCase(c.getEstado())); {
        cuposOcupados ++;
         //El cupo esta ocupado
       
       }


          
        }


     }


    } catch (Exception e) {
     System.out.println("Error al consultar  la disponibilidas del cupo");
     e.printStackTrace();
    }

      

    
}

}


