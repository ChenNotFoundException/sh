<%@ page import="com.cc.utils.PageBean" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: CHENCHEN
  Date: 2018/11/2
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="login.css"/>

<html>
<head>
    <title>分页查询</title>
</head>
<body>
<table>
    <tr>
        <td>
            共
            <s:property value="pageBean.totalPage"/>
            页
        </td>
        <td>
            共
            <s:property value="pageBean.allRow"/>
            条记录
        </td>
        <td>
            当前第
            <s:property value="pageBean.currentPage"/>
            页
        </td>

        <td>
            <s:if test="%{pageBean.currentPage == 1}">第一页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;</s:if>
            <s:else>
                <a href="pageAction.action?page=1">第一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
                <a href="pageAction.action?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </s:else>

            <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
                <a href="pageAction.action?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
                <a href="pageAction.action?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
            </s:if>
            <s:else>下一页&nbsp;&nbsp;&nbsp;&nbsp; 最后一页</s:else>
        </td>
    </tr>
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>密码</td>
    </tr>
    <%!

    %><s:iterator value="pageBean.list">
    <tr>
        <td>
            <s:property value="id"/>
        </td>
        <td>
            <s:property value="user"/>
        </td>
        <td>
            <s:property value="paw"/>
        </td>
    </tr>
</s:iterator>

    <%
        PageBean page2 = (PageBean) request.getAttribute("page");
        out.print(page2);
    %>

</table>
</body>
</html>
