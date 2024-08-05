package com.jee.acServletSessionTracking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletc17")
public class C17ServletHttpSessionB extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // collect request parameter data
        String qual = request.getParameter("qual");
        String design = request.getParameter("design");

        // Create a session object and store these request parameter data in sessionobject
        HttpSession session = request.getSession();
        session.setAttribute("qual", qual);
        session.setAttribute("design", design);

        // forward the response to httpsessionform3.html
        RequestDispatcher rd = request.getRequestDispatcher("/httpsessionform3.html");
        rd.forward(request, response);

    }

}
