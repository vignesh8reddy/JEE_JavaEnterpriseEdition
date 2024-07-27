package com.jee.ServletIntro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(value = "/response")
public class C05ServletResponse extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String phone = request.getParameter("phone");

        String req = request.getClass().getName();
        String res = response.getClass().getName();
        int reqhash = request.hashCode();
        int reshash = response.hashCode();
        int threadhash = Thread.currentThread().hashCode();

        Enumeration<String> headernames = request.getHeaderNames();

        out.print("<html> " +

                "<head><title>Response Page</title><head>" +
                "<body>" +

                "<h4>User Details:</h4><br>" +
                "full name : " + fname + " " + lname +
                "<br>email : " + email +
                "<br>phone number : " + country + phone +

                "<br><br><h4>Request and Response Details: </h4>" +
                "<br>HttpServletRequest Interface implemented class' Object: " + req +
                "<br>HttpServletResponse Interface implemented class' Object: " + res +
                "<br>HttpServletRequest Interface implemented class' Object hashcode: " + reqhash +
                "<br>HttpServletResponse Interface implemented class' Object hashcode: " + reshash +
                "<br>CurrentThread's hashcode: " + threadhash +

                "<br><br><h4>Request Header Names: </h4>");
                while(headernames.hasMoreElements()){
                    String headername = headernames.nextElement();
                    String headervalue = request.getHeader(headername);
                    out.print("<br>"+ headername + ": " + headervalue);
                }

                out.print("<br><br> Some Other details from Request Obect: " +
                        "<br> Client IPAddress: " + request.getRemoteAddr() +
                        "<br> Client Host: " + request.getRemoteHost() +
                        "<br> Client Port: " + request.getRemotePort() +
                        "<br> Server Name: " + request.getServerName() +
                        "<br> Server Port: " + request.getServerPort() +
                        "</body></html>");

                out.close();

    }

}
