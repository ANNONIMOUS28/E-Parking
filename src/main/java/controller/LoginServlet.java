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

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)

            throws ServletException, IOException {

        String usuario =
        request.getParameter("usuario");

        String password =
        request.getParameter("password");

        if(usuario.equals("admin")
                && password.equals("123456")) {

            response.sendRedirect("disponibilidad.jsp");

        } else {

            response.getWriter().println(
                    "Usuario o contraseña incorrectos");
        }
    }
}