package com.jee.afJDBCWebApplication.dao;

import com.jee.afJDBCWebApplication.dto.Student;

public interface IStudentDao {

    String save(Student student);// CREATE a record

    Student findById(Integer sid);// READ a record

    String updateById(Student student);// UPDATE a record

    String deleteById(Integer sid);// DELETE a record

}