package servlets;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase encargada de manejar la conexión a la base de datos MySQL
 */
public class ConexionDB {

    /**
     * Método estático que establece y retorna la conexión a la BD
     */
    public static Connection getConnection() {

        // Objeto de conexión inicializado en null
        Connection conn = null;

        try {

            // Cargar el driver de MySQL (Connector/J)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer conexión con la base de datos
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/eparking?useSSL=false&serverTimezone=UTC",
                    "root",
                    ""
            );

            // Mensaje si la conexión es exitosa
            System.out.println("✅ CONEXIÓN OK");

            return conn;

        } catch (Exception e) {

            // Mensaje de error si falla la conexión
            System.out.println("❌ ERROR REAL DE CONEXIÓN:");

            // Imprime el error completo en consola (clave para depuración)
            e.printStackTrace();

            return null;
        }
    }
}