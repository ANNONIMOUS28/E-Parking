package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;


     public class UsuarioDAO {
     
        //Método GET para obtener todos los datos 

    public List<Usuario> listarUsuarios() {

        //Lista donde se almacena los usuarios
        List<Usuario> lista = new ArrayList<>();
        //Consultar en sql la tabla de usuarios
        String sql = "SELECT* FROM usuarios";
        //Conexión con la base  de datos
        try (
        Connection conn =
         conexion.ConexionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ) {
       try
       (ResultSet  rs = ps.executeQuery()) {

      while (rs.next()) {
       Usuario u = new Usuario();
       // Leer los datos de la tabla de usuarios

       u.setId(rs.getInt("id"));
       u.setNombre(rs.getString("nombre"));
       u.setIdentificacion(rs.getString("identificacion"));
       u.setTelefono(rs.getString("telefono"));
       u.setCorreo(rs.getString("correo"));
       u.setPassword(rs.getString("password"));
       u.setRol(rs.getString("rol"));
       u.setFechaRegistro(rs.getString("fecha_registro"));

       lista.add(u);
      }

       } 

        }catch (Exception e) {
        System.out.println("Listado de usuarios ejecutados");
        e.printStackTrace();    
        }
        return lista; 
    }

        //Método POST  para insertar usuarios
        public boolean insertar (Usuario usuario) {
       //Crear  en sql un  usuario

    String sql = "INSERT INTO Usuarios (nombre, identificacion, telefono, correo, password, rol, fecha_registro) VALUES (?,?,?,?,?,?,?)";
        
 
    //Conexión con la base de datos  
     try (Connection conn =
     conexion.ConexionDB.getConnection();
     PreparedStatement ps = conn.prepareStatement(sql)
     ) {
     //Asignar los valorea a los parametros del INSERT
    
    ps.setString(1, usuario.getNombre());
    ps.setString(2, usuario.getIdentificacion());
    ps.setString(3, usuario.getTelefono());
    ps.setString(4, usuario.getCorreo());
    ps.setString(5, usuario.getPassword());
    ps.setString(6, usuario.getRol());
    ps.setString(7, usuario.getFechaRegistro());

     return ps.executeUpdate() > 0;

    } catch(Exception e) {
     System.out.println("Usuario regisrado");
     e.printStackTrace();
     return false;
     }

 }
    }      
     


