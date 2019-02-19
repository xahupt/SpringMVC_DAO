package com.percy.dao.impl;

import com.percy.dao.IEmpDAO;
import com.percy.vo.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * @author percy
 * @create 2019-02-15  下午8:05
 * @descreption:
 **/
public class EmpDAOImpl implements IEmpDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public EmpDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int doCreate(Emp vo) {
        int rs = 0;
        String sql = "INSERT INTO employee(id,emp_name,emp_age,emp_date,emp_position,emp_phone) VALUES (?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,vo.getId());
            preparedStatement.setString(2,vo.getEmp_name());
            preparedStatement.setInt(3,vo.getEmp_age());
            preparedStatement.setDate(4,new java.sql.Date(vo.getEmp_date().getTime()));
            preparedStatement.setString(5,vo.getEmp_position());
            preparedStatement.setString(6,vo.getEmp_phone());
            rs= preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int doDelete(Integer id) {
        int rs = 0;
        String sql = "DELETE FROM employee WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            rs = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int doUpdata(Emp vo) {
        int rs = 0;
        String sql = "UPDATE employee SET emp_name=?,emp_age=?,emp_date=?,emp_position=?,emp_phone=? WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,vo.getEmp_name());
            preparedStatement.setInt(2,vo.getEmp_age());
            preparedStatement.setDate(3,new java.sql.Date(vo.getEmp_date().getTime()));
            preparedStatement.setString(4,vo.getEmp_position());
            preparedStatement.setString(5,vo.getEmp_phone());
            preparedStatement.setInt(6,vo.getId());
            rs = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public List<Emp> doFindAll() {
        List<Emp> list = null;
        String sql = "SELECT * FROM employee";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery(sql);
            while (rs.next()){
                if (list==null){
                    list = new ArrayList<Emp>();
                }
                Emp emp = new Emp();
                emp.setId(rs.getInt(1));
                emp.setEmp_name(rs.getString(2));
                emp.setEmp_age(rs.getInt(3));
                emp.setEmp_date(rs.getDate(4));
                emp.setEmp_position(rs.getString(5));
                emp.setEmp_phone(rs.getString(6));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Emp doFindById(Integer id) {
        Emp emp = new Emp();
        String sql = "SELECT * FROM employee WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                emp.setId(rs.getInt(1));
                emp.setEmp_name(rs.getString(2));
                emp.setEmp_age(rs.getInt(3));
                emp.setEmp_date(rs.getDate(4));
                emp.setEmp_position(rs.getString(5));
                emp.setEmp_phone(rs.getString(6));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }
}
