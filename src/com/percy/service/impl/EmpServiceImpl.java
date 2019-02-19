package com.percy.service.impl;

import com.percy.dao.IEmpDAO;
import com.percy.dbc.DataBaseConnection;
import com.percy.factory.DAOFactory;
import com.percy.service.IEmpService;
import com.percy.vo.Emp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @create 2019-02-15  下午10:43
 * @descreption:
 **/
public class EmpServiceImpl implements IEmpService {
    private DataBaseConnection dbc;
    private IEmpDAO iEmpDAO;
    public EmpServiceImpl() {

    }

    @Override
    public List<Emp> list() {
        dbc = new DataBaseConnection();
        iEmpDAO = DAOFactory.getIEmpDAOInstance(dbc.getConnection());
        try {
            List<Emp> list = iEmpDAO.doFindAll();
            return list;
        }finally {
            dbc.close();
        }
    }

    @Override
    public int insert(Emp vo) {
        dbc = new DataBaseConnection();
        iEmpDAO = DAOFactory.getIEmpDAOInstance(dbc.getConnection());
        try {
            int rs = iEmpDAO.doCreate(vo);
            return rs;
        }finally {
            dbc.close();
        }

    }

    @Override
    public int delete(int id) {
        dbc = new DataBaseConnection();
        iEmpDAO = DAOFactory.getIEmpDAOInstance(dbc.getConnection());
        try {
            int rs = iEmpDAO.doDelete(id);
            return rs;
        }finally {
            dbc.close();
        }
    }

    @Override
    public int update(Emp vo) {
        dbc = new DataBaseConnection();
        iEmpDAO = DAOFactory.getIEmpDAOInstance(dbc.getConnection());
        try {
            int rs = iEmpDAO.doUpdata(vo);
            return rs;
        }finally {
            dbc.close();
        }
    }

    @Override
    public Emp findbyid(int id) {
        dbc = new DataBaseConnection();
        iEmpDAO = DAOFactory.getIEmpDAOInstance(dbc.getConnection());
        try {
            Emp rs = iEmpDAO.doFindById(id);
            return rs;
        }finally {
            dbc.close();
        }
    }
}
