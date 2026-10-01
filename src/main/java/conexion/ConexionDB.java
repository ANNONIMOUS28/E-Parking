package conexion;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Clase encargada de manejar la conexión a la base de datos MySQL.
 *
 * Los datos de conexión NO están en el código. Se leen de
 * conexion.properties, que se busca en el classpath y, si no está,
 * en la carpeta del despliegue. Ese archivo no se versiona: la
 * plantilla es conexion.example.properties.
 */
public class ConexionDB {

    private static final String ARCHIVO = "conexion.properties";

    /**
     * Método estático que establece y retorna la conexión a la BD
     */
    public static Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Properties config = cargarConfiguracion();

            String url = config.getProperty(
                    "db.url",
                    "jdbc:mysql://localhost:3306/eparking"
                            + "?useSSL=false&serverTimezone=UTC"
            );

            String usuario = config.getProperty("db.user", "root");

            String clave = config.getProperty("db.password", "");

            conn = DriverManager.getConnection(url, usuario, clave);

            System.out.println("✅ CONEXIÓN OK");

            return conn;

        } catch (Exception e) {

            System.out.println("❌ ERROR REAL DE CONEXIÓN:");

            e.printStackTrace();

            System.out.println(
                    "Verifica que " + ARCHIVO
                            + " exista con db.url, db.user y db.password"
            );

            return null;
        }
    }

    /**
     * Busca el archivo de configuración en el classpath y, si no lo
     * encuentra, en el sistema de archivos. Devuelve un objeto
     * Properties vacío en lugar de fallar, para que getConnection
     * reporte un error legible.
     */
    private static Properties cargarConfiguracion() {

        Properties config = new Properties();

        try (InputStream entrada =
                     ConexionDB.class.getClassLoader()
                             .getResourceAsStream(ARCHIVO)) {

            if (entrada != null) {
                config.load(entrada);
                return config;
            }

        } catch (Exception e) {

            System.out.println(
                    "No se pudo leer " + ARCHIVO
                            + " del classpath: " + e.getMessage()
            );
        }

        try (InputStream entrada =
                     new FileInputStream(ARCHIVO)) {

            config.load(entrada);

        } catch (Exception e) {

            System.out.println(
                    "No se encontró " + ARCHIVO
                            + " junto a la aplicación."
            );
        }

        return config;
    }
}
