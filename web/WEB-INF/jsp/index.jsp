<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.percy.factory.ServiceFactory" %>
<%@ page import="com.percy.vo.Emp" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: percy
  Date: 19-2-15
  Time: 下午6:56
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
    <title>员工列表</title>
</head>
<body>
<div class="panel-heading col-lg-offset-5" >
    <h2 class="pull-left"><i class="icon-home"></i> 员工列表</h2>
</div>
<table class="table table-striped table-bordered table-hover st-table-employee">
    <thead>
    <tr>
        <th>员工ID</th>
        <th>员工姓名</th>
        <th>年龄</th>
        <th>入职时间</th>
        <th>职位</th>
        <th>联系电话</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Emp> list = ServiceFactory.getIEmpServiceInstance().list();
        if (list == null) {
            return;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Emp vo = (Emp) iterator.next();
    %>
    <tr>
        <td><%=vo.getId()%>
        </td>

        <td><%=vo.getEmp_name()%>
        </td>
        <td><%=vo.getEmp_age()%>
        </td>
        <td><%=vo.getEmp_date()%>
        </td>
        <td><%=vo.getEmp_position()%>
        </td>
        <td><%=vo.getEmp_phone()%>
        </td>
        <form id="form1" name="myform" method="post" action="/delete">
        <td>
            <button name="change" type="submit" class="btn btn-info"  value="<%=vo.getId()%>">修改</button>
            <button name ="delete" type="submit" class="btn btn-danger" value="<%=vo.getId()%>">删除</button>

        </td>
        </form>

    </tr>
    <% }%>
    </tbody>
</table>
<div class="panel-body">
    <form id="form2" name="myform2" method="post" action="/add">
        <button type="submit" value="add_employee" class="icon-user btn btn-danger col-lg-offset-5">添加人员</button>
    </form>
</div>

</body>
</html>

