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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功！</title>
</head>
<body>
<h1>后台用户管理界面</h1>
<br/>
<table class="table">
    <tr class="table_header">
        <td>ID</td>
        <td>姓名</td>
        <td>密码</td>

    </tr>

   <s:iterator value="list" status="st">
       <tr>
           <td><s:property value="id"/>

           <td><s:property value="user"/>

           <td><s:property value="paw"/>

       </tr>
   </s:iterator>



</table>
<h1>
<div class="signin">
    <input type="submit" value="注册新人">
</div>
</h1>
</body>
</html>
