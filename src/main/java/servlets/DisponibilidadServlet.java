package servlets;

import java.io.IOException;

import   jakarta.servlet.ServletException;
import  jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisponibilidadServlet")

public  class DisponibilidadServlet extends HttpServlet {
    @Override
    
     protected  void doGet(HttpServletRequest request, 
                HttpServletResponse response)
    throws ServletException, IOException {

     response.setContentType("text/html");

     int disponible = 30;

     response.getWriter().println(disponible);
  }
    }

