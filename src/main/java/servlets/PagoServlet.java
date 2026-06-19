package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet encargado de procesar el pago de una reserva en el sistema E-Parking
 */
@WebServlet("/PagoServlet")
public class PagoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Permitir caracteres especiales en la petición
        request.setCharacterEncoding("UTF-8");

        // Método de pago seleccionado por el usuario
        String metodoPago = request.getParameter("metodoPago");

        // Obtener la sesión actual del usuario
        HttpSession session = request.getSession();

        // Recuperar datos de la reserva almacenados en sesión
        String vehiculo = (String) session.getAttribute("vehiculo");
        String cupo = (String) session.getAttribute("cupo");
        String fecha = (String) session.getAttribute("fecha");
        String hora = (String) session.getAttribute("hora");
        Double total = (Double) session.getAttribute("total");

        // Validación básica del método de pago
        if (metodoPago == null || metodoPago.isEmpty()) {

            response.getWriter().write(
                    "ERROR: Debes seleccionar un método de pago"
            );

            return;
        }

        // Simulación del procesamiento del pago (no integración real con pasarela)
        System.out.println("=== PROCESANDO PAGO ===");
        System.out.println("Vehículo: " + vehiculo);
        System.out.println("Cupo: " + cupo);
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Total: " + total);
        System.out.println("Método de pago: " + metodoPago);

        // Guardar estado del pago en sesión
        session.setAttribute("estadoPago", "APROBADO");

        // Respuesta tipo texto plano al cliente
        response.setContentType("text/plain");

        response.getWriter().write("PAGO EXITOSO");
    }
}