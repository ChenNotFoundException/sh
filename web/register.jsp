<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ChenChen
  Date: 2018/10/28
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<s:form action="registerAction" namespace="/">
    <s:textfield  align="center" name="username" style="font-size:12px;width:120px;" label="注册用户名" />
    <s:password  align="center" name="password" style="font-size:12px;width:120px;" label="注册密码" />
    <s:submit  align="center" value="注册" />
</s:form>
</body>
</html>
