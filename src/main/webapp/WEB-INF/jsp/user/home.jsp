<%@ page import="java.util.ArrayList" %>
<%@ page import="com.wx.assigntask.entity.ReleaseTask" %>
<%@ page import="com.wx.assigntask.dao.ReleaseDao" %>
<%@ page import="com.wx.assigntask.controller.UserController" %>
<%@ page import="com.wx.assigntask.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/12/7
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/lib/bootstrap-3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="lib/bootstrap-3.3.7/css/bootstrap-theme.min.css"/>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="js/user.js"></script>
    <jsp:include page="../head.jsp"></jsp:include>
    <title>home</title>
</head>
<body>
    <form id = "userInfo" action="">
        <table class="table table-striped">
            <div class="center-block" style="width:300px;">
                <h2>个人信息</h2>
            </div>
            <thead>
            <tr>
                <th>用户ID</th>
                <th>用户名</th>
                <th>发布的任务ID</th>
                <th>接收的任务</th>
            </tr>
            </thead>
            <tbody>
            <% User user = (User) request.getAttribute("userInfo");%>
            <tr>
                <td><%=user.getUserId()%></td>
                <td><%=user.getUsername()%></td>
                <td><%=user.getReleaseId()%></td>
                <td><%=user.getReceiveId()%></td>
            </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
