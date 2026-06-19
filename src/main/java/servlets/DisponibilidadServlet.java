package servlets;

import java.io.IOException;

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
        int disponible = 30;

        // Enviar el valor de disponibilidad como respuesta al cliente
        response.getWriter().println(disponible);
    }
}