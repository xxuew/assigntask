<%@ page import="java.util.List" %>
<%@ page import="com.wx.assigntask.entity.TaskTest" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/12/8
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%List<TaskTest> taskTests = (List<TaskTest>) request.getAttribute("allJobInfo");%>
    <%=taskTests%>
    <%List test = (List) request.getAttribute("test");%>
    <%List testtest = (List) request.getAttribute("testtest");%>

    <h2>
        <%=test%>
    </h2>
    <%=testtest%>
</body>
</html>
