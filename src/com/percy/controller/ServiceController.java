package com.percy.controller;

import com.percy.factory.ServiceFactory;
import com.percy.vo.Emp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author percy
 * @create 2019-02-15  下午11:22
 * @descreption:
 **/
@Controller
public class ServiceController {
    public ServiceController() {
        System.out.println("ServiceController");
    }

    @RequestMapping(value = "/")
    public String indexView() {
        return "index";
    }

    @RequestMapping(value = "/index")
    public String indexView1() {
        return "index";
    }

    @RequestMapping(value = "/delete")
    public String deleteAndEditView(String change, String delete, Model model) {
//      如果change为null，操作是删除
        if (change == null) {
            ServiceFactory.getIEmpServiceInstance().delete(Integer.valueOf(delete));
            return "index";
        } else {
//      否则是修改
            Emp emp = ServiceFactory.getIEmpServiceInstance().findbyid(Integer.valueOf(change));
            model.addAttribute("EmployeeId", emp.getId());
            model.addAttribute("EmployeeName", emp.getEmp_name());
            model.addAttribute("EmployeeAge", emp.getEmp_age());
            model.addAttribute("EmployeeDate", emp.getEmp_date());
            model.addAttribute("EmployeePosition", emp.getEmp_position());
            model.addAttribute("EmployeePhone", emp.getEmp_phone());

            return "editEmployee";
        }
    }

    //    public String deleteView(HttpServletRequest request){
//
//        String btn1= request.getParameter("change");
//        String btn2 = (String)request.getParameter("delete");
//        if (btn1 == null) {
//            System.out.println("delete is push");
//            System.out.println(btn2);
//            ServiceFactory.getIEmpServiceInstance().delete(Integer.valueOf(btn2));
////          刷新当前页面
//            return "index";
//        }
//        if (btn2 == null) {
//            System.out.println("change is push");
//
//            System.out.println(btn1);
//            request.setAttribute("EmployeeId",btn1);
////          跳转到编辑页面
//            return "editEmployee";
//        }
//        return "msg";
//    }
    @RequestMapping(value = "/add")
    public String addView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "addEmployee";
    }

    @RequestMapping(value = "/addEmployee")
    public void addEmployee(HttpServletRequest request) {
        Emp vo = new Emp();
        vo.setId(Integer.valueOf(request.getSession().getAttribute("Employee_Id").toString()));
        vo.setEmp_name(request.getParameter("Employee_Name").trim());
        vo.setEmp_age(Integer.valueOf(request.getParameter("Employee_Age").trim()));
        vo.setEmp_date(Date.valueOf(request.getParameter("Employee_Date").trim()));
        vo.setEmp_position(request.getParameter("Employee_Position").trim());
        vo.setEmp_phone(request.getParameter("Employee_Phone").trim());
        ServiceFactory.getIEmpServiceInstance().insert(vo);

    }

    @RequestMapping(value = "/edited")
    public String editEmployee(int Employee_Id, String Employee_Name, int Employee_Age, @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date Employee_Date, String Employee_Position, String Employee_Phone, Model model) {
        Emp vo = new Emp();
        vo.setId(Employee_Id);
        vo.setEmp_name(Employee_Name);
        vo.setEmp_age(Employee_Age);
        vo.setEmp_date(Employee_Date);
        vo.setEmp_position(Employee_Position);
        vo.setEmp_phone(Employee_Phone);
        ServiceFactory.getIEmpServiceInstance().update(vo);
        return "index";
    }

    public java.util.Date convert(String source) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
