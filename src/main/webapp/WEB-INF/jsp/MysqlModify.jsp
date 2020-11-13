<%--
  实现数据库操作可视化
  Created by IntelliJ IDEA.
  User: modige
  Date: 2020/11/11
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.hello.controller.*,com.hello.pojo.*,java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%!

    MysqlModify mysqlm = new MysqlModify();
    List<Table> list = mysqlm.ShowTables();

%>
<html>
<head>
    <title>Mysql可视化</title>
    <link rel="stylesheet" href="/css/daohang.css">

</head>
<button type="submit"><a href="index.jsp">返回首页</a></button>
<body>
<h1>数据库名：mybatis</h1>
<h2>当前数据库中所有的表</h2>
<table>
    <tr>

        <td>id</td>
        <td>表名</td>
        <td>属性个数</td>
        <td>内容</td>
    </tr>
    <% for(Table table:list){

    %>
    <tr>
        <td> <%=table.getId()%></td>
        <td> <%=table.getName()%></td>
        <td> <%=table.getAttrib_num()%></td>
        <td> <%=table.getDescrib()%></td>
    </tr>
    <%}%>
</table>
<div class="cssmenu">
<%--    <% for ()--%>
    <ul>
        <li><a  href ="per_info.jsp">数据库操作</a></li>

        <li><a href ="user_list.jsp">数据表</a></li>

        <li><a  href ="#">公告</a></li>
        <li><a href ="#">新闻</a></li>
        <li><a  href ="#">产品介绍</a></li>
        <li><a  href ="#" class ="last">联系我们</a></li>
    </ul>
</div>
</body>
</html>
