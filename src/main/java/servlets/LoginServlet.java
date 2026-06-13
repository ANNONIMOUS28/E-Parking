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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String correo =
                request.getParameter("correo");

        String password =
                request.getParameter("password");

        try {

            Connection conn =
                    ConexionDB.getConnection();

            String sql =
                    "SELECT * FROM usuarios " +
                    "WHERE correo=? AND password=?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, correo);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                HttpSession session =
                        request.getSession();

                session.setAttribute(
                        "usuario",
                        rs.getString("nombre")
                );

                session.setAttribute(
                        "rol",
                        rs.getString("rol")
                );

                response.sendRedirect(
                        request.getContextPath()
                        + "/menu-principal.jsp"
                );

            } else {

                response.getWriter().println(
                        "<h2>Correo o contraseña incorrectos</h2>"
                );
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error: " + e.getMessage()
            );
        }
    }
}