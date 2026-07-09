package api;
import java.io.IOException;
import java.util.List;
import dao.ReservaDAO;
import modelo.Reservas;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/Reservas")

public class ReservaApiServlet  extends HttpServlet {
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

  ReservaDAO dao = new
  ReservaDAO();

     //Obtener la lista de reservas desde la base de datos

  List<Reservas> lista = dao.listarResrvas();

    //Convertir la lista de reservas a formato json

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

    //Convierte el json enviado desde postman a un objeto reservas
    Reservas reservas  =   
     mapper.readValue(request.getReader(), Reservas.class);

     //Crear un objeto DAO para acceder a la base de datos
     ReservaDAO dao = new
     ReservaDAO();

     //Insertar la reserva en la base de datos
      boolean resultado = dao.insertar(reservas);
       if (resultado) {
      //Devuelve el código de estado 201 
      response.setStatus(HttpServletResponse.SC_CREATED);
      //Devuelve la reserva insertada en formato json
      mapper.writeValue(response.getWriter(),reservas);
      }else {
     //Devuelve el código de estado 400
     response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
     //Muestra un mensaje de error en formatojson
     System.out.println("Error al registrar la reserva");
 
      }

}

}

    

