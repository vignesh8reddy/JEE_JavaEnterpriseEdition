package com.jee.abServletCommunication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/dispatchera")
public class C13ServletRequestDispatchA extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher reqdispatcher = request.getRequestDispatcher("/catcher");
        /* context.getRequestDispatcher("/test"); this will work too.
          use this approach when you want to dispatch request to the
          servlet present in the another Web Application but same server.
         */

        /*
        Here url on browser address bar would be ///dispatchera but response would be /catcher
         */
        PrintWriter out = response.getWriter();
        out.print("I'm ServletRequestDispatcher A");
        request.setAttribute("Titanic", "James Cameron");
        request.setAttribute("Interstellar", "Christopher Nolan");
        request.setAttribute("Catch Me If You Can","Martin Scorsese");

        /*
        You cannot see any print on response from this servlet because
        this response is flushed while forwarding to servlet /catcher
         */

        reqdispatcher.forward(request, response);

        /*
        Here, after forward happens again control comes back but this servlet now
        cannot write anything to response
         */

        System.out.println("Control Came back to Dispatcher A");// this gets printed on console
        out.print("I'm back.");// this wouldn't get printed
        out.print("</body></html>");
        /*
        Use reqdispatcher.include(request, response); So that
        out.print("I'm back."); get printed to response
         */
    }

}