package com.jee.aaServletIntro;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value = "/servletb")
public class C08ServletContextB extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();

        PrintWriter out = response.getWriter();
        out.print("<html>" +
                "<head> <title> ServletB </title> </head>" +
                "<body> <h3> The following is the Static Data (Parameters from Web.xml) of ServletContext of this Web Application</h3>");
        Enumeration<String> parameternames = context.getInitParameterNames();
        while(parameternames.hasMoreElements()){
            String parametername = parameternames.nextElement();
            String parametervalue = context.getInitParameter(parametername);
            out.print("<br>" + parametername + ": " + parametervalue);
        }

        out.print("<h3> The following is the Dynamic Data (Attributes) of ServletContext of this Web Application</h3>");

        Enumeration<String> attributenames = context.getAttributeNames();
        while(attributenames.hasMoreElements()){
            String attributename = attributenames.nextElement();
            String attributevalue = context.getAttribute(attributename).toString();
            out.print("<br>" + attributename + ": " + attributevalue);

            /*
            Here, you cannot access Dynamic Attributes set by Servlet A.
            Dynamic Attributes can be accessed only by the servlet which has set them.
             */
        }

        out.println("</body> </html>");
        out.close();

    }

}