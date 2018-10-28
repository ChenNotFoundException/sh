<%@ taglib prefix="form" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ChenChen
  Date: 2018/10/27
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body><s:form action="loginaction" namespace="/">
  <s:textfield name="username" style="font-size:12px;width:120px;" label="登陆名称" />
           <s:password name="password" style="font-size:12px;width:120px;" label="登陆密码" />
                   <s:submit value="登陆" />
               </s:form>
</body>
</html>
