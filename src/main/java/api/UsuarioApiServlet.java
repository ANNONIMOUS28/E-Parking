package api;
import java.util.List;
import dao.UsuarioDAO;
import modelo.Usuario;
import java.util.Map;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/Usuarios")
 public class UsuarioApiServlet  extends HttpServlet {
    private static final long serialVersionUID  = 1L;

    //Metodo que responde a solicitudes GET

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws
       ServletException, IOException  {

         //Configurar tipo de respuesta

        response.setContentType("application/json");

        response.setCharacterEncoding("UTF-8");

    
     //Crear objetos DAO para acceder a la base de datos

 UsuarioDAO dao = new
 UsuarioDAO();

//Obtener la lista de usuarios desde la base de datos

 List<Usuario> lista = dao.listarUsuarios();

  //Enviar respuesta al cliente en formato json

 ObjectMapper mapper = new
 ObjectMapper();
 mapper.writeValue(response.getWriter(), lista);

 }
 
 // Método que responde a solicitudes POST
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws
  ServletException, IOException {

   //Configurar tipo de respuesta

   response.setContentType("application/json");

  response.setCharacterEncoding("UTF-8");
  //Crea un objeto para leer  y escribir en formato json

  ObjectMapper mapper = new
  ObjectMapper();
  try  {
  
   //Leer el json enviado desde postman
 
        Usuario usuario =
      mapper.readValue(request.getReader(),Usuario.class);
  // Guardar en la base de datos
   UsuarioDAO dao = new
  UsuarioDAO();
        boolean resultado  =
  dao.insertar (usuario);
               if(resultado) {
    //Devuelve el codigo 201 c
   response.setStatus(HttpServletResponse.SC_CREATED);
   mapper.writeValue(response.getWriter(),usuario);
    //Devuelve el codigo de estado 400
       }else {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.getWriter().write("{\"mensaje\":\"No se pudo registrar el usuario\"}");

       }
                   
    } catch (Exception e) {

    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
     mapper.writeValue(response.getWriter(),  
     Map.of("Error",e.getMessage()));
       }
    
}

}