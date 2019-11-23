/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.librarygr2.helpers;

import com.library.librarygr2.beans.Book;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener()
public class SimpleLibraryContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SimpleLibraryContextListener");
        
        List<Book> books = new ArrayList<>();
        sce.getServletContext().setAttribute("books", books);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
