package com.jee.ServletIntro;

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
        response.setContentType("text/html");//By default content type is "text/html"
        PrintWriter out = response.getWriter();
        out.println("<html> <body> Servlet Configuration details: </body> </html>"+getServletConfig());
        out.close();
    }
}
