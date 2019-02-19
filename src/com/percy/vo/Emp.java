package com.percy.vo;

import java.util.Date;

/**
 * @author percy
 * @create 2019-02-15  下午7:34
 * @descreption:
 **/
public class Emp {
    private int id;
    private String emp_name;
    private int emp_age;
    private Date emp_date;
    private String emp_position;
    private String emp_phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public Date getEmp_date() {
        return emp_date;
    }

    public void setEmp_date(Date emp_date) {
        this.emp_date = emp_date;
    }

    public String getEmp_position() {
        return emp_position;
    }

    public void setEmp_position(String emp_position) {
        this.emp_position = emp_position;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }
}
