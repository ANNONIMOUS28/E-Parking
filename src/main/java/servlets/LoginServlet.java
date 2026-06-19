package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet encargado de autenticar usuarios en el sistema E-Parking
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Definir codificación para soportar caracteres especiales
        request.setCharacterEncoding("UTF-8");

        // Obtener datos enviados desde el formulario de login
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        try {

            // Obtener conexión a la base de datos
            Connection conn = ConexionDB.getConnection();

            // Consulta para validar usuario en la base de datos
            String sql = "SELECT * FROM usuarios WHERE correo=? AND password=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            // Asignar parámetros a la consulta
            ps.setString(1, correo);
            ps.setString(2, password);

            // Ejecutar consulta
            ResultSet rs = ps.executeQuery();

            // Si existe un usuario con esos datos
            if (rs.next()) {

                // Crear sesión para el usuario autenticado
                HttpSession session = request.getSession();

                // Guardar nombre del usuario en sesión
                session.setAttribute("usuario", rs.getString("nombre"));

                // Guardar rol del usuario en sesión
                session.setAttribute("rol", rs.getString("rol"));

                // Redirigir al menú principal
                response.sendRedirect(request.getContextPath()
                        + "/menu-principal.jsp");

            } else {

                // Mensaje si las credenciales son incorrectas
                response.getWriter().println(
                        "<h2>Correo o contraseña incorrectos</h2>"
                );
            }

            // Cerrar recursos de base de datos
            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            // Imprimir error en consola para depuración
            e.printStackTrace();

            // Mostrar error al cliente
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}