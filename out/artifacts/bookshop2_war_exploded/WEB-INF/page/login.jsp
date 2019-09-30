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
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>登陆界面</title>
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
<%--<br><br><br><br><br><br><br><br>--%>
<form action = "submit_login" method="post">

    <!-- 生成文本框（text） name用作servlet类获取参数 -->
    <h3><%
    if(session.getAttribute("message")==null)
        out.print("LOGIN");
    else
        out.print(session.getAttribute("message"));
        session.removeAttribute("message");
    %></h3>
    <br><br><input type="text" class="deepblue" name="name" placeholder="&nbsp;&nbsp;Username">
    <br><br><input type="password" class="deepblue" name="password" placeholder="&nbsp;&nbsp;Password">


    <!-- 提交按钮 -->
    <br><br><input type="submit" class="lightblue" value="登陆">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" class="lightblue" onclick="location.href='/add_user'" value="注册">
    <br><br><input type="button" class="lightblue" align = "right" onclick="location.href='/visitor_list'" value="游客模式">


</form>

&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
<!--点击跳转按钮-->
<!-- action 决定选择的servlet(controller) -->


</body>
</html>
