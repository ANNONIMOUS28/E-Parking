package api;
import java.io.IOException;
import java.util.List;
import dao.CupoDAO;
import modelo.Cupos;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/Cupos")


public class CupoApiServlet extends HttpServlet {

    private static final long serialVersionUID  =1L;

  //Método que responde a solicitudes GET

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws
       ServletException, IOException  {

        //Configurar tipo de respuesta

        response.setContentType("application/json");

        response.setCharacterEncoding("UTF-8");

    
    //Crear objetos DAO para acceder a la base de datos

  CupoDAO dao = new
  CupoDAO();

     //Obtener la lista de cupos desde la base de datos

  List<Cupos> lista = dao.listarCupos();

    //Convertir la lista de cupos a formato json

    ObjectMapper mapper = new
    ObjectMapper();

    //Enviar respuesta  al cliente

   mapper.writeValue(response.getWriter(), lista);
    
 }  
 
    //Método que responde a solicitudes PUT

 @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response)
  throws
  ServletException, IOException {
    
    //Configurar tipo de respuesta
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    //Crear un objeto para leer y escribir datos en formato json
    ObjectMapper mapper = new
    ObjectMapper();

    //Convierte el json enviado desde postman a un objeto cupos
    Cupos cupo  =   
     mapper.readValue(request.getInputStream(), Cupos.class);

     //Crear un objeto DAO para acceder a la base de datos
     CupoDAO dao = new
     CupoDAO();

     //Insertar el cupo en la base de datos
      boolean actualizado = dao.actualizar(cupo);
       if (actualizado) {
      //Devuelve el código de estado 201 
      response.getWriter().write("{\"mensaje\":\"cupo actualizado correctamente\"}");
       
      //Devuelve el cupo actualizado en formato json
      mapper.writeValue(response.getWriter(),cupo);
      }else {
     //Devuelve el código de estado 400
     response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
     //Muestra un mensaje de error en formatojson
     System.out.println("Error no se puede actualizar  el cupo");
 
      }

}

}    

