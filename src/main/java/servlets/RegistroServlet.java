package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de registrar nuevos usuarios en el sistema E-Parking
 */
@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Permitir caracteres especiales en la petición
        request.setCharacterEncoding("UTF-8");

        // Captura de datos del formulario de registro
        String nombre = request.getParameter("nombre");
        String identificacion = request.getParameter("identificacion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String confirmarPassword = request.getParameter("confirmarPassword");

        try {

            // Validación de campos obligatorios (no nulos)
            if (nombre == null || identificacion == null ||
                telefono == null || correo == null ||
                password == null || confirmarPassword == null) {

                response.sendRedirect("registro.jsp?msg=error");
                return;
            }

            // Validación de coincidencia de contraseñas
            if (!password.equals(confirmarPassword)) {

                response.sendRedirect("registro.jsp?msg=error");
                return;
            }

            // Obtener conexión a la base de datos
            Connection conn = ConexionDB.getConnection();

            // Validación de conexión
            if (conn == null) {

                response.sendRedirect("registro.jsp?msg=error");
                return;
            }

            // Consulta SQL para insertar nuevo usuario
            String sql = "INSERT INTO usuarios(nombre, identificacion, telefono, correo, password) VALUES (?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            // Asignación de parámetros a la consulta
            ps.setString(1, nombre);
            ps.setString(2, identificacion);
            ps.setString(3, telefono);
            ps.setString(4, correo);
            ps.setString(5, password);

            // Ejecutar inserción en la base de datos
            ps.executeUpdate();

            // Cierre de recursos
            ps.close();
            conn.close();

            // Redirección en caso de registro exitoso
            response.sendRedirect("registro.jsp?msg=ok");

        } catch (Exception e) {

            // Mostrar error en consola para depuración
            e.printStackTrace();

            // Redirección en caso de error
            response.sendRedirect("registro.jsp?msg=error");
        }
    }
}