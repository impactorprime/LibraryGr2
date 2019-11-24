package com.library.librarygr2.servlets;

import com.library.librarygr2.beans.User;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcome"})
public class WelcomeServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In WelcomeServlet\n\n\n\n\n");
        
        ServletContext context = request.getServletContext();
        
        if(context.getAttribute("loggedUser") == null && context.getAttribute("loggedAdmin") == null){
            request.getRequestDispatcher("/login.html").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/dashboard").forward(request, response);
        }

        
        System.out.println("Out WelcomeServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
