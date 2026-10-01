package api;
import java.io.IOException;
import java.util.List;
import dao.VehiculoDAO;
import modelo.Vehiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/Vehiculos")

public class VehiculoApiServlet  extends HttpServlet {
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

  VehiculoDAO dao = new
  VehiculoDAO();

     //Obtener la lista de vehiculos desde la base de datos

  List<Vehiculo> lista = dao.listarVehiculos();

    //Convertir la lista de vehículos a formato json

    ObjectMapper mapper = new
    ObjectMapper();

    //Enviar respuesta  al cliente

   mapper.writeValue(response.getWriter(), lista);
    } 

  //Método que responde a solicitudes POST

 @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws
  ServletException, IOException {
    
    //Configurar tipo de respuesta
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    //Crear un objeto para leer y escribir datos en formato json
    ObjectMapper mapper = new
    ObjectMapper();

    //Convierte el json enviado desde postman a un objeto Vehiculos
    Vehiculo vehiculo  =   
     mapper.readValue(request.getReader(), Vehiculo.class);

     //Crear un objeto DAO para acceder a la base de datos
     VehiculoDAO dao = new
     VehiculoDAO();

     //Insertar el vehiculo en la base de datos
      boolean resultado = dao.insertar(vehiculo);
       if (resultado) {
      //Devuelve el código de estado 201 
      response.setStatus(HttpServletResponse.SC_CREATED);
      //Devuelve el vehiculo insertado en formato json
      mapper.writeValue(response.getWriter(),vehiculo);
      }else {
     //Devuelve el código de estado 400
     response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
     //Muestra un mensaje de error en formatojson
     System.out.println("Error al registrar el vehiculo");
 
      }


     

  }
}
