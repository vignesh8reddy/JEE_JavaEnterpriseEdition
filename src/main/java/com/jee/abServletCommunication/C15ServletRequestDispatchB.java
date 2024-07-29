package com.jee.abServletCommunication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/dispatcherb")
public class C15ServletRequestDispatchB extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        ServletContext filecontext = context.getContext("/JEE_Util");
        RequestDispatcher requestDispatcher = filecontext.getRequestDispatcher("/catcherb");



        /*
        Here url on browser address bar would be ///dispatcherb but response would be /catcherb
         */
        PrintWriter out = response.getWriter();
        out.print("I'm ServletRequestDispatcher B");
        request.setAttribute("To Kill A MockingBird", "Harper Lee");
        request.setAttribute("Animal Farm", "George Orwell");
        request.setAttribute("Malgudi Days","R. K. Narayan");

        /*
        You cannot see any print on response from this servlet because
        this response is flushed while forwarding to servlet /catcher
         */

        requestDispatcher.forward(request, response);

        /*
        Here, after forward happens again control comes back but this servlet now
        cannot write anything to response
         */

    }

}
