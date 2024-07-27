package com.jee.aaServletIntro;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletConfig;

@WebServlet(value = "/hservlet")
public class C04HServlet extends HttpServlet{

    @Override
    public void init(ServletConfig config){
        /*
        As you are clearly overriding HttpServlet's implementation of init() method
        which somehow stores ServletConfig value in a global variable so that it could
        be accessed from doXXXX() methods, now you cannot access ServletConfig Object
        outside this init() method.
        */

        System.out.println("Servlet Initialized using init(SerlvetConfig config) method");
    }

    /*
    @Override
    public void init(){*/
        /*
        Now you are overriding HttpServlet's implementation of init() method
        meant to be overridden by developer you can access ServletConfig Object outside this
        init() method.

        System.out.println("Servlet Initialization using init() method");
    }*/



    public void doGet(HttpServletRequest hrequest, HttpServletResponse hresponse) throws ServletException, IOException {
        /*
        doGet() method is executed when you request the server this servlet
        using url on the address bar.
         */
        hresponse.setContentType("text/html");
        PrintWriter out = hresponse.getWriter();
        out.println("<html> <body> This executed from doGet() method <br> " +
                "HttpRequest Object: "+hrequest+
                "<br> ServletConfiguration Object: "+getServletConfig());
        out.println("<br> HttpResponse Object: </body> </html>"+hresponse);

        //ServletConfiguration Object: null;

    }

    public void doPost(HttpServletRequest hrequest, HttpServletResponse hresponse) throws ServletException, IOException{
        /*
        doPost() method is executed only when a html form is submitted with
        method attribute value as POST and action attribute referring to this
        servlet.
         */
        hresponse.setContentType("text/html");
        PrintWriter out = hresponse.getWriter();
        out.println("<html> <body> This executed from doPost() method <br> " +
                "HttpRequest Object: "+hrequest+
                "<br> ServletConfiguration Object: "+getServletConfig());
        out.println("<br> HttpResponse Object: </body> </html>"+hresponse);

        out.close();
    }
    /*
    url is same i.e http://localhost:xxxx/controller_war_exploded/hservlet
    but if you type it on address bar it'd going to call doGet() and
    if you use form submit button it'd call doPost();
     */



}
