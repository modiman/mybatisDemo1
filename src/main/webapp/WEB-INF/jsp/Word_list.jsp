<%--
  Created by IntelliJ IDEA.
  User: modige
  Date: 2020/12/25
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.text.*" %>

<%@ page import="com.hello.pojo.Word" %>
<%@ page import="com.hello.controller.WordController" %>
<%!

    WordController sel = new WordController();
    List<Word> list = sel.SelectAllTest();


%>
<table border="1">
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>中文</td>
        <td>补充</td>
    </tr>
    <%

        for(Word word:list){//循环3次 每次输出一行%>
    <tr>
        <td><%=word.getWord_id()%></td>
        <td><%=word.getWord_name()%></td>
        <td><%=word.getWord_meaning()%></td>
        <td><%=word.getWord_buchong()%></td>
    </tr>

    <%--  </br>--%>

    <% }%>
</table>
<button type="submit"

</body>
</html>
