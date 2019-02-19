<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.percy.factory.ServiceFactory" %>
<%@ page import="com.percy.vo.Emp" %>
<%--
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
                <form class="form-horizontal no-margin" method="POST" action="/edited" >
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工ID<br>(*必填)</label>
                        <div class="col-sm-10">
                            <input type="text" readonly="true" class="form-control" name="Employee_Id" id="Employee_Id"
                                   placeholder="Id" value=${EmployeeId} >

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工姓名<br>(*必填)</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="Employee_Name" id="Employee_Name"
                                   placeholder="Name" value=${EmployeeName}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工年龄</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="Employee_Age" id="Employee_Age"
                                   placeholder="Age" value=${EmployeeAge}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">入职时间</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" name="Employee_Date" id="Employee_Date"
                                   placeholder="Date" value=${EmployeeDate}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职位</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="Employee_Position" id="Employee_Position"
                                   placeholder="Position" value=${EmployeePosition}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="Employee_Phone" id="Employee_Phone"
                                   placeholder="Phone" value=${EmployeePhone}>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-info">修改</button>
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
