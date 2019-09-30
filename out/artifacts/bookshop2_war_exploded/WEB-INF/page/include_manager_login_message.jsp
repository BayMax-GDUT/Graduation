<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/7
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javafx.scene.control.Alert" %>
<%@ page import="bean.Manager" %>
<html>
<head>
    <meta content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>管理员登录信息</title>
    <style type="text/css">
        body {
            background-color: rgb(49, 57, 89);
        }
        h3 {
            font-size: 36;
            color: #ffffff;
            text-align: center;
            margin: 0;
        }
        .text{
            color:#ffffff;
        }
        .deepblue {
            width: 300px;
            height: 50px;
            background-color: rgb(39, 38, 57);
            font-size: 18px;
            color: rgb(169, 169, 169);
            border-width: 0px;
        }
        .lightblue {
            width: 80px;
            height: 30px;
            background-color: rgb(92, 150, 217);
            font-size: 14px;
            color: #ffffff;
            border-width: 0px;
        }
        table {
            width: 90%;
            height: 10%;
            border-width: 0;
            text-align: center;
        }
        .headline {
            color: #516380;
        }  /* 表格标题文字颜色 */

        .firstline {
            background-color: #91a7bc;
        }  /* 表头行背景色 */

        .content {
            background-color: #dce1e3;
        }  /* 内容主题背景色 */
        .search-kuang {
            width: 220px;
            height: 30px;
            font-size: 14px;
            border-width: 0px;
        }
        .search-button {
            width: 60px;
            height: 30px;
            background-color: rgb(92, 150, 217);
            font-size: 14px;
            color: #ffffff;
            border-width: 0px;
        }
    </style>
</head>
<body>
<p align="right">
<%
    if(session.getAttribute("manager") == null)
    {
        out.print("<script>function filter(){alert(\"访问出错\");window.location=\"/login\";}</script>");
        out.print("<script>filter()</script>");
    }
    else {
        out.print("<a class=\"text\">欢迎您," + ((Manager) session.getAttribute("manager")).getName() + "</a>");
        out.print("\t<input type=\"button\" value=\"个人中心\" onclick=\"location.href='/manager_personal_page'\" class=\"lightblue\">");
        out.print("\t<input type = \"button\" onclick = \"manager_logout()\" value = \"注销\" class=\"lightblue\">");
    }
    out.print("\t<input type = \"button\" onclick = \"location.href='control_page'\" value = \"首页\" class=\"lightblue\">");
%>
</p>
<%--<p align="left">--%>
    <%--<a href="/control_page">首页</a>--%>
<%--</p>--%>
<br><br>
<p align="center">
    <input type="button" value="用户管理" onclick="location.href='/user_manage'" class="lightblue">
    &nbsp;&nbsp;
    <input type="button" value="封禁管理" onclick="location.href='/ban_user_manage'" class="lightblue">
    &nbsp;&nbsp;
    <input type="button" value="图书管理" onclick="location.href='/book_manage'" class="lightblue">
    &nbsp;&nbsp;
    <input type="button" value="类型管理" onclick="location.href='/category_manage'" class="lightblue">
    &nbsp;&nbsp;
    <input type="button" value="历史订单" onclick="location.href='/sold_book_manage'" class="lightblue">
</p>
</body>
</html>
<script>
    function manager_logout()
    {
        var select = confirm("是否确认注销？");
        if(select)
        {
            window.location="/manager_logout";
        }
    }
</script>

<%--<script>--%>
    <%--function filter()--%>
    <%--{--%>
        <%--alert("访问出错!");--%>
        <%--window.location("/login");--%>
    <%--}--%>
<%--</script>--%>