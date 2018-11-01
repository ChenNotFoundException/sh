<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.cc.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ChenChen
  Date: 2018/10/27
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="login.css" />

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>登录成功！</title>
</head>
<body>
<h1>后台用户管理界面</h1>
<br/>
<%--<table class="table">--%>
    <%--<tr class="table_header">--%>
        <%--<td>ID</td>--%>
        <%--<td>姓名</td>--%>
        <%--<td>密码</td>--%>

    <%--</tr>--%>

   <%--<s:iterator value="list" status="st">--%>
       <%--<tr>--%>
           <%--<td><s:property value="id"/>--%>
           <%--<td><s:property value="user"/>--%>
           <%--<td><s:property value="paw"/>--%>
       <%--</tr>--%>
   <%--</s:iterator>--%>
    <%="下面是通过session取值"%>

    <table>
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>密码</td>
        </tr>

<%
    List <User> list = (List <User>) request.getSession().getAttribute("list2");
    for (User u :
            list) {

    %>
        <tr class="row1">
            <td><%=u.getId()%></td>
            <td><%=u.getUser()%></td>
            <td><%=u.getPaw()%></td>
            <td><a href="deleteAction.action?id=<%=u.getId()%>"
                   onclick="return confirm('是否要删除<%=u.getUser()%>');">删除</a>&nbsp;<a
                    href="Update.jsp?id=<%=u.getId()%>&username=<%=u.getUser()%>">修改</a></td>
        </tr>
<%
    }
%>
    </table>

<%--</table>--%>
<h2>

    <s:submit  align="center" value="注册" onclick="window.location.href='register.jsp'"/>

</h2>
</body>
</html>
