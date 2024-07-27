package com.jee.abServletCommunication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value = "/catcher")
public class C14ServletRequestDispatchUtil extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.print("<html> <body> <h3> Hi, I was dispatched by ServletRequestDispatcher A. </h3>");
        Enumeration<String> attributenames = request.getAttributeNames();

        while (attributenames.hasMoreElements()) {
            String name = attributenames.nextElement();
            String value = request.getAttribute(name).toString();
            out.println("<br>" + name + ": "+ value);
        }
        out.print("</body></html>");

        out.flush();//response is flushed(cleared) and commited, so below code is not executed

        RequestDispatcher rd = request.getRequestDispatcher("/test");
        rd.forward(request, response);//this forward won't happen.

    }

}