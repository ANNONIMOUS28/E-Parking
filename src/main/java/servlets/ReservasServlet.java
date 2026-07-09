package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.ConexionDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de procesar las reservas del sistema E-Parking
 */
@WebServlet("/ReservasServlet")
public class ReservasServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener parámetro nombre del formulario
        String nombre = request.getParameter("nombre");
        response.getWriter().println("nombre " + nombre + "<br>");

        // Obtener placa del vehículo
        String placa = request.getParameter("placa");
        response.getWriter().println("placa " + placa + "<br>");

        // Obtener fecha de la reserva
        String fecha = request.getParameter("fecha");

        // Validación de fecha
        if (fecha == null || fecha.isEmpty()) {

            response.getWriter().println("No se recibió la fecha");

        } else {

            response.getWriter().println("fecha " + fecha);
        }

        // Obtener hora de la reserva
        String hora = request.getParameter("hora");

        // Validación de hora
        if (hora == null || hora.isEmpty()) {

            response.getWriter().println("No se recibió la hora");

        } else {

            // CORRECCIÓN: antes imprimía "fecha", ahora imprime hora correctamente
            response.getWriter().println("hora: " + hora);
        }

        //Consultar la tabla de reservas en sql
        String  sql =  "SELECT* FROM  reservas";

     //Conexión con la base de datos

     try(
    Connection conn =
    ConexionDB.getConnection();
    PreparedStatement  ps=conn.prepareStatement(sql)
   ) {
      // Ejecutar la consulta
    try
    (ResultSet rs  =ps . executeQuery()) {

   while  (rs.next()) {
   // Leer los datos de la tabla de reservas
   }  
 
  }
     //Imprimir el error en caso de que no se pueda consultar la reserva
   } catch (Exception e) {
     System.out.println("Error al consultar la reaserva"); 
     e.printStackTrace(); 
    }
     
      
    }

}


 


    
