package api;
import java.io.IOException;
import java.util.List;
import dao.HistorialDAO;
import modelo.Historial;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/Historial")

public class HistorialApiServlet  extends HttpServlet {
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

  HistorialDAO dao = new
  HistorialDAO();

     //Obtener la lista del historial desde la base de datos

  List<Historial> lista = dao.listaHistorial();

    //Convertir la lista de vehículos a formato json

    ObjectMapper mapper = new
    ObjectMapper();

    //Enviar respuesta  al cliente

   mapper.writeValue(response.getWriter(), lista);
    
}  



}



