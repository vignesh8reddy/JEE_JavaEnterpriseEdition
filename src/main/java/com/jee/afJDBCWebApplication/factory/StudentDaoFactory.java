package com.jee.afJDBCWebApplication.factory;

import com.jee.afJDBCWebApplication.dao.IStudentDao;
import com.jee.afJDBCWebApplication.dao.StudentDaoImpl;

public class StudentDaoFactory {

    private static IStudentDao studentDao = null;

    private StudentDaoFactory() {
    }

    public static  IStudentDao getStudentDao() {
        if (studentDao == null)
            studentDao = new StudentDaoImpl();

        return studentDao;
    }
}

