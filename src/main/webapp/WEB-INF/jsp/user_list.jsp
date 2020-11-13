<%--
  Created by IntelliJ IDEA.
  User: modige
  Date: 2020/11/11
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.text.*" %>
<%@ page import="com.hello.controller.Select" %>
<%@ page import="com.hello.pojo.User" %>

<%@ page import="com.hello.pojo.Users" %>


<html>
<title>hellojsp</title>
<body bgcolor="aqua">
<button type="submit"><a href="index.jsp">返回首页</a></button>
<h1>员工表信息</h1>
<%!

    Select sel = new Select();
    List<User> list = sel.SelectAllTest();


%>
<table border="1">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <%

        for(User user:list){//循环3次 每次输出一行%>
    <tr>
        <td><%=user.getUid()%></td>
        <td><%=user.getUname()%></td>
        <td><%=user.getUage()%></td>
    </tr>

    <%--  </br>--%>

    <% }%>
</table>
<button type="submit"
<%--<h1><%=list.size()%></h1>--%>
</body>

</html>