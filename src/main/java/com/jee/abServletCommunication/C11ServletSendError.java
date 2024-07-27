package com.jee.abServletCommunication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/c11")
public class C11ServletSendError extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int age = Integer.parseInt(request.getParameter("age"));
        if(age<21){
            response.sendError(504, "You are not eligible to buy alcohol yet.");
        }
        else{
            PrintWriter out = response.getWriter();
            out.print("<html> <head> <title> Eligibility </title> </head> " +
                    "<body> <h3>You can buy alcohol!</h3> </body> </html>");
        }


    }

}
