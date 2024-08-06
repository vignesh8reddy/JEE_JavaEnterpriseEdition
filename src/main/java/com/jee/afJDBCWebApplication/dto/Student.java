package com.jee.afJDBCWebApplication.dto;

import java.io.Serializable;

public class Student implements Serializable {

    private Integer sid;
    private String sname;
    private Integer sage;
    private String saddr;

    static {
        System.out.println("STUDENT CLASS LOADED.");
    }

    public Student() {
        System.out.println("STUDENT OBJECT CREATED.");
    }

    @Override
    public String toString() {
        return "Student [sid=" + sid + "\nname=" + sname + "\nage=" + sage + "\naddress=" + saddr + "]";
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSaddr() {
        return saddr;
    }

    public void setSaddr(String saddr) {
        this.saddr = saddr;
    }

}
