<%@ page import="com.wx.assigntask.entity.ReleaseTask" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/12/7
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/lib/bootstrap-3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="lib/bootstrap-3.3.7/css/bootstrap-theme.min.css"/>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/user.js"></script>
    <jsp:include page="../head.jsp"></jsp:include>
    <title>我发布的任务</title>
</head>
<body>
<table class="table table-striped">
    <div class="row">
        <div class="center-block" style="width:300px;">
            <h2>我发布的任务
                <button id="addReleaseTask" class = "btn btn-primary" type= "submit" conclick="addRelease()">发布任务</button>
            </h2>
        </div>
    </div>
    <thead>
    <tr>
        <th>任务ID</th>
        <th>任务名称</th>
        <th>任务进度</th>
        <th>选取方案</th>
    </tr>
    </thead>
    <tbody>
    <% ReleaseTask releaseTask = (ReleaseTask) request.getAttribute("releaseInfos");%>
            <tr>
                <td><%=releaseTask.getTaskId()%></td>
                <td></td>
                <td>560001</td>
                <td></td>
        </tr>
    </tbody>
</table>
</body>
</html>
