package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        if ("admin".equals(usuario) && "123456".equals(password)) {
            response.getWriter().write("OK");
        } else {
            response.getWriter().write("ERROR");
        }
    }
}