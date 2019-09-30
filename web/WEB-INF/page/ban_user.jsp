<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/9
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="include_manager_login_message.jsp"%>
<html>
<head>
    <meta content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>Title</title>
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
<center>
<%--显示该用户信息，输入原因--%>
<form action="submit_ban_user">
<h4>id：${user.getId()}</h4>
<h4>姓名: ${user.getName()}</h4>
<h4>学校: ${user.getSchool()}</h4>
<h4>学号: ${user.getNumber()}</h4>
    <input type="hidden" name="id" value="${user.getId()}">
<input type="text" name="reason" value="" class="deepblue" placeholder="&nbsp;&nbsp;原因">
<br><br>
    <input type="submit" value="提交" class="lightblue">
</form>
</center>
</body>
</html>
