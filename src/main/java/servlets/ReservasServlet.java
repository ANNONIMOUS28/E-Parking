package servlets;

import java.io.IOException;

import   jakarta.servlet.ServletException;
import  jakarta.servlet.annotation.WebServlet;

import  jakarta.servlet.http.HttpServlet;
import  jakarta.servlet.http.HttpServletRequest;
import  jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReservasServlet")
public class ReservasServlet  extends HttpServlet{

    @Override
protected void doPost(HttpServletRequest  request,
        HttpServletResponse  response)
        throws
    ServletException,  IOException {
     String nombre =
     request.getParameter("nombre");
     response.getWriter().println("nombre"+ nombre +"<br>");

     String  placa =
     request.getParameter("placa");
     response.getWriter().println("placa"+ placa+"<br>");


     String fecha =
     request.getParameter("fecha");
      if (fecha == null ||
      fecha.isEmpty()) {
        response.getWriter().println("No se recibio la fecha");
        }  else {

        response.getWriter().println("fecha" + fecha);
        }
      
        String hora =
      request.getParameter("hora");
      if (hora  == null|| 
        hora.isEmpty()) {
            response.getWriter().println("no se recibio la hora");
        } else {
        response.getWriter().println("fecha:" + fecha);
        }


    }

    

}

 
