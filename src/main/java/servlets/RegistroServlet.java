package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("nombre");
        String identificacion = request.getParameter("identificacion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String confirmarPassword = request.getParameter("confirmarPassword");

        try {

            if (nombre == null || identificacion == null ||
                telefono == null || correo == null ||
                password == null || confirmarPassword == null) {

                response.sendRedirect("registro.jsp?msg=error");
                return;
            }

            if (!password.equals(confirmarPassword)) {
                response.sendRedirect("registro.jsp?msg=error");
                return;
            }

            Connection conn = ConexionDB.getConnection();

            if (conn == null) {
                response.sendRedirect("registro.jsp?msg=error");
                return;
            }

            String sql =
                "INSERT INTO usuarios(nombre, identificacion, telefono, correo, password) VALUES (?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, identificacion);
            ps.setString(3, telefono);
            ps.setString(4, correo);
            ps.setString(5, password);

            ps.executeUpdate();

            ps.close();
            conn.close();

            response.sendRedirect("registro.jsp?msg=ok");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("registro.jsp?msg=error");
        }
    }
}