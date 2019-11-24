/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.librarygr2.servlets;

import com.library.librarygr2.beans.Role;
import com.library.librarygr2.beans.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/admin-login"})
public class AdminLoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(checkIfCorrectPassword(password)) {
            User user = createUser(login, password);
            saveAdminToContext(user, request.getServletContext());
            saveAdminToSession(user, request.getSession());
            request.getRequestDispatcher("/AdminServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/login-failed.html").forward(request, response);
        }
    }

    private boolean checkIfCorrectPassword(String password) {
        return "admin".equals(password);
    }
    
    private User createUser(String username, String password) {
        return new User(username, password, Role.ADMIN);
    }
    
    private void saveAdminToContext(User user, ServletContext context) {
        context.setAttribute("loggedAdmin", user);
        System.out.println("Dodano do admina kontekstu");
    }
    
    private void saveAdminToSession(User user, HttpSession session) {
        session.setAttribute("loggedAdmin", user);
        System.out.println("Dodano do admina sesji");
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
