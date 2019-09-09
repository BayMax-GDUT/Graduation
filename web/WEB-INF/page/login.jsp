<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆界面</title>
</head>
<body align="center">

<input type="button" align = "right" onclick="location.href='/visitor_list'" value="游客模式">

<!-- action 决定选择的servlet(controller) -->
<form action = "submit_login" method="post">

    <!-- 生成文本框（text） name用作servlet类获取参数 -->
    <h1 align="center">${message}</h1><br>
    账号： <input type="text" name="name"><br>
    密码： <input type="password" name="password"><br><br>

    <!-- 提交按钮 -->
    <input type="submit" value="登陆">
    &nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;
    <!--点击跳转按钮-->
    <input type="button" onclick="location.href='/add_user'"  value="注册">
</form>
</body>
</html>
