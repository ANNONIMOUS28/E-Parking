package servlets;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

    public static Connection getConnection() {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/eparking?useSSL=false&serverTimezone=UTC",
                    "root",
                    ""
            );

            System.out.println("✅ CONEXIÓN OK");
            return conn;

        } catch (Exception e) {

            System.out.println("❌ ERROR REAL DE CONEXIÓN:");
            e.printStackTrace(); // 🔥 ESTA ES LA CLAVE

            return null;
        }
    }
}