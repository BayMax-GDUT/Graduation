<%@ page import="bean.Manager" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/7
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="include_manager_login_message.jsp"%>
<html>
<head>
    <meta content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>管理员个人中心</title>
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
<body align = "center">
<center>
<%Manager manager = (Manager)session.getAttribute("manager");%>
    <form action="update_manager">
    <table border="1" cellspacing="0">
        <captain class="headline">个人信息</captain>
        <tr class="firstline">
            <td>属性</td>
            <td>值</td>
        </tr>
        <tr class="content">
            <td>id</td>
            <td><%=manager.getId()%></td>
        </tr>
        <tr class="content">
            <td>姓名</td>
            <td><%=manager.getName()%></td>
        </tr>
        <tr class="content">
            <td>密码</td>
            <td><input type="password" value="$<%=manager.getPassword()%>" name="password"></td>
        </tr>
        <tr class="content">
            <td>邮箱地址</td>
            <td><input type="text" value="<%=manager.getE_mail_address()%>" name="e_mail_address"></td>
        </tr>
        <tr class="content">
            <td>联系方式</td>
            <td><input type="text" value="<%=manager.getPhone_number()%>" name="phone_number"></td>
        </tr>
    </table>
        <input type="submit" onsubmit="return changeInformation()" value="确认更改" class="lightblue">
    </form>

</center>
</body>
</html>
