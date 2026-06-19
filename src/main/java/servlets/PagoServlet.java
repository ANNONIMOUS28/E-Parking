package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PagoServlet")
public class PagoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Método de pago seleccionado
        String metodoPago =
                request.getParameter("metodoPago");

        // Sesión
        HttpSession session =
                request.getSession();

        String vehiculo =
                (String) session.getAttribute("vehiculo");

        String cupo =
                (String) session.getAttribute("cupo");

        String fecha =
                (String) session.getAttribute("fecha");

        String hora =
                (String) session.getAttribute("hora");

        Double total =
                (Double) session.getAttribute("total");

        // Validación básica
        if (metodoPago == null || metodoPago.isEmpty()) {

            response.getWriter().write(
                    "ERROR: Debes seleccionar un método de pago"
            );

            return;
        }

        // Simulación de procesamiento
        System.out.println("=== PROCESANDO PAGO ===");
        System.out.println("Vehículo: " + vehiculo);
        System.out.println("Cupo: " + cupo);
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Total: " + total);
        System.out.println("Método de pago: " + metodoPago);

        // Estado pago
        session.setAttribute(
                "estadoPago",
                "APROBADO"
        );

        response.setContentType("text/plain");

        response.getWriter().write(
                "PAGO EXITOSO"
        );
    }
}