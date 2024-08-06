package com.jee.afJDBCWebApplication.factory;

import com.jee.afJDBCWebApplication.service.IStudentService;
import com.jee.afJDBCWebApplication.service.StudentServiceImpl;

public class StudentServiceFactory {

    private static IStudentService studentServiceImpl;

    private StudentServiceFactory() {

    }

    public static IStudentService getStudentService() {
        if (studentServiceImpl == null)
            studentServiceImpl = new StudentServiceImpl();

        return studentServiceImpl;
    }
}
