<%@ page import="java.util.Date" %>
<%@ page import="com.percy.vo.Emp" %>
<%@ page import="com.percy.factory.ServiceFactory" %><%--
  Created by IntelliJ IDEA.
  User: percy
  Date: 19-2-16
  Time: 上午10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css"/>
    <script type="text/javascript" src="/static/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/static/js/bootstrap.js"></script>
    <title>$Title$</title>
    <title>Title</title>

</head>
<body>
<div class="row clearfix">
    <div class="col-lg-6 col-md-6">
        <div class="widget">
            <div class="widget-header col">
                <div class="title">
                    <span class="mini-title">
                        <h2>录入人员信息</h2>
                    </span>
                </div>
            </div>
            <div class="widget-body ">
                <form class="form-horizontal no-margin" method="POST" action="/addEmployee" >
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工ID<br>(*必填)</label>
                        <div class="col-sm-10">
                            <%int id=0;
                                for (Emp emp : ServiceFactory.getIEmpServiceInstance().list()) {
                                    if (id<emp.getId()){
                                        id=emp.getId();
                                    }
                                }
                                id++;
                            session.setAttribute("Employee_Id",id);
                            %>
                            <input type="text" eadonly="true" class="form-control" name="Employee_Id" id="Employee_Id"
                                   placeholder="Id" value="<%=id%>" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工姓名<br>(*必填)</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="Employee_Name" id="Employee_Name"
                                   placeholder="Name" value="胡鹏涛">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工年龄</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="Employee_Age" id="Employee_Age"
                                   placeholder="Age" value="33">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">入职时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="Employee_Date" id="Employee_Date"
                                   placeholder="Date" value="2019-02-16">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职位</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="Employee_Position" id="Employee_Position"
                                   placeholder="Position" value="jl">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="Employee_Phone" id="Employee_Phone"
                                   placeholder="Phone" value="18710001000">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-info">添加</button>
                            <button type="reset" class="btn btn-danger">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
