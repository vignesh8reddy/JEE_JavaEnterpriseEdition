package com.jee.acServletSessionTracking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletc20")
public class C20ServletCookieSessionB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // collect request parameter
        String pcost = request.getParameter("pcost");
        String pquantity = request.getParameter("pquantity");

        // Create a cookie as per the requirement(inputs)
        Cookie c3 = new Cookie("pcost", pcost);
        Cookie c4 = new Cookie("pquantity", pquantity);

        // send the cookie object through response
        response.addCookie(c3);
        response.addCookie(c4);

        // forward the response to /cookiesessionform3.html
        RequestDispatcher rd = request.getRequestDispatcher("/cookiesessionform3.html");
        rd.forward(request, response);

    }

}
