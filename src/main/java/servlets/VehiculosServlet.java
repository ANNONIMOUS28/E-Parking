package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.ConexionDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de registrar y gestionar vehículos en el sistema E-Parking
 * (Actualmente usa una lista temporal en memoria)
 */
@WebServlet("/VehiculosServlet")
public class VehiculosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // LISTA TEMPORAL: almacena vehículos en memoria (no persistente)
    private static ArrayList<String[]> listaVehiculos = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // =========================
        // CAPTURA DE DATOS
        // =========================

        String placa = request.getParameter("placa");

        String tipoVehiculo = request.getParameter("tipoVehiculo");

        String color = request.getParameter("color");

        String propietario = request.getParameter("propietario");

        // =========================
        // VALIDACIÓN BÁSICA
        // =========================

        if (placa == null || placa.isEmpty()) {

            // Si no hay placa, se redirige sin procesar
            response.sendRedirect("vehiculos.jsp");

            return;
        }

        // =========================
        // CREACIÓN DEL VEHÍCULO
        // =========================

        String[] vehiculo = {
                placa,
                tipoVehiculo,
                color,
                propietario
        };

        // Guardar vehículo en la lista temporal
        listaVehiculos.add(vehiculo);

        // =========================
        // ENVÍO DE DATOS A LA VISTA
        // =========================

        request.setAttribute(
                "vehiculos",
                listaVehiculos
        );

        // =========================
        // REDIRECCIÓN A JSP
        // =========================

        request.getRequestDispatcher(
                "vehiculos.jsp"
        ).forward(request, response);

    //Consultar y mostrar en sql los vehículos registrados en la tabla de vehículos
     String sql = "SELECT* FROM  vehiculos";

     //Conexión con la base de datos
      try(
      Connection conn =
      ConexionDB.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql)
       ) {
       //Ejecutar consulta
       try
      (ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {

     //Leer los datos de la tabla vehículos
     

 }



 }
   //Imprime el error en caso de que no se pieda consultar los vehiculos
 } catch (Exception e) {
    System.out.println("Error al consultar  los vehículos");
    e.printStackTrace();
 }


    }
}