package com.jee.acServletSessionTracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletc18")
public class C18ServletHttpSessionC extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // collect request parameter data
        String mail = request.getParameter("mail");
        String mobile = request.getParameter("mobile");

        // Create a session object and store these request parameter data in session
        // object
        HttpSession session = request.getSession();
        session.setAttribute("email", mail);
        session.setAttribute("mobile", mobile);

        // retrieve the data from session object
        Object name = session.getAttribute("name");
        Object age = session.getAttribute("age");
        Object qual = session.getAttribute("qual");
        Object design = session.getAttribute("design");
        Object gmail = session.getAttribute("email");
        Object umobile = session.getAttribute("mobile");

        // create a html page then send the response
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<center>");
        out.println("<table border='1' bgcolor='cyan'>");
        out.println("<tr><td>NAME</td><td>" + name + "</td></tr>");
        out.println("<tr><td>AGE</td><td>" + age + "</td></tr>");
        out.println("<tr><td>QUAL</td><td>" + qual + "</td></tr>");
        out.println("<tr><td>DESIGN</td><td>" + design + "</td></tr>");
        out.println("<tr><td>GMAIL</td><td>" + gmail + "</td></tr>");
        out.println("<tr><td>MOBILE</td><td>" + umobile + "</td></tr>");

        out.println("</table>");
        out.println("</center>");
        out.close();

    }

}

