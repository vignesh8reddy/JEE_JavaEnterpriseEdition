package com.jee.ServletIntro;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(value = "/file")
public class C06ServletFiles extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpg");
        ServletOutputStream out = response.getOutputStream();

        File fObj = new File("C:/Users/math/Documents/JEE_JavaEnterpriseEdition/src/main/resources/james.jpg");
        /*
        String path = getServletContext().getRealPath("james.jpg");//gets path from smooth deployment directory
		File fObj = new File(path);
         */

        byte[] buffer = new byte[(int)fObj.length()];
        FileInputStream fisObj = new FileInputStream(fObj);
        fisObj.read(buffer);//read and place it in buffer array
        out.write(buffer);//write it on response

        out.flush();
        out.close();

    }
}
