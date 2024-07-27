package com.jee.abServletCommunication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/redirect")
public class C12ServletSendRedirect extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        When you request this servlet, it's going to redirect you to google search.
         */

        response.sendRedirect("https://www.google.com");

    }

}
