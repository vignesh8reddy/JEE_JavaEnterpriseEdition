package com.jee.aaServletIntro;

/*

The Servlet API is contained within the javax.servlet package.
This package includes the core interfaces and classes needed to create servlets,
which are Java programs that extend the capabilities of a server.

Key components of the javax.servlet package include:

javax.servlet.Servlet (I)
javax.servlet.http.HttpServlet (AC)
javax.servlet.ServletRequest (I)
javax.servlet.ServletResponse (I)
javax.servlet.http.HttpServletRequest (I)
javax.servlet.http.HttpServletResponse (I)

like any other standard library packages javax package is also present in jdk/lib/rt.jar

Tomcat gives implementation for these interfaces to host the Web Applications
using those Servlets.
The implementation is present in Tomcat/lib/servlet-api.jar file

 */

/*
Servlet loading and instantiation happens only once when the server is started.
Whenever a request for Servlet has made always service() method is called repeatedly.
destroy() method is also called only once.
 */




import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class C01ServletIntro implements Servlet {

    static{
        System.out.println("Servlet Loaded");
    }

    public C01ServletIntro(){
        System.out.println("Servlet Instantiation");
    }

    //life cycle methods of a servlet
    public void init(ServletConfig config) {
        //Servlet Initialization phase
        System.out.println("Servlet Initialized");
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException{
        //Request-Processing-logic
        System.out.println("providing the service for the users");

        // 1. Set the response type to HTML
        response.setContentType("text/html");

        // 2. Use PrintWriter object  to send the response
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>First Servlet</title></head>");
        out.println("<body>");
        out.println("<h1 style='color:red'><marquee>Hi I'm a Servlet Response</marquee></h1>");
        out.println("</body>");
        out.println("</html>");

        // 3. Close the PrintWriter
        out.close();
    }

    public void destroy(){
        // De-Instantiation
        System.out.println("Servlet De-Instantiation");
    }

    public ServletConfig getServletConfig(){
        return null;

    }
    public String getServletInfo(){
        return "Developed by V";
    }
}
