package com.percy.factory;

import com.percy.service.IEmpService;
import com.percy.service.impl.EmpServiceImpl;

/**
 * @author percy
 * @create 2019-02-15  下午11:04
 * @descreption:
 **/
public class ServiceFactory {
    public static IEmpService getIEmpServiceInstance(){
        return new EmpServiceImpl();
    }
}
