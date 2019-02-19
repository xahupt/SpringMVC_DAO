package com.percy.factory;

import com.percy.dao.IEmpDAO;
import com.percy.dao.impl.EmpDAOImpl;

import java.sql.Connection;

/**
 * @author percy
 * @create 2019-02-15  下午10:35
 * @descreption:
 **/
public class DAOFactory {
    public static IEmpDAO getIEmpDAOInstance(Connection connection){
        return new EmpDAOImpl(connection);
    }
}
