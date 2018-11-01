<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: CHENCHEN
  Date: 2018/10/31
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="true"%>
<link rel="stylesheet" type="text/css" href="login.css" />
<html>
<head>
    <title>更新用户</title>
</head>
<body>

<s:form action="updateAction" namespace="/">
    <%
        int id = Integer.valueOf(request.getParameter("id"));
       String username = request.getParameter("username");
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("id",id);
        System.out.println("request里面的username："+username);
    %>
<s:textfield align="center" name="username" style="font-size:12px;width:120px;" label="用户名"  disabled="true" value="%{#session.username}"/>
<s:textfield  align="center" name="password" style="font-size:12px;width:120px;" label="修改密码" />
<s:submit  align="center" value="修改" />
</s:form>
</body>
</html>
