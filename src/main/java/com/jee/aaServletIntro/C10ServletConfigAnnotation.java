package com.jee.aaServletIntro;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet(
        value = "/configb",
        initParams = {
                @WebInitParam(name="fname", value="Math"),
                @WebInitParam(name="lname", value="Chamber")
        }
        )
public class C10ServletConfigAnnotation extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config = getServletConfig();
        PrintWriter out = response.getWriter();
        out.print("<html>" +
                "<head> <title> Servlet Configuration Object </title> </head>" +
                "<body> <h3> The following are the parameters present in ServletConfiguration of this Servlet</h3>");
        Enumeration<String> parameternames = config.getInitParameterNames();
        while(parameternames.hasMoreElements()){
            String parametername = parameternames.nextElement();
            String parametervalue = config.getInitParameter(parametername).toString();
            out.print("<br>" + parametername + ": " + parametervalue);
        }

        out.println("</body> </html>");
        out.close();

    }

}
