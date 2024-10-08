package com.jee.aaServletIntro;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;

//@WebServlet(urlPatterns = "/servlet2") for one url pattern
@WebServlet(urlPatterns = {"/servlet2","/test2"}) // for multiple url patterns
//@WebServlet(value = "/test2") this also works fine

public class C02ServletAnnotation implements Servlet {
    static{
        System.out.println("Servlet Loaded");
    }

    public void init(ServletConfig config){
        System.out.println("Servlet Initiated");
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html> <body> <h1>ServletConfig Object: "
                +getServletConfig()+" </h1> </body></html>");
        out.close();
    }

    public void destroy(){
        System.out.println("Servlet De-Instantiated.");
    }

    public ServletConfig getServletConfig(){
        return null;
    }

    public String getServletInfo(){
        return "Developed by V";
    }
}
