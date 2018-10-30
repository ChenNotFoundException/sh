<%@ taglib prefix="form" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ChenChen
  Date: 2018/10/27
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="login.css"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<!--SIGN UP-->
<h1>Easyui+spring+springmvc+hibernate+控制模型+通用后台</h1>
<div class="login-form">
    <div class="close"></div>
    <div class="head-info">
        <label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
            class="lbl-3"> </label>
    </div>
    <div class="clear"></div>
    <div class="avtar">
        <img src="/img/avtar.png" />
    </div>
    <form action="loginAction.action" method="post">
        <input type="text" class="text" value="Username" name="username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}">
        <div class="key">
            <input type="password" value="Password" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
        </div>
        <div class="signin">
            <input type="submit" value="Login">
        </div>
    </form>
</div>
</body>
</html>
