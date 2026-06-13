package servlets;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/VehiculoServlet")
public class VehiculoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // LISTA TEMPORAL
    private static ArrayList<String[]> listaVehiculos = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // RECIBIR DATOS
        String placa = request.getParameter("placa");

        String tipoVehiculo =
                request.getParameter("tipoVehiculo");

        String color =
                request.getParameter("color");

        String propietario =
                request.getParameter("propietario");

        // VALIDACION SIMPLE
        if (placa == null || placa.isEmpty()) {

            response.sendRedirect("vehiculos.jsp");

            return;
        }

        // GUARDAR VEHICULO
        String[] vehiculo = {
                placa,
                tipoVehiculo,
                color,
                propietario
        };

        listaVehiculos.add(vehiculo);

        // ENVIAR LISTA
        request.setAttribute(
                "vehiculos",
                listaVehiculos
        );

        // REDIRIGIR
        request.getRequestDispatcher(
                "vehiculos.jsp"
        ).forward(request, response);
    }
}