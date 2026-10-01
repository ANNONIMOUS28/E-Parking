package api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import conexion.ConexionDB;

/**
 * Servlet de autenticacion para la app Android.
 *
 * Ruta: POST /eparking/api/auth
 * Parametros: usuario (correo), password (contrasena)
 *
 * Responde JSON con la forma que espera MainActivity:
 *   exito  -> {"status":"success","data":{"id":1,"nombre":"...","correo":"...","rol":"..."}}
 *   fallo  -> {"status":"error","message":"..."}
 */
@WebServlet("/api/auth")
public class AuthApiServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        ObjectMapper mapper = new ObjectMapper();

        // Validacion de parametros antes de tocar la base
        if (usuario == null || usuario.isBlank()
                || password == null || password.isBlank()) {

            responderError(mapper, response, "Debe ingresar usuario y contrasena");
            return;
        }

        String sql =
                "SELECT id, nombre, correo, rol "
              + "FROM usuarios "
              + "WHERE correo = ? AND password = ?";

        Connection conn = null;

        try {

            conn = ConexionDB.getConnection();

            if (conn == null) {
                responderError(mapper, response, "No hay conexion con la base de datos");
                return;
            }

            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, usuario.trim());
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {

                        java.util.Map<String, Object> data = new java.util.LinkedHashMap<>();
                        data.put("id", rs.getInt("id"));
                        data.put("nombre", rs.getString("nombre"));
                        data.put("correo", rs.getString("correo"));
                        data.put("rol", rs.getString("rol"));

                        java.util.Map<String, Object> ok = new java.util.LinkedHashMap<>();
                        ok.put("status", "success");
                        ok.put("data", data);

                        mapper.writeValue(response.getWriter(), ok);
                        return;

                    } else {

                        responderError(mapper, response, "Credenciales invalidas");
                        return;
                    }
                }
            }

        } catch (Exception e) {

            System.out.println("ERROR en AuthApiServlet: " + e.getMessage());
            e.printStackTrace();

            responderError(mapper, response, "Error interno del servidor");

        } finally {

            if (conn != null) {

                try {
                    conn.close();
                } catch (Exception e) {
                    // cierre silencioso
                }
            }
        }
    }

    /**
     * Envia una respuesta de error con el formato que la app ya sabe leer.
     */
    private void responderError(ObjectMapper mapper, HttpServletResponse response, String mensaje)
            throws IOException {

        java.util.Map<String, Object> error = new java.util.LinkedHashMap<>();
        error.put("status", "error");
        error.put("message", mensaje);

        mapper.writeValue(response.getWriter(), error);
    }
}