package com.jee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/gservlet")
public class C03GServlet extends GenericServlet {

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html> <body> Servlet Configuration details: </body> </html>"+config);
    }
}
