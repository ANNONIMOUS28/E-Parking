package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Recibe peticiones HTTP POST para realizar:
 * 1. Inicio de sesión (autenticación)
 * 2. Registro de nuevos usuarios
 * 
 * Retorna las respuestas en formato estándar JSON.
 */
@WebServlet({"/AuthService", "/api/auth"})
public class AuthServiceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Maneja las peticiones GET. En una API REST, la autenticación y registro
     * deben realizarse por POST por seguridad (para no exponer credenciales en la URL).
     * Por lo tanto, GET retornará una descripción de cómo consumir el servicio.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Configurar tipo de contenido de respuesta a JSON y codificación UTF-8
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        
        // Retornar mensaje informativo sobre el uso del servicio web
        out.print("{\n");
        out.print("  \"status\": \"error\",\n");
        out.print("  \"message\": \"Método GET no permitido. Por favor use POST para interactuar con este servicio web.\",\n");
        out.print("  \"documentacion\": {\n");
        out.print("    \"endpoint\": \"/api/auth\",\n");
        out.print("    \"metodo\": \"POST\",\n");
        out.print("    \"acciones_soportadas\": [\"login\", \"register\"]\n");
        out.print("  }\n");
        out.print("}");
        out.flush();
    }

    /**
     * Maneja las peticiones POST. Procesa el registro e inicio de sesión.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Asegurar el soporte de caracteres especiales (tildes, eñes) en la petición
        request.setCharacterEncoding("UTF-8");

        // Configurar tipo de respuesta como JSON y codificación UTF-8
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        // Obtener la acción a realizar (login o register)
        String action = request.getParameter("action");

        // Validar que se haya enviado el parámetro de acción
        if (action == null || action.trim().isEmpty()) {
            enviarRespuestaJson(out, "error", "Acción no especificada. Debe enviar el parámetro 'action' con 'login' o 'register'.");
            return;
        }

        // Ejecutar flujo según la acción solicitada
        switch (action.toLowerCase()) {
            case "login":
                procesarLogin(request, out);
                break;
            case "register":
                procesarRegistro(request, out);
                break;
            default:
                enviarRespuestaJson(out, "error", "Acción '" + action + "' no válida. Use 'login' o 'register'.");
                break;
        }
    }

    /**
     * Método encargado de procesar la autenticación de usuarios.
     * Recibe correo (usuario) y contraseña, y valida contra la base de datos.
     */
    private void procesarLogin(HttpServletRequest request, PrintWriter out) {
        // Capturar los parámetros de usuario (correo) y contraseña
        String correo = request.getParameter("usuario");
        // Si no viene como 'usuario', intentar capturarlo como 'correo'
        if (correo == null || correo.trim().isEmpty()) {
            correo = request.getParameter("correo");
        }
        String password = request.getParameter("password");

        // Validar que los campos no estén vacíos
        if (correo == null || correo.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            enviarRespuestaJson(out, "error", "Faltan campos obligatorios: usuario/correo y contraseña.");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Obtener conexión a la base de datos MySQL mediante la clase ConexionDB
            conn = ConexionDB.getConnection();

            if (conn == null) {
                enviarRespuestaJson(out, "error", "Error de conexión con la base de datos del servidor.");
                return;
            }

            // Consulta parametrizada para evitar ataques de inyección SQL
            String sql = "SELECT nombre, rol FROM usuarios WHERE correo = ? AND password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, correo.trim());
            ps.setString(2, password);

            // Ejecutar la consulta SQL
            rs = ps.executeQuery();

            // Si existe coincidencia en la base de datos
            if (rs.next()) {
                String nombreUsuario = rs.getString("nombre");
                String rolUsuario = rs.getString("rol");
                
                // Formatear JSON de éxito con datos adicionales de sesión
                out.print("{\n");
                out.print("  \"status\": \"success\",\n");
                out.print("  \"message\": \"Autenticación satisfactoria\",\n");
                out.print("  \"data\": {\n");
                out.print("    \"nombre\": \"" + nombreUsuario + "\",\n");
                out.print("    \"correo\": \"" + correo + "\",\n");
                out.print("    \"rol\": \"" + rolUsuario + "\"\n");
                out.print("  }\n");
                out.print("}");
            } else {
                // Mensaje exacto solicitado por la guía en caso de error
                enviarRespuestaJson(out, "error", "Error en la autenticación");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            enviarRespuestaJson(out, "error", "Excepción de base de datos durante el login: " + e.getMessage());
        } finally {
            // Cerrar recursos para prevenir fugas de memoria (Memory Leaks)
            cerrarRecursos(conn, ps, rs);
        }
    }

    /**
     * Método encargado de registrar un nuevo usuario en el sistema.
     * Recibe los datos personales e inserta el nuevo registro en la base de datos.
     */
    private void procesarRegistro(HttpServletRequest request, PrintWriter out) {
        // Capturar los parámetros requeridos para el registro
        String nombre = request.getParameter("nombre");
        String identificacion = request.getParameter("identificacion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        // Si no viene como 'correo', intentar capturarlo como 'usuario'
        if (correo == null || correo.trim().isEmpty()) {
            correo = request.getParameter("usuario");
        }
        String password = request.getParameter("password");

        // Validar que todos los campos requeridos estén presentes
        if (nombre == null || nombre.trim().isEmpty() ||
            identificacion == null || identificacion.trim().isEmpty() ||
            telefono == null || telefono.trim().isEmpty() ||
            correo == null || correo.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            
            enviarRespuestaJson(out, "error", "Faltan campos obligatorios para el registro: nombre, identificacion, telefono, correo, password.");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Obtener conexión a la base de datos MySQL
            conn = ConexionDB.getConnection();

            if (conn == null) {
                enviarRespuestaJson(out, "error", "Error de conexión con la base de datos del servidor.");
                return;
            }

            // Validar primero si el correo ya está registrado para evitar excepciones de llave primaria
            String sqlCheck = "SELECT correo FROM usuarios WHERE correo = ?";
            PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
            psCheck.setString(1, correo.trim());
            ResultSet rsCheck = psCheck.executeQuery();
            
            if (rsCheck.next()) {
                enviarRespuestaJson(out, "error", "El correo ingresado ya se encuentra registrado.");
                rsCheck.close();
                psCheck.close();
                return;
            }
            rsCheck.close();
            psCheck.close();

            // Consulta SQL parametrizada para insertar el nuevo registro
            String sqlInsert = "INSERT INTO usuarios (nombre, identificacion, telefono, correo, password, rol) VALUES (?, ?, ?, ?, ?, 'usuario')";
            ps = conn.prepareStatement(sqlInsert);
            
            ps.setString(1, nombre.trim());
            ps.setString(2, identificacion.trim());
            ps.setString(3, telefono.trim());
            ps.setString(4, correo.trim());
            ps.setString(5, password); // En producción se recomienda usar hash, pero para fines académicos se usa texto plano

            // Ejecutar la inserción
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                // Registro completado satisfactoriamente
                out.print("{\n");
                out.print("  \"status\": \"success\",\n");
                out.print("  \"message\": \"Usuario registrado satisfactoriamente\",\n");
                out.print("  \"data\": {\n");
                out.print("    \"nombre\": \"" + nombre.trim() + "\",\n");
                out.print("    \"correo\": \"" + correo.trim() + "\"\n");
                out.print("  }\n");
                out.print("}");
            } else {
                enviarRespuestaJson(out, "error", "No se pudo insertar el registro del usuario.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            enviarRespuestaJson(out, "error", "Excepción de base de datos durante el registro: " + e.getMessage());
        } finally {
            // Cerrar recursos de la base de datos
            cerrarRecursos(conn, ps, null);
        }
    }

    /**
     * Helper para enviar una estructura JSON estándar de respuesta de error o información.
     */
    private void enviarRespuestaJson(PrintWriter out, String status, String message) {
        out.print("{\n");
        out.print("  \"status\": \"" + status + "\",\n");
        out.print("  \"message\": \"" + message.replace("\"", "\\\"") + "\"\n");
        out.print("}");
        out.flush();
    }

    /**
     * Cierra de forma segura los recursos de JDBC abiertos.
     */
    private void cerrarRecursos(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
