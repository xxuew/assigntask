<%@ page import="java.util.List" %>
<%@ page import="com.wx.assigntask.entity.Algorithm" %>
<%@ page import="java.util.HashMap" %>
<%--
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
    <% HashMap algorithms = (HashMap) request.getAttribute("allJobInfo");
      String test = (String) request.getAttribute("test");
    %>
    <%=algorithms%>
    <%=test%>

</body>
</html>
