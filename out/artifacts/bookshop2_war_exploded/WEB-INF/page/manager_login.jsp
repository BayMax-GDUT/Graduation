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
    <meta content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>管理员登陆界面</title>
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
<body align="center">

<!-- action 决定选择的servlet(controller) -->
<form action = "submit_manager_login" method="post">

    <!-- 生成文本框（text） name用作servlet类获取参数 -->
    <h3 align="center">
        <%
        if(session.getAttribute("message") != null) {
            out.print(session.getAttribute("message"));
            session.removeAttribute("message");
        }
        else
            out.print("LOGIN");
        %>
    </h3>
    <br><br><input type="text" name="name" class="deepblue" placeholder="管理员账号">
    <br><br><input type="password" name="password" class="deepblue" placeholder="管理员密码">

    <!-- 提交按钮 -->
    <br><br><input type="submit" value="登陆" class="lightblue">
    &nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;
    <!--点击跳转按钮-->
    <input type="button" onclick="location.href='/add_manager'"  value="注册" class="lightblue">
</form>
</body>
</html>
